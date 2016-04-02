/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAControllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Estudiante;
import Entidades.Nivel;
import Entidades.PeriodoActual;
import JPAControllers.exceptions.IllegalOrphanException;
import JPAControllers.exceptions.NonexistentEntityException;
import JPAControllers.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Nathy Cumbicos
 */
public class PeriodoActualJpaController implements Serializable {

    public PeriodoActualJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PeriodoActual periodoActual) throws PreexistingEntityException, Exception {
        if (periodoActual.getNivelList() == null) {
            periodoActual.setNivelList(new ArrayList<Nivel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante cedula = periodoActual.getCedula();
            if (cedula != null) {
                cedula = em.getReference(cedula.getClass(), cedula.getCedula());
                periodoActual.setCedula(cedula);
            }
            List<Nivel> attachedNivelList = new ArrayList<Nivel>();
            for (Nivel nivelListNivelToAttach : periodoActual.getNivelList()) {
                nivelListNivelToAttach = em.getReference(nivelListNivelToAttach.getClass(), nivelListNivelToAttach.getIdnivel());
                attachedNivelList.add(nivelListNivelToAttach);
            }
            periodoActual.setNivelList(attachedNivelList);
            em.persist(periodoActual);
            if (cedula != null) {
                cedula.getPeriodoActualList().add(periodoActual);
                cedula = em.merge(cedula);
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
        } catch (Exception ex) {
            if (findPeriodoActual(periodoActual.getIdperiodo()) != null) {
                throw new PreexistingEntityException("PeriodoActual " + periodoActual + " already exists.", ex);
            }
            throw ex;
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
            Estudiante cedulaOld = persistentPeriodoActual.getCedula();
            Estudiante cedulaNew = periodoActual.getCedula();
            List<Nivel> nivelListOld = persistentPeriodoActual.getNivelList();
            List<Nivel> nivelListNew = periodoActual.getNivelList();
            List<String> illegalOrphanMessages = null;
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
            if (cedulaNew != null) {
                cedulaNew = em.getReference(cedulaNew.getClass(), cedulaNew.getCedula());
                periodoActual.setCedula(cedulaNew);
            }
            List<Nivel> attachedNivelListNew = new ArrayList<Nivel>();
            for (Nivel nivelListNewNivelToAttach : nivelListNew) {
                nivelListNewNivelToAttach = em.getReference(nivelListNewNivelToAttach.getClass(), nivelListNewNivelToAttach.getIdnivel());
                attachedNivelListNew.add(nivelListNewNivelToAttach);
            }
            nivelListNew = attachedNivelListNew;
            periodoActual.setNivelList(nivelListNew);
            periodoActual = em.merge(periodoActual);
            if (cedulaOld != null && !cedulaOld.equals(cedulaNew)) {
                cedulaOld.getPeriodoActualList().remove(periodoActual);
                cedulaOld = em.merge(cedulaOld);
            }
            if (cedulaNew != null && !cedulaNew.equals(cedulaOld)) {
                cedulaNew.getPeriodoActualList().add(periodoActual);
                cedulaNew = em.merge(cedulaNew);
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
            Estudiante cedula = periodoActual.getCedula();
            if (cedula != null) {
                cedula.getPeriodoActualList().remove(periodoActual);
                cedula = em.merge(cedula);
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
