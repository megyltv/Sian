/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JpaControllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.PeriodoActual;
import Entidades.Materia;
import Entidades.Nivel;
import JpaControllers.exceptions.IllegalOrphanException;
import JpaControllers.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Megan
 */
public class NivelJpaController implements Serializable {

    public NivelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nivel nivel) {
        if (nivel.getMateriaList() == null) {
            nivel.setMateriaList(new ArrayList<Materia>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PeriodoActual idperiodo = nivel.getIdperiodo();
            if (idperiodo != null) {
                idperiodo = em.getReference(idperiodo.getClass(), idperiodo.getIdperiodo());
                nivel.setIdperiodo(idperiodo);
            }
            List<Materia> attachedMateriaList = new ArrayList<Materia>();
            for (Materia materiaListMateriaToAttach : nivel.getMateriaList()) {
                materiaListMateriaToAttach = em.getReference(materiaListMateriaToAttach.getClass(), materiaListMateriaToAttach.getIdmateria());
                attachedMateriaList.add(materiaListMateriaToAttach);
            }
            nivel.setMateriaList(attachedMateriaList);
            em.persist(nivel);
            if (idperiodo != null) {
                idperiodo.getNivelList().add(nivel);
                idperiodo = em.merge(idperiodo);
            }
            for (Materia materiaListMateria : nivel.getMateriaList()) {
                Nivel oldIdnivelOfMateriaListMateria = materiaListMateria.getIdnivel();
                materiaListMateria.setIdnivel(nivel);
                materiaListMateria = em.merge(materiaListMateria);
                if (oldIdnivelOfMateriaListMateria != null) {
                    oldIdnivelOfMateriaListMateria.getMateriaList().remove(materiaListMateria);
                    oldIdnivelOfMateriaListMateria = em.merge(oldIdnivelOfMateriaListMateria);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nivel nivel) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nivel persistentNivel = em.find(Nivel.class, nivel.getIdnivel());
            PeriodoActual idperiodoOld = persistentNivel.getIdperiodo();
            PeriodoActual idperiodoNew = nivel.getIdperiodo();
            List<Materia> materiaListOld = persistentNivel.getMateriaList();
            List<Materia> materiaListNew = nivel.getMateriaList();
            List<String> illegalOrphanMessages = null;
            for (Materia materiaListOldMateria : materiaListOld) {
                if (!materiaListNew.contains(materiaListOldMateria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Materia " + materiaListOldMateria + " since its idnivel field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idperiodoNew != null) {
                idperiodoNew = em.getReference(idperiodoNew.getClass(), idperiodoNew.getIdperiodo());
                nivel.setIdperiodo(idperiodoNew);
            }
            List<Materia> attachedMateriaListNew = new ArrayList<Materia>();
            for (Materia materiaListNewMateriaToAttach : materiaListNew) {
                materiaListNewMateriaToAttach = em.getReference(materiaListNewMateriaToAttach.getClass(), materiaListNewMateriaToAttach.getIdmateria());
                attachedMateriaListNew.add(materiaListNewMateriaToAttach);
            }
            materiaListNew = attachedMateriaListNew;
            nivel.setMateriaList(materiaListNew);
            nivel = em.merge(nivel);
            if (idperiodoOld != null && !idperiodoOld.equals(idperiodoNew)) {
                idperiodoOld.getNivelList().remove(nivel);
                idperiodoOld = em.merge(idperiodoOld);
            }
            if (idperiodoNew != null && !idperiodoNew.equals(idperiodoOld)) {
                idperiodoNew.getNivelList().add(nivel);
                idperiodoNew = em.merge(idperiodoNew);
            }
            for (Materia materiaListNewMateria : materiaListNew) {
                if (!materiaListOld.contains(materiaListNewMateria)) {
                    Nivel oldIdnivelOfMateriaListNewMateria = materiaListNewMateria.getIdnivel();
                    materiaListNewMateria.setIdnivel(nivel);
                    materiaListNewMateria = em.merge(materiaListNewMateria);
                    if (oldIdnivelOfMateriaListNewMateria != null && !oldIdnivelOfMateriaListNewMateria.equals(nivel)) {
                        oldIdnivelOfMateriaListNewMateria.getMateriaList().remove(materiaListNewMateria);
                        oldIdnivelOfMateriaListNewMateria = em.merge(oldIdnivelOfMateriaListNewMateria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = nivel.getIdnivel();
                if (findNivel(id) == null) {
                    throw new NonexistentEntityException("The nivel with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nivel nivel;
            try {
                nivel = em.getReference(Nivel.class, id);
                nivel.getIdnivel();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nivel with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Materia> materiaListOrphanCheck = nivel.getMateriaList();
            for (Materia materiaListOrphanCheckMateria : materiaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Nivel (" + nivel + ") cannot be destroyed since the Materia " + materiaListOrphanCheckMateria + " in its materiaList field has a non-nullable idnivel field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            PeriodoActual idperiodo = nivel.getIdperiodo();
            if (idperiodo != null) {
                idperiodo.getNivelList().remove(nivel);
                idperiodo = em.merge(idperiodo);
            }
            em.remove(nivel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nivel> findNivelEntities() {
        return findNivelEntities(true, -1, -1);
    }

    public List<Nivel> findNivelEntities(int maxResults, int firstResult) {
        return findNivelEntities(false, maxResults, firstResult);
    }

    private List<Nivel> findNivelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nivel.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Nivel findNivel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nivel.class, id);
        } finally {
            em.close();
        }
    }

    public int getNivelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nivel> rt = cq.from(Nivel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
