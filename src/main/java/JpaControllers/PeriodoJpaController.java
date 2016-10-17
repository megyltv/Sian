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
import Entidades.Periodo;
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
public class PeriodoJpaController implements Serializable {

    public PeriodoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Periodo periodo) {
        if (periodo.getInscripcionCollection() == null) {
            periodo.setInscripcionCollection(new ArrayList<Inscripcion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Inscripcion> attachedInscripcionCollection = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionCollectionInscripcionToAttach : periodo.getInscripcionCollection()) {
                inscripcionCollectionInscripcionToAttach = em.getReference(inscripcionCollectionInscripcionToAttach.getClass(), inscripcionCollectionInscripcionToAttach.getIdinscripcion());
                attachedInscripcionCollection.add(inscripcionCollectionInscripcionToAttach);
            }
            periodo.setInscripcionCollection(attachedInscripcionCollection);
            em.persist(periodo);
            for (Inscripcion inscripcionCollectionInscripcion : periodo.getInscripcionCollection()) {
                Periodo oldIdperiodoOfInscripcionCollectionInscripcion = inscripcionCollectionInscripcion.getIdperiodo();
                inscripcionCollectionInscripcion.setIdperiodo(periodo);
                inscripcionCollectionInscripcion = em.merge(inscripcionCollectionInscripcion);
                if (oldIdperiodoOfInscripcionCollectionInscripcion != null) {
                    oldIdperiodoOfInscripcionCollectionInscripcion.getInscripcionCollection().remove(inscripcionCollectionInscripcion);
                    oldIdperiodoOfInscripcionCollectionInscripcion = em.merge(oldIdperiodoOfInscripcionCollectionInscripcion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Periodo periodo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodo persistentPeriodo = em.find(Periodo.class, periodo.getIdperiodo());
//            Collection<Inscripcion> inscripcionCollectionOld = persistentPeriodo.getInscripcionCollection();
//            Collection<Inscripcion> inscripcionCollectionNew = periodo.getInscripcionCollection();
//            List<String> illegalOrphanMessages = null;
//            for (Inscripcion inscripcionCollectionOldInscripcion : inscripcionCollectionOld) {
//                if (!inscripcionCollectionNew.contains(inscripcionCollectionOldInscripcion)) {
//                    if (illegalOrphanMessages == null) {
//                        illegalOrphanMessages = new ArrayList<String>();
//                    }
//                    illegalOrphanMessages.add("You must retain Inscripcion " + inscripcionCollectionOldInscripcion + " since its idperiodo field is not nullable.");
//                }
//            }
//            if (illegalOrphanMessages != null) {
//                throw new IllegalOrphanException(illegalOrphanMessages);
//            }
//            Collection<Inscripcion> attachedInscripcionCollectionNew = new ArrayList<Inscripcion>();
//            for (Inscripcion inscripcionCollectionNewInscripcionToAttach : inscripcionCollectionNew) {
//                inscripcionCollectionNewInscripcionToAttach = em.getReference(inscripcionCollectionNewInscripcionToAttach.getClass(), inscripcionCollectionNewInscripcionToAttach.getIdinscripcion());
//                attachedInscripcionCollectionNew.add(inscripcionCollectionNewInscripcionToAttach);
//            }
//            inscripcionCollectionNew = attachedInscripcionCollectionNew;
//            periodo.setInscripcionCollection(inscripcionCollectionNew);
            periodo = em.merge(periodo);
//            for (Inscripcion inscripcionCollectionNewInscripcion : inscripcionCollectionNew) {
//                if (!inscripcionCollectionOld.contains(inscripcionCollectionNewInscripcion)) {
//                    Periodo oldIdperiodoOfInscripcionCollectionNewInscripcion = inscripcionCollectionNewInscripcion.getIdperiodo();
//                    inscripcionCollectionNewInscripcion.setIdperiodo(periodo);
//                    inscripcionCollectionNewInscripcion = em.merge(inscripcionCollectionNewInscripcion);
//                    if (oldIdperiodoOfInscripcionCollectionNewInscripcion != null && !oldIdperiodoOfInscripcionCollectionNewInscripcion.equals(periodo)) {
//                        oldIdperiodoOfInscripcionCollectionNewInscripcion.getInscripcionCollection().remove(inscripcionCollectionNewInscripcion);
//                        oldIdperiodoOfInscripcionCollectionNewInscripcion = em.merge(oldIdperiodoOfInscripcionCollectionNewInscripcion);
//                    }
//                }
//            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = periodo.getIdperiodo();
                if (findPeriodo(id) == null) {
                    throw new NonexistentEntityException("The periodo with id " + id + " no longer exists.");
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
            Periodo periodo;
            try {
                periodo = em.getReference(Periodo.class, id);
                periodo.getIdperiodo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Inscripcion> inscripcionCollectionOrphanCheck = periodo.getInscripcionCollection();
            for (Inscripcion inscripcionCollectionOrphanCheckInscripcion : inscripcionCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Periodo (" + periodo + ") cannot be destroyed since the Inscripcion " + inscripcionCollectionOrphanCheckInscripcion + " in its inscripcionCollection field has a non-nullable idperiodo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(periodo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Periodo> findPeriodoEntities() {
        return findPeriodoEntities(true, -1, -1);
    }

    public List<Periodo> findPeriodoEntities(int maxResults, int firstResult) {
        return findPeriodoEntities(false, maxResults, firstResult);
    }

    private List<Periodo> findPeriodoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Periodo.class));
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

    public Periodo findPeriodo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Periodo.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Periodo> rt = cq.from(Periodo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
