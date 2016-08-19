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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Megan
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
        if (periodo.getInscripcionList() == null) {
            periodo.setInscripcionList(new ArrayList<Inscripcion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Inscripcion> attachedInscripcionList = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionListInscripcionToAttach : periodo.getInscripcionList()) {
                inscripcionListInscripcionToAttach = em.getReference(inscripcionListInscripcionToAttach.getClass(), inscripcionListInscripcionToAttach.getIdinscripcion());
                attachedInscripcionList.add(inscripcionListInscripcionToAttach);
            }
            periodo.setInscripcionList(attachedInscripcionList);
            em.persist(periodo);
            for (Inscripcion inscripcionListInscripcion : periodo.getInscripcionList()) {
                Periodo oldIdperiodoOfInscripcionListInscripcion = inscripcionListInscripcion.getIdperiodo();
                inscripcionListInscripcion.setIdperiodo(periodo);
                inscripcionListInscripcion = em.merge(inscripcionListInscripcion);
                if (oldIdperiodoOfInscripcionListInscripcion != null) {
                    oldIdperiodoOfInscripcionListInscripcion.getInscripcionList().remove(inscripcionListInscripcion);
                    oldIdperiodoOfInscripcionListInscripcion = em.merge(oldIdperiodoOfInscripcionListInscripcion);
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
//            List<Inscripcion> inscripcionListOld = persistentPeriodo.getInscripcionList();
//            List<Inscripcion> inscripcionListNew = periodo.getInscripcionList();
//            List<String> illegalOrphanMessages = null;
//            for (Inscripcion inscripcionListOldInscripcion : inscripcionListOld) {
//                if (!inscripcionListNew.contains(inscripcionListOldInscripcion)) {
//                    if (illegalOrphanMessages == null) {
//                        illegalOrphanMessages = new ArrayList<String>();
//                    }
//                    illegalOrphanMessages.add("You must retain Inscripcion " + inscripcionListOldInscripcion + " since its idperiodo field is not nullable.");
//                }
//            }
//            if (illegalOrphanMessages != null) {
//                throw new IllegalOrphanException(illegalOrphanMessages);
//            }
//            List<Inscripcion> attachedInscripcionListNew = new ArrayList<Inscripcion>();
//            for (Inscripcion inscripcionListNewInscripcionToAttach : inscripcionListNew) {
//                inscripcionListNewInscripcionToAttach = em.getReference(inscripcionListNewInscripcionToAttach.getClass(), inscripcionListNewInscripcionToAttach.getIdinscripcion());
//                attachedInscripcionListNew.add(inscripcionListNewInscripcionToAttach);
//            }
//            inscripcionListNew = attachedInscripcionListNew;
//            periodo.setInscripcionList(inscripcionListNew);
            periodo = em.merge(periodo);
//            for (Inscripcion inscripcionListNewInscripcion : inscripcionListNew) {
//                if (!inscripcionListOld.contains(inscripcionListNewInscripcion)) {
//                    Periodo oldIdperiodoOfInscripcionListNewInscripcion = inscripcionListNewInscripcion.getIdperiodo();
//                    inscripcionListNewInscripcion.setIdperiodo(periodo);
//                    inscripcionListNewInscripcion = em.merge(inscripcionListNewInscripcion);
//                    if (oldIdperiodoOfInscripcionListNewInscripcion != null && !oldIdperiodoOfInscripcionListNewInscripcion.equals(periodo)) {
//                        oldIdperiodoOfInscripcionListNewInscripcion.getInscripcionList().remove(inscripcionListNewInscripcion);
//                        oldIdperiodoOfInscripcionListNewInscripcion = em.merge(oldIdperiodoOfInscripcionListNewInscripcion);
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
            List<Inscripcion> inscripcionListOrphanCheck = periodo.getInscripcionList();
            for (Inscripcion inscripcionListOrphanCheckInscripcion : inscripcionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Periodo (" + periodo + ") cannot be destroyed since the Inscripcion " + inscripcionListOrphanCheckInscripcion + " in its inscripcionList field has a non-nullable idperiodo field.");
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
