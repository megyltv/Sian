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
import Entidades.HorarioMateria;
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
        if (materia.getHorarioMateriaList() == null) {
            materia.setHorarioMateriaList(new ArrayList<HorarioMateria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<HorarioMateria> attachedHorarioMateriaList = new ArrayList<HorarioMateria>();
            for (HorarioMateria horarioMateriaListHorarioMateriaToAttach : materia.getHorarioMateriaList()) {
                horarioMateriaListHorarioMateriaToAttach = em.getReference(horarioMateriaListHorarioMateriaToAttach.getClass(), horarioMateriaListHorarioMateriaToAttach.getIdmateriahorario());
                attachedHorarioMateriaList.add(horarioMateriaListHorarioMateriaToAttach);
            }
            materia.setHorarioMateriaList(attachedHorarioMateriaList);
            em.persist(materia);
            for (HorarioMateria horarioMateriaListHorarioMateria : materia.getHorarioMateriaList()) {
                Materia oldIdmateriaOfHorarioMateriaListHorarioMateria = horarioMateriaListHorarioMateria.getIdmateria();
                horarioMateriaListHorarioMateria.setIdmateria(materia);
                horarioMateriaListHorarioMateria = em.merge(horarioMateriaListHorarioMateria);
                if (oldIdmateriaOfHorarioMateriaListHorarioMateria != null) {
                    oldIdmateriaOfHorarioMateriaListHorarioMateria.getHorarioMateriaList().remove(horarioMateriaListHorarioMateria);
                    oldIdmateriaOfHorarioMateriaListHorarioMateria = em.merge(oldIdmateriaOfHorarioMateriaListHorarioMateria);
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
            List<HorarioMateria> horarioMateriaListOld = persistentMateria.getHorarioMateriaList();
            List<HorarioMateria> horarioMateriaListNew = materia.getHorarioMateriaList();
            List<String> illegalOrphanMessages = null;
            for (HorarioMateria horarioMateriaListOldHorarioMateria : horarioMateriaListOld) {
                if (!horarioMateriaListNew.contains(horarioMateriaListOldHorarioMateria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HorarioMateria " + horarioMateriaListOldHorarioMateria + " since its idmateria field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<HorarioMateria> attachedHorarioMateriaListNew = new ArrayList<HorarioMateria>();
            for (HorarioMateria horarioMateriaListNewHorarioMateriaToAttach : horarioMateriaListNew) {
                horarioMateriaListNewHorarioMateriaToAttach = em.getReference(horarioMateriaListNewHorarioMateriaToAttach.getClass(), horarioMateriaListNewHorarioMateriaToAttach.getIdmateriahorario());
                attachedHorarioMateriaListNew.add(horarioMateriaListNewHorarioMateriaToAttach);
            }
            horarioMateriaListNew = attachedHorarioMateriaListNew;
            materia.setHorarioMateriaList(horarioMateriaListNew);
            materia = em.merge(materia);
            for (HorarioMateria horarioMateriaListNewHorarioMateria : horarioMateriaListNew) {
                if (!horarioMateriaListOld.contains(horarioMateriaListNewHorarioMateria)) {
                    Materia oldIdmateriaOfHorarioMateriaListNewHorarioMateria = horarioMateriaListNewHorarioMateria.getIdmateria();
                    horarioMateriaListNewHorarioMateria.setIdmateria(materia);
                    horarioMateriaListNewHorarioMateria = em.merge(horarioMateriaListNewHorarioMateria);
                    if (oldIdmateriaOfHorarioMateriaListNewHorarioMateria != null && !oldIdmateriaOfHorarioMateriaListNewHorarioMateria.equals(materia)) {
                        oldIdmateriaOfHorarioMateriaListNewHorarioMateria.getHorarioMateriaList().remove(horarioMateriaListNewHorarioMateria);
                        oldIdmateriaOfHorarioMateriaListNewHorarioMateria = em.merge(oldIdmateriaOfHorarioMateriaListNewHorarioMateria);
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
            List<HorarioMateria> horarioMateriaListOrphanCheck = materia.getHorarioMateriaList();
            for (HorarioMateria horarioMateriaListOrphanCheckHorarioMateria : horarioMateriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Materia (" + materia + ") cannot be destroyed since the HorarioMateria " + horarioMateriaListOrphanCheckHorarioMateria + " in its horarioMateriaList field has a non-nullable idmateria field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
