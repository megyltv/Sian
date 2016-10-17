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
import JpaControllers.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Iker Gael
 */
public class MateriaJpaController implements Serializable {

    public MateriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Materia materia) throws PreexistingEntityException, Exception {
        if (materia.getHorarioMateriaCollection() == null) {
            materia.setHorarioMateriaCollection(new ArrayList<HorarioMateria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<HorarioMateria> attachedHorarioMateriaCollection = new ArrayList<HorarioMateria>();
            for (HorarioMateria horarioMateriaCollectionHorarioMateriaToAttach : materia.getHorarioMateriaCollection()) {
                horarioMateriaCollectionHorarioMateriaToAttach = em.getReference(horarioMateriaCollectionHorarioMateriaToAttach.getClass(), horarioMateriaCollectionHorarioMateriaToAttach.getIdmateriahorario());
                attachedHorarioMateriaCollection.add(horarioMateriaCollectionHorarioMateriaToAttach);
            }
            materia.setHorarioMateriaCollection(attachedHorarioMateriaCollection);
            em.persist(materia);
            for (HorarioMateria horarioMateriaCollectionHorarioMateria : materia.getHorarioMateriaCollection()) {
                Materia oldIdmateriaOfHorarioMateriaCollectionHorarioMateria = horarioMateriaCollectionHorarioMateria.getIdmateria();
                horarioMateriaCollectionHorarioMateria.setIdmateria(materia);
                horarioMateriaCollectionHorarioMateria = em.merge(horarioMateriaCollectionHorarioMateria);
                if (oldIdmateriaOfHorarioMateriaCollectionHorarioMateria != null) {
                    oldIdmateriaOfHorarioMateriaCollectionHorarioMateria.getHorarioMateriaCollection().remove(horarioMateriaCollectionHorarioMateria);
                    oldIdmateriaOfHorarioMateriaCollectionHorarioMateria = em.merge(oldIdmateriaOfHorarioMateriaCollectionHorarioMateria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMateria(materia.getIdmateria()) != null) {
                throw new PreexistingEntityException("Materia " + materia + " already exists.", ex);
            }
            throw ex;
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
            Collection<HorarioMateria> horarioMateriaCollectionOld = persistentMateria.getHorarioMateriaCollection();
            Collection<HorarioMateria> horarioMateriaCollectionNew = materia.getHorarioMateriaCollection();
            List<String> illegalOrphanMessages = null;
            for (HorarioMateria horarioMateriaCollectionOldHorarioMateria : horarioMateriaCollectionOld) {
                if (!horarioMateriaCollectionNew.contains(horarioMateriaCollectionOldHorarioMateria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HorarioMateria " + horarioMateriaCollectionOldHorarioMateria + " since its idmateria field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<HorarioMateria> attachedHorarioMateriaCollectionNew = new ArrayList<HorarioMateria>();
            for (HorarioMateria horarioMateriaCollectionNewHorarioMateriaToAttach : horarioMateriaCollectionNew) {
                horarioMateriaCollectionNewHorarioMateriaToAttach = em.getReference(horarioMateriaCollectionNewHorarioMateriaToAttach.getClass(), horarioMateriaCollectionNewHorarioMateriaToAttach.getIdmateriahorario());
                attachedHorarioMateriaCollectionNew.add(horarioMateriaCollectionNewHorarioMateriaToAttach);
            }
            horarioMateriaCollectionNew = attachedHorarioMateriaCollectionNew;
            materia.setHorarioMateriaCollection(horarioMateriaCollectionNew);
            materia = em.merge(materia);
            for (HorarioMateria horarioMateriaCollectionNewHorarioMateria : horarioMateriaCollectionNew) {
                if (!horarioMateriaCollectionOld.contains(horarioMateriaCollectionNewHorarioMateria)) {
                    Materia oldIdmateriaOfHorarioMateriaCollectionNewHorarioMateria = horarioMateriaCollectionNewHorarioMateria.getIdmateria();
                    horarioMateriaCollectionNewHorarioMateria.setIdmateria(materia);
                    horarioMateriaCollectionNewHorarioMateria = em.merge(horarioMateriaCollectionNewHorarioMateria);
                    if (oldIdmateriaOfHorarioMateriaCollectionNewHorarioMateria != null && !oldIdmateriaOfHorarioMateriaCollectionNewHorarioMateria.equals(materia)) {
                        oldIdmateriaOfHorarioMateriaCollectionNewHorarioMateria.getHorarioMateriaCollection().remove(horarioMateriaCollectionNewHorarioMateria);
                        oldIdmateriaOfHorarioMateriaCollectionNewHorarioMateria = em.merge(oldIdmateriaOfHorarioMateriaCollectionNewHorarioMateria);
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
            Collection<HorarioMateria> horarioMateriaCollectionOrphanCheck = materia.getHorarioMateriaCollection();
            for (HorarioMateria horarioMateriaCollectionOrphanCheckHorarioMateria : horarioMateriaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Materia (" + materia + ") cannot be destroyed since the HorarioMateria " + horarioMateriaCollectionOrphanCheckHorarioMateria + " in its horarioMateriaCollection field has a non-nullable idmateria field.");
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
