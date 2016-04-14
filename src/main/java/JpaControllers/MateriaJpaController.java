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
import Entidades.Inscripcion;
import Entidades.Nivel;
import Entidades.Horariomateria;
import Entidades.Materia;
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
public class MateriaJpaController implements Serializable {

    public MateriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Materia materia) {
        if (materia.getHorariomateriaList() == null) {
            materia.setHorariomateriaList(new ArrayList<Horariomateria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inscripcion idinscripcion = materia.getIdinscripcion();
            if (idinscripcion != null) {
                idinscripcion = em.getReference(idinscripcion.getClass(), idinscripcion.getIdinscripcion());
                materia.setIdinscripcion(idinscripcion);
            }
            Nivel idnivel = materia.getIdnivel();
            if (idnivel != null) {
                idnivel = em.getReference(idnivel.getClass(), idnivel.getIdnivel());
                materia.setIdnivel(idnivel);
            }
            List<Horariomateria> attachedHorariomateriaList = new ArrayList<Horariomateria>();
            for (Horariomateria horariomateriaListHorariomateriaToAttach : materia.getHorariomateriaList()) {
                horariomateriaListHorariomateriaToAttach = em.getReference(horariomateriaListHorariomateriaToAttach.getClass(), horariomateriaListHorariomateriaToAttach.getHorariomateriaPK());
                attachedHorariomateriaList.add(horariomateriaListHorariomateriaToAttach);
            }
            materia.setHorariomateriaList(attachedHorariomateriaList);
            em.persist(materia);
            if (idinscripcion != null) {
                idinscripcion.getMateriaList().add(materia);
                idinscripcion = em.merge(idinscripcion);
            }
            if (idnivel != null) {
                idnivel.getMateriaList().add(materia);
                idnivel = em.merge(idnivel);
            }
            for (Horariomateria horariomateriaListHorariomateria : materia.getHorariomateriaList()) {
                Materia oldMateriaOfHorariomateriaListHorariomateria = horariomateriaListHorariomateria.getMateria();
                horariomateriaListHorariomateria.setMateria(materia);
                horariomateriaListHorariomateria = em.merge(horariomateriaListHorariomateria);
                if (oldMateriaOfHorariomateriaListHorariomateria != null) {
                    oldMateriaOfHorariomateriaListHorariomateria.getHorariomateriaList().remove(horariomateriaListHorariomateria);
                    oldMateriaOfHorariomateriaListHorariomateria = em.merge(oldMateriaOfHorariomateriaListHorariomateria);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Materia materia) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Materia persistentMateria = em.find(Materia.class, materia.getIdmateria());
            Inscripcion idinscripcionOld = persistentMateria.getIdinscripcion();
            Inscripcion idinscripcionNew = materia.getIdinscripcion();
            Nivel idnivelOld = persistentMateria.getIdnivel();
            Nivel idnivelNew = materia.getIdnivel();
            List<Horariomateria> horariomateriaListOld = persistentMateria.getHorariomateriaList();
            List<Horariomateria> horariomateriaListNew = materia.getHorariomateriaList();
            List<String> illegalOrphanMessages = null;
            for (Horariomateria horariomateriaListOldHorariomateria : horariomateriaListOld) {
                if (!horariomateriaListNew.contains(horariomateriaListOldHorariomateria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Horariomateria " + horariomateriaListOldHorariomateria + " since its materia field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idinscripcionNew != null) {
                idinscripcionNew = em.getReference(idinscripcionNew.getClass(), idinscripcionNew.getIdinscripcion());
                materia.setIdinscripcion(idinscripcionNew);
            }
            if (idnivelNew != null) {
                idnivelNew = em.getReference(idnivelNew.getClass(), idnivelNew.getIdnivel());
                materia.setIdnivel(idnivelNew);
            }
            List<Horariomateria> attachedHorariomateriaListNew = new ArrayList<Horariomateria>();
            for (Horariomateria horariomateriaListNewHorariomateriaToAttach : horariomateriaListNew) {
                horariomateriaListNewHorariomateriaToAttach = em.getReference(horariomateriaListNewHorariomateriaToAttach.getClass(), horariomateriaListNewHorariomateriaToAttach.getHorariomateriaPK());
                attachedHorariomateriaListNew.add(horariomateriaListNewHorariomateriaToAttach);
            }
            horariomateriaListNew = attachedHorariomateriaListNew;
            materia.setHorariomateriaList(horariomateriaListNew);
            materia = em.merge(materia);
            if (idinscripcionOld != null && !idinscripcionOld.equals(idinscripcionNew)) {
                idinscripcionOld.getMateriaList().remove(materia);
                idinscripcionOld = em.merge(idinscripcionOld);
            }
            if (idinscripcionNew != null && !idinscripcionNew.equals(idinscripcionOld)) {
                idinscripcionNew.getMateriaList().add(materia);
                idinscripcionNew = em.merge(idinscripcionNew);
            }
            if (idnivelOld != null && !idnivelOld.equals(idnivelNew)) {
                idnivelOld.getMateriaList().remove(materia);
                idnivelOld = em.merge(idnivelOld);
            }
            if (idnivelNew != null && !idnivelNew.equals(idnivelOld)) {
                idnivelNew.getMateriaList().add(materia);
                idnivelNew = em.merge(idnivelNew);
            }
            for (Horariomateria horariomateriaListNewHorariomateria : horariomateriaListNew) {
                if (!horariomateriaListOld.contains(horariomateriaListNewHorariomateria)) {
                    Materia oldMateriaOfHorariomateriaListNewHorariomateria = horariomateriaListNewHorariomateria.getMateria();
                    horariomateriaListNewHorariomateria.setMateria(materia);
                    horariomateriaListNewHorariomateria = em.merge(horariomateriaListNewHorariomateria);
                    if (oldMateriaOfHorariomateriaListNewHorariomateria != null && !oldMateriaOfHorariomateriaListNewHorariomateria.equals(materia)) {
                        oldMateriaOfHorariomateriaListNewHorariomateria.getHorariomateriaList().remove(horariomateriaListNewHorariomateria);
                        oldMateriaOfHorariomateriaListNewHorariomateria = em.merge(oldMateriaOfHorariomateriaListNewHorariomateria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = materia.getIdmateria();
                if (findMateria(id) == null) {
                    throw new NonexistentEntityException("The materia with id " + id + " no longer exists.");
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
            Materia materia;
            try {
                materia = em.getReference(Materia.class, id);
                materia.getIdmateria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materia with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Horariomateria> horariomateriaListOrphanCheck = materia.getHorariomateriaList();
            for (Horariomateria horariomateriaListOrphanCheckHorariomateria : horariomateriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Materia (" + materia + ") cannot be destroyed since the Horariomateria " + horariomateriaListOrphanCheckHorariomateria + " in its horariomateriaList field has a non-nullable materia field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Inscripcion idinscripcion = materia.getIdinscripcion();
            if (idinscripcion != null) {
                idinscripcion.getMateriaList().remove(materia);
                idinscripcion = em.merge(idinscripcion);
            }
            Nivel idnivel = materia.getIdnivel();
            if (idnivel != null) {
                idnivel.getMateriaList().remove(materia);
                idnivel = em.merge(idnivel);
            }
            em.remove(materia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Materia> findMateriaEntities() {
        return findMateriaEntities(true, -1, -1);
    }

    public List<Materia> findMateriaEntities(int maxResults, int firstResult) {
        return findMateriaEntities(false, maxResults, firstResult);
    }

    private List<Materia> findMateriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Materia.class));
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

    public Materia findMateria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Materia.class, id);
        } finally {
            em.close();
        }
    }

    public int getMateriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Materia> rt = cq.from(Materia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
