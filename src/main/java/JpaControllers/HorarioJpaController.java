/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JpaControllers;

import Entidades.Horario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.HorarioMateria;
import JpaControllers.exceptions.IllegalOrphanException;
import JpaControllers.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Iker Gael
 */
public class HorarioJpaController implements Serializable {

    public HorarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Horario horario) {
        if (horario.getHorarioMateriaCollection() == null) {
            horario.setHorarioMateriaCollection(new ArrayList<HorarioMateria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<HorarioMateria> attachedHorarioMateriaCollection = new ArrayList<HorarioMateria>();
            for (HorarioMateria horarioMateriaCollectionHorarioMateriaToAttach : horario.getHorarioMateriaCollection()) {
                horarioMateriaCollectionHorarioMateriaToAttach = em.getReference(horarioMateriaCollectionHorarioMateriaToAttach.getClass(), horarioMateriaCollectionHorarioMateriaToAttach.getIdmateriahorario());
                attachedHorarioMateriaCollection.add(horarioMateriaCollectionHorarioMateriaToAttach);
            }
            horario.setHorarioMateriaCollection(attachedHorarioMateriaCollection);
            em.persist(horario);
            for (HorarioMateria horarioMateriaCollectionHorarioMateria : horario.getHorarioMateriaCollection()) {
                Horario oldIdhorarioOfHorarioMateriaCollectionHorarioMateria = horarioMateriaCollectionHorarioMateria.getIdhorario();
                horarioMateriaCollectionHorarioMateria.setIdhorario(horario);
                horarioMateriaCollectionHorarioMateria = em.merge(horarioMateriaCollectionHorarioMateria);
                if (oldIdhorarioOfHorarioMateriaCollectionHorarioMateria != null) {
                    oldIdhorarioOfHorarioMateriaCollectionHorarioMateria.getHorarioMateriaCollection().remove(horarioMateriaCollectionHorarioMateria);
                    oldIdhorarioOfHorarioMateriaCollectionHorarioMateria = em.merge(oldIdhorarioOfHorarioMateriaCollectionHorarioMateria);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Horario horario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Horario persistentHorario = em.find(Horario.class, horario.getIdhorario());
            Collection<HorarioMateria> horarioMateriaCollectionOld = persistentHorario.getHorarioMateriaCollection();
            Collection<HorarioMateria> horarioMateriaCollectionNew = horario.getHorarioMateriaCollection();
            List<String> illegalOrphanMessages = null;
            for (HorarioMateria horarioMateriaCollectionOldHorarioMateria : horarioMateriaCollectionOld) {
                if (!horarioMateriaCollectionNew.contains(horarioMateriaCollectionOldHorarioMateria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HorarioMateria " + horarioMateriaCollectionOldHorarioMateria + " since its idhorario field is not nullable.");
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
            horario.setHorarioMateriaCollection(horarioMateriaCollectionNew);
            horario = em.merge(horario);
            for (HorarioMateria horarioMateriaCollectionNewHorarioMateria : horarioMateriaCollectionNew) {
                if (!horarioMateriaCollectionOld.contains(horarioMateriaCollectionNewHorarioMateria)) {
                    Horario oldIdhorarioOfHorarioMateriaCollectionNewHorarioMateria = horarioMateriaCollectionNewHorarioMateria.getIdhorario();
                    horarioMateriaCollectionNewHorarioMateria.setIdhorario(horario);
                    horarioMateriaCollectionNewHorarioMateria = em.merge(horarioMateriaCollectionNewHorarioMateria);
                    if (oldIdhorarioOfHorarioMateriaCollectionNewHorarioMateria != null && !oldIdhorarioOfHorarioMateriaCollectionNewHorarioMateria.equals(horario)) {
                        oldIdhorarioOfHorarioMateriaCollectionNewHorarioMateria.getHorarioMateriaCollection().remove(horarioMateriaCollectionNewHorarioMateria);
                        oldIdhorarioOfHorarioMateriaCollectionNewHorarioMateria = em.merge(oldIdhorarioOfHorarioMateriaCollectionNewHorarioMateria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = horario.getIdhorario();
                if (findHorario(id) == null) {
                    throw new NonexistentEntityException("The horario with id " + id + " no longer exists.");
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
            Horario horario;
            try {
                horario = em.getReference(Horario.class, id);
                horario.getIdhorario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The horario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<HorarioMateria> horarioMateriaCollectionOrphanCheck = horario.getHorarioMateriaCollection();
            for (HorarioMateria horarioMateriaCollectionOrphanCheckHorarioMateria : horarioMateriaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Horario (" + horario + ") cannot be destroyed since the HorarioMateria " + horarioMateriaCollectionOrphanCheckHorarioMateria + " in its horarioMateriaCollection field has a non-nullable idhorario field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(horario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Horario> findHorarioEntities() {
        return findHorarioEntities(true, -1, -1);
    }

    public List<Horario> findHorarioEntities(int maxResults, int firstResult) {
        return findHorarioEntities(false, maxResults, firstResult);
    }

    private List<Horario> findHorarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Horario.class));
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

    public Horario findHorario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Horario.class, id);
        } finally {
            em.close();
        }
    }

    public int getHorarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Horario> rt = cq.from(Horario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
