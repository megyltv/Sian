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
import Entidades.Preguntas;
import Entidades.Calificacion;
import Entidades.Estudiante;
import java.util.ArrayList;
import java.util.List;
import Entidades.Inscripcion;
import Entidades.PeriodoActual;
import JPAControllers.exceptions.IllegalOrphanException;
import JPAControllers.exceptions.NonexistentEntityException;
import JPAControllers.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Nathy Cumbicos
 */
public class EstudianteJpaController implements Serializable {

    public EstudianteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estudiante estudiante) throws PreexistingEntityException, Exception {
        if (estudiante.getCalificacionList() == null) {
            estudiante.setCalificacionList(new ArrayList<Calificacion>());
        }
        if (estudiante.getInscripcionList() == null) {
            estudiante.setInscripcionList(new ArrayList<Inscripcion>());
        }
        if (estudiante.getPeriodoActualList() == null) {
            estudiante.setPeriodoActualList(new ArrayList<PeriodoActual>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Preguntas idpreguntas = estudiante.getIdpreguntas();
            if (idpreguntas != null) {
                idpreguntas = em.getReference(idpreguntas.getClass(), idpreguntas.getIdpreguntas());
                estudiante.setIdpreguntas(idpreguntas);
            }
            List<Calificacion> attachedCalificacionList = new ArrayList<Calificacion>();
            for (Calificacion calificacionListCalificacionToAttach : estudiante.getCalificacionList()) {
                calificacionListCalificacionToAttach = em.getReference(calificacionListCalificacionToAttach.getClass(), calificacionListCalificacionToAttach.getIdcalificacion());
                attachedCalificacionList.add(calificacionListCalificacionToAttach);
            }
            estudiante.setCalificacionList(attachedCalificacionList);
            List<Inscripcion> attachedInscripcionList = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionListInscripcionToAttach : estudiante.getInscripcionList()) {
                inscripcionListInscripcionToAttach = em.getReference(inscripcionListInscripcionToAttach.getClass(), inscripcionListInscripcionToAttach.getIdinscripcion());
                attachedInscripcionList.add(inscripcionListInscripcionToAttach);
            }
            estudiante.setInscripcionList(attachedInscripcionList);
            List<PeriodoActual> attachedPeriodoActualList = new ArrayList<PeriodoActual>();
            for (PeriodoActual periodoActualListPeriodoActualToAttach : estudiante.getPeriodoActualList()) {
                periodoActualListPeriodoActualToAttach = em.getReference(periodoActualListPeriodoActualToAttach.getClass(), periodoActualListPeriodoActualToAttach.getIdperiodo());
                attachedPeriodoActualList.add(periodoActualListPeriodoActualToAttach);
            }
            estudiante.setPeriodoActualList(attachedPeriodoActualList);
            em.persist(estudiante);
            if (idpreguntas != null) {
                idpreguntas.getEstudianteList().add(estudiante);
                idpreguntas = em.merge(idpreguntas);
            }
            for (Calificacion calificacionListCalificacion : estudiante.getCalificacionList()) {
                Estudiante oldCedulaOfCalificacionListCalificacion = calificacionListCalificacion.getCedula();
                calificacionListCalificacion.setCedula(estudiante);
                calificacionListCalificacion = em.merge(calificacionListCalificacion);
                if (oldCedulaOfCalificacionListCalificacion != null) {
                    oldCedulaOfCalificacionListCalificacion.getCalificacionList().remove(calificacionListCalificacion);
                    oldCedulaOfCalificacionListCalificacion = em.merge(oldCedulaOfCalificacionListCalificacion);
                }
            }
            for (Inscripcion inscripcionListInscripcion : estudiante.getInscripcionList()) {
                Estudiante oldCedulaOfInscripcionListInscripcion = inscripcionListInscripcion.getCedula();
                inscripcionListInscripcion.setCedula(estudiante);
                inscripcionListInscripcion = em.merge(inscripcionListInscripcion);
                if (oldCedulaOfInscripcionListInscripcion != null) {
                    oldCedulaOfInscripcionListInscripcion.getInscripcionList().remove(inscripcionListInscripcion);
                    oldCedulaOfInscripcionListInscripcion = em.merge(oldCedulaOfInscripcionListInscripcion);
                }
            }
            for (PeriodoActual periodoActualListPeriodoActual : estudiante.getPeriodoActualList()) {
                Estudiante oldCedulaOfPeriodoActualListPeriodoActual = periodoActualListPeriodoActual.getCedula();
                periodoActualListPeriodoActual.setCedula(estudiante);
                periodoActualListPeriodoActual = em.merge(periodoActualListPeriodoActual);
                if (oldCedulaOfPeriodoActualListPeriodoActual != null) {
                    oldCedulaOfPeriodoActualListPeriodoActual.getPeriodoActualList().remove(periodoActualListPeriodoActual);
                    oldCedulaOfPeriodoActualListPeriodoActual = em.merge(oldCedulaOfPeriodoActualListPeriodoActual);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEstudiante(estudiante.getCedula()) != null) {
                throw new PreexistingEntityException("Estudiante " + estudiante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estudiante estudiante) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante persistentEstudiante = em.find(Estudiante.class, estudiante.getCedula());
            Preguntas idpreguntasOld = persistentEstudiante.getIdpreguntas();
            Preguntas idpreguntasNew = estudiante.getIdpreguntas();
            List<Calificacion> calificacionListOld = persistentEstudiante.getCalificacionList();
            List<Calificacion> calificacionListNew = estudiante.getCalificacionList();
            List<Inscripcion> inscripcionListOld = persistentEstudiante.getInscripcionList();
            List<Inscripcion> inscripcionListNew = estudiante.getInscripcionList();
            List<PeriodoActual> periodoActualListOld = persistentEstudiante.getPeriodoActualList();
            List<PeriodoActual> periodoActualListNew = estudiante.getPeriodoActualList();
            List<String> illegalOrphanMessages = null;
            for (Calificacion calificacionListOldCalificacion : calificacionListOld) {
                if (!calificacionListNew.contains(calificacionListOldCalificacion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Calificacion " + calificacionListOldCalificacion + " since its cedula field is not nullable.");
                }
            }
            for (Inscripcion inscripcionListOldInscripcion : inscripcionListOld) {
                if (!inscripcionListNew.contains(inscripcionListOldInscripcion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Inscripcion " + inscripcionListOldInscripcion + " since its cedula field is not nullable.");
                }
            }
            for (PeriodoActual periodoActualListOldPeriodoActual : periodoActualListOld) {
                if (!periodoActualListNew.contains(periodoActualListOldPeriodoActual)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PeriodoActual " + periodoActualListOldPeriodoActual + " since its cedula field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idpreguntasNew != null) {
                idpreguntasNew = em.getReference(idpreguntasNew.getClass(), idpreguntasNew.getIdpreguntas());
                estudiante.setIdpreguntas(idpreguntasNew);
            }
            List<Calificacion> attachedCalificacionListNew = new ArrayList<Calificacion>();
            for (Calificacion calificacionListNewCalificacionToAttach : calificacionListNew) {
                calificacionListNewCalificacionToAttach = em.getReference(calificacionListNewCalificacionToAttach.getClass(), calificacionListNewCalificacionToAttach.getIdcalificacion());
                attachedCalificacionListNew.add(calificacionListNewCalificacionToAttach);
            }
            calificacionListNew = attachedCalificacionListNew;
            estudiante.setCalificacionList(calificacionListNew);
            List<Inscripcion> attachedInscripcionListNew = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionListNewInscripcionToAttach : inscripcionListNew) {
                inscripcionListNewInscripcionToAttach = em.getReference(inscripcionListNewInscripcionToAttach.getClass(), inscripcionListNewInscripcionToAttach.getIdinscripcion());
                attachedInscripcionListNew.add(inscripcionListNewInscripcionToAttach);
            }
            inscripcionListNew = attachedInscripcionListNew;
            estudiante.setInscripcionList(inscripcionListNew);
            List<PeriodoActual> attachedPeriodoActualListNew = new ArrayList<PeriodoActual>();
            for (PeriodoActual periodoActualListNewPeriodoActualToAttach : periodoActualListNew) {
                periodoActualListNewPeriodoActualToAttach = em.getReference(periodoActualListNewPeriodoActualToAttach.getClass(), periodoActualListNewPeriodoActualToAttach.getIdperiodo());
                attachedPeriodoActualListNew.add(periodoActualListNewPeriodoActualToAttach);
            }
            periodoActualListNew = attachedPeriodoActualListNew;
            estudiante.setPeriodoActualList(periodoActualListNew);
            estudiante = em.merge(estudiante);
            if (idpreguntasOld != null && !idpreguntasOld.equals(idpreguntasNew)) {
                idpreguntasOld.getEstudianteList().remove(estudiante);
                idpreguntasOld = em.merge(idpreguntasOld);
            }
            if (idpreguntasNew != null && !idpreguntasNew.equals(idpreguntasOld)) {
                idpreguntasNew.getEstudianteList().add(estudiante);
                idpreguntasNew = em.merge(idpreguntasNew);
            }
            for (Calificacion calificacionListNewCalificacion : calificacionListNew) {
                if (!calificacionListOld.contains(calificacionListNewCalificacion)) {
                    Estudiante oldCedulaOfCalificacionListNewCalificacion = calificacionListNewCalificacion.getCedula();
                    calificacionListNewCalificacion.setCedula(estudiante);
                    calificacionListNewCalificacion = em.merge(calificacionListNewCalificacion);
                    if (oldCedulaOfCalificacionListNewCalificacion != null && !oldCedulaOfCalificacionListNewCalificacion.equals(estudiante)) {
                        oldCedulaOfCalificacionListNewCalificacion.getCalificacionList().remove(calificacionListNewCalificacion);
                        oldCedulaOfCalificacionListNewCalificacion = em.merge(oldCedulaOfCalificacionListNewCalificacion);
                    }
                }
            }
            for (Inscripcion inscripcionListNewInscripcion : inscripcionListNew) {
                if (!inscripcionListOld.contains(inscripcionListNewInscripcion)) {
                    Estudiante oldCedulaOfInscripcionListNewInscripcion = inscripcionListNewInscripcion.getCedula();
                    inscripcionListNewInscripcion.setCedula(estudiante);
                    inscripcionListNewInscripcion = em.merge(inscripcionListNewInscripcion);
                    if (oldCedulaOfInscripcionListNewInscripcion != null && !oldCedulaOfInscripcionListNewInscripcion.equals(estudiante)) {
                        oldCedulaOfInscripcionListNewInscripcion.getInscripcionList().remove(inscripcionListNewInscripcion);
                        oldCedulaOfInscripcionListNewInscripcion = em.merge(oldCedulaOfInscripcionListNewInscripcion);
                    }
                }
            }
            for (PeriodoActual periodoActualListNewPeriodoActual : periodoActualListNew) {
                if (!periodoActualListOld.contains(periodoActualListNewPeriodoActual)) {
                    Estudiante oldCedulaOfPeriodoActualListNewPeriodoActual = periodoActualListNewPeriodoActual.getCedula();
                    periodoActualListNewPeriodoActual.setCedula(estudiante);
                    periodoActualListNewPeriodoActual = em.merge(periodoActualListNewPeriodoActual);
                    if (oldCedulaOfPeriodoActualListNewPeriodoActual != null && !oldCedulaOfPeriodoActualListNewPeriodoActual.equals(estudiante)) {
                        oldCedulaOfPeriodoActualListNewPeriodoActual.getPeriodoActualList().remove(periodoActualListNewPeriodoActual);
                        oldCedulaOfPeriodoActualListNewPeriodoActual = em.merge(oldCedulaOfPeriodoActualListNewPeriodoActual);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estudiante.getCedula();
                if (findEstudiante(id) == null) {
                    throw new NonexistentEntityException("The estudiante with id " + id + " no longer exists.");
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
            Estudiante estudiante;
            try {
                estudiante = em.getReference(Estudiante.class, id);
                estudiante.getCedula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estudiante with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Calificacion> calificacionListOrphanCheck = estudiante.getCalificacionList();
            for (Calificacion calificacionListOrphanCheckCalificacion : calificacionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estudiante (" + estudiante + ") cannot be destroyed since the Calificacion " + calificacionListOrphanCheckCalificacion + " in its calificacionList field has a non-nullable cedula field.");
            }
            List<Inscripcion> inscripcionListOrphanCheck = estudiante.getInscripcionList();
            for (Inscripcion inscripcionListOrphanCheckInscripcion : inscripcionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estudiante (" + estudiante + ") cannot be destroyed since the Inscripcion " + inscripcionListOrphanCheckInscripcion + " in its inscripcionList field has a non-nullable cedula field.");
            }
            List<PeriodoActual> periodoActualListOrphanCheck = estudiante.getPeriodoActualList();
            for (PeriodoActual periodoActualListOrphanCheckPeriodoActual : periodoActualListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estudiante (" + estudiante + ") cannot be destroyed since the PeriodoActual " + periodoActualListOrphanCheckPeriodoActual + " in its periodoActualList field has a non-nullable cedula field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Preguntas idpreguntas = estudiante.getIdpreguntas();
            if (idpreguntas != null) {
                idpreguntas.getEstudianteList().remove(estudiante);
                idpreguntas = em.merge(idpreguntas);
            }
            em.remove(estudiante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estudiante> findEstudianteEntities() {
        return findEstudianteEntities(true, -1, -1);
    }

    public List<Estudiante> findEstudianteEntities(int maxResults, int firstResult) {
        return findEstudianteEntities(false, maxResults, firstResult);
    }

    private List<Estudiante> findEstudianteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estudiante.class));
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

    public Estudiante findEstudiante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estudiante.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstudianteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estudiante> rt = cq.from(Estudiante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
