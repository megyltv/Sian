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
import java.util.ArrayList;
import java.util.List;
import Entidades.Nivel;
import Entidades.PeriodoActual;
import JpaControllers.exceptions.IllegalOrphanException;
import JpaControllers.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Megan
 */
public class PeriodoActualJpaController implements Serializable {

    public PeriodoActualJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PeriodoActual periodoActual) {
        if (periodoActual.getInscripcionList() == null) {
            periodoActual.setInscripcionList(new ArrayList<Inscripcion>());
        }
        if (periodoActual.getNivelList() == null) {
            periodoActual.setNivelList(new ArrayList<Nivel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Inscripcion> attachedInscripcionList = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionListInscripcionToAttach : periodoActual.getInscripcionList()) {
                inscripcionListInscripcionToAttach = em.getReference(inscripcionListInscripcionToAttach.getClass(), inscripcionListInscripcionToAttach.getIdinscripcion());
                attachedInscripcionList.add(inscripcionListInscripcionToAttach);
            }
            periodoActual.setInscripcionList(attachedInscripcionList);
            List<Nivel> attachedNivelList = new ArrayList<Nivel>();
            for (Nivel nivelListNivelToAttach : periodoActual.getNivelList()) {
                nivelListNivelToAttach = em.getReference(nivelListNivelToAttach.getClass(), nivelListNivelToAttach.getIdnivel());
                attachedNivelList.add(nivelListNivelToAttach);
            }
            periodoActual.setNivelList(attachedNivelList);
            em.persist(periodoActual);
            for (Inscripcion inscripcionListInscripcion : periodoActual.getInscripcionList()) {
                PeriodoActual oldIdperiodoOfInscripcionListInscripcion = inscripcionListInscripcion.getIdperiodo();
                inscripcionListInscripcion.setIdperiodo(periodoActual);
                inscripcionListInscripcion = em.merge(inscripcionListInscripcion);
                if (oldIdperiodoOfInscripcionListInscripcion != null) {
                    oldIdperiodoOfInscripcionListInscripcion.getInscripcionList().remove(inscripcionListInscripcion);
                    oldIdperiodoOfInscripcionListInscripcion = em.merge(oldIdperiodoOfInscripcionListInscripcion);
                }
            }
            for (Nivel nivelListNivel : periodoActual.getNivelList()) {
                PeriodoActual oldIdperiodoOfNivelListNivel = nivelListNivel.getIdperiodo();
                nivelListNivel.setIdperiodo(periodoActual);
                nivelListNivel = em.merge(nivelListNivel);
                if (oldIdperiodoOfNivelListNivel != null) {
                    oldIdperiodoOfNivelListNivel.getNivelList().remove(nivelListNivel);
                    oldIdperiodoOfNivelListNivel = em.merge(oldIdperiodoOfNivelListNivel);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PeriodoActual periodoActual) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PeriodoActual persistentPeriodoActual = em.find(PeriodoActual.class, periodoActual.getIdperiodo());
            List<Inscripcion> inscripcionListOld = persistentPeriodoActual.getInscripcionList();
            List<Inscripcion> inscripcionListNew = periodoActual.getInscripcionList();
            List<Nivel> nivelListOld = persistentPeriodoActual.getNivelList();
            List<Nivel> nivelListNew = periodoActual.getNivelList();
            List<String> illegalOrphanMessages = null;
            for (Inscripcion inscripcionListOldInscripcion : inscripcionListOld) {
                if (!inscripcionListNew.contains(inscripcionListOldInscripcion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Inscripcion " + inscripcionListOldInscripcion + " since its idperiodo field is not nullable.");
                }
            }
            for (Nivel nivelListOldNivel : nivelListOld) {
                if (!nivelListNew.contains(nivelListOldNivel)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Nivel " + nivelListOldNivel + " since its idperiodo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Inscripcion> attachedInscripcionListNew = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionListNewInscripcionToAttach : inscripcionListNew) {
                inscripcionListNewInscripcionToAttach = em.getReference(inscripcionListNewInscripcionToAttach.getClass(), inscripcionListNewInscripcionToAttach.getIdinscripcion());
                attachedInscripcionListNew.add(inscripcionListNewInscripcionToAttach);
            }
            inscripcionListNew = attachedInscripcionListNew;
            periodoActual.setInscripcionList(inscripcionListNew);
            List<Nivel> attachedNivelListNew = new ArrayList<Nivel>();
            for (Nivel nivelListNewNivelToAttach : nivelListNew) {
                nivelListNewNivelToAttach = em.getReference(nivelListNewNivelToAttach.getClass(), nivelListNewNivelToAttach.getIdnivel());
                attachedNivelListNew.add(nivelListNewNivelToAttach);
            }
            nivelListNew = attachedNivelListNew;
            periodoActual.setNivelList(nivelListNew);
            periodoActual = em.merge(periodoActual);
            for (Inscripcion inscripcionListNewInscripcion : inscripcionListNew) {
                if (!inscripcionListOld.contains(inscripcionListNewInscripcion)) {
                    PeriodoActual oldIdperiodoOfInscripcionListNewInscripcion = inscripcionListNewInscripcion.getIdperiodo();
                    inscripcionListNewInscripcion.setIdperiodo(periodoActual);
                    inscripcionListNewInscripcion = em.merge(inscripcionListNewInscripcion);
                    if (oldIdperiodoOfInscripcionListNewInscripcion != null && !oldIdperiodoOfInscripcionListNewInscripcion.equals(periodoActual)) {
                        oldIdperiodoOfInscripcionListNewInscripcion.getInscripcionList().remove(inscripcionListNewInscripcion);
                        oldIdperiodoOfInscripcionListNewInscripcion = em.merge(oldIdperiodoOfInscripcionListNewInscripcion);
                    }
                }
            }
            for (Nivel nivelListNewNivel : nivelListNew) {
                if (!nivelListOld.contains(nivelListNewNivel)) {
                    PeriodoActual oldIdperiodoOfNivelListNewNivel = nivelListNewNivel.getIdperiodo();
                    nivelListNewNivel.setIdperiodo(periodoActual);
                    nivelListNewNivel = em.merge(nivelListNewNivel);
                    if (oldIdperiodoOfNivelListNewNivel != null && !oldIdperiodoOfNivelListNewNivel.equals(periodoActual)) {
                        oldIdperiodoOfNivelListNewNivel.getNivelList().remove(nivelListNewNivel);
                        oldIdperiodoOfNivelListNewNivel = em.merge(oldIdperiodoOfNivelListNewNivel);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = periodoActual.getIdperiodo();
                if (findPeriodoActual(id) == null) {
                    throw new NonexistentEntityException("The periodoActual with id " + id + " no longer exists.");
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
            PeriodoActual periodoActual;
            try {
                periodoActual = em.getReference(PeriodoActual.class, id);
                periodoActual.getIdperiodo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodoActual with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Inscripcion> inscripcionListOrphanCheck = periodoActual.getInscripcionList();
            for (Inscripcion inscripcionListOrphanCheckInscripcion : inscripcionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PeriodoActual (" + periodoActual + ") cannot be destroyed since the Inscripcion " + inscripcionListOrphanCheckInscripcion + " in its inscripcionList field has a non-nullable idperiodo field.");
            }
            List<Nivel> nivelListOrphanCheck = periodoActual.getNivelList();
            for (Nivel nivelListOrphanCheckNivel : nivelListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This PeriodoActual (" + periodoActual + ") cannot be destroyed since the Nivel " + nivelListOrphanCheckNivel + " in its nivelList field has a non-nullable idperiodo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(periodoActual);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PeriodoActual> findPeriodoActualEntities() {
        return findPeriodoActualEntities(true, -1, -1);
    }

    public List<PeriodoActual> findPeriodoActualEntities(int maxResults, int firstResult) {
        return findPeriodoActualEntities(false, maxResults, firstResult);
    }

    private List<PeriodoActual> findPeriodoActualEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PeriodoActual.class));
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

    public PeriodoActual findPeriodoActual(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PeriodoActual.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodoActualCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PeriodoActual> rt = cq.from(PeriodoActual.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
