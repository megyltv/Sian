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
import Entidades.Calificacion;
import Entidades.Estudiante;
import java.util.ArrayList;
import java.util.List;
import Entidades.Inscripcion;
import Entidades.Preguntas;
import JpaControllers.exceptions.IllegalOrphanException;
import JpaControllers.exceptions.NonexistentEntityException;
import JpaControllers.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Megan
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
        if (estudiante.getPreguntasList() == null) {
            estudiante.setPreguntasList(new ArrayList<Preguntas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
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
            List<Preguntas> attachedPreguntasList = new ArrayList<Preguntas>();
            for (Preguntas preguntasListPreguntasToAttach : estudiante.getPreguntasList()) {
                preguntasListPreguntasToAttach = em.getReference(preguntasListPreguntasToAttach.getClass(), preguntasListPreguntasToAttach.getIdpreguntas());
                attachedPreguntasList.add(preguntasListPreguntasToAttach);
            }
            estudiante.setPreguntasList(attachedPreguntasList);
            em.persist(estudiante);
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
            for (Preguntas preguntasListPreguntas : estudiante.getPreguntasList()) {
                Estudiante oldCedulaOfPreguntasListPreguntas = preguntasListPreguntas.getCedula();
                preguntasListPreguntas.setCedula(estudiante);
                preguntasListPreguntas = em.merge(preguntasListPreguntas);
                if (oldCedulaOfPreguntasListPreguntas != null) {
                    oldCedulaOfPreguntasListPreguntas.getPreguntasList().remove(preguntasListPreguntas);
                    oldCedulaOfPreguntasListPreguntas = em.merge(oldCedulaOfPreguntasListPreguntas);
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
            List<Calificacion> calificacionListOld = persistentEstudiante.getCalificacionList();
            List<Calificacion> calificacionListNew = estudiante.getCalificacionList();
            List<Inscripcion> inscripcionListOld = persistentEstudiante.getInscripcionList();
            List<Inscripcion> inscripcionListNew = estudiante.getInscripcionList();
            List<Preguntas> preguntasListOld = persistentEstudiante.getPreguntasList();
            List<Preguntas> preguntasListNew = estudiante.getPreguntasList();
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
            for (Preguntas preguntasListOldPreguntas : preguntasListOld) {
                if (!preguntasListNew.contains(preguntasListOldPreguntas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Preguntas " + preguntasListOldPreguntas + " since its cedula field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
            List<Preguntas> attachedPreguntasListNew = new ArrayList<Preguntas>();
            for (Preguntas preguntasListNewPreguntasToAttach : preguntasListNew) {
                preguntasListNewPreguntasToAttach = em.getReference(preguntasListNewPreguntasToAttach.getClass(), preguntasListNewPreguntasToAttach.getIdpreguntas());
                attachedPreguntasListNew.add(preguntasListNewPreguntasToAttach);
            }
            preguntasListNew = attachedPreguntasListNew;
            estudiante.setPreguntasList(preguntasListNew);
            estudiante = em.merge(estudiante);
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
            for (Preguntas preguntasListNewPreguntas : preguntasListNew) {
                if (!preguntasListOld.contains(preguntasListNewPreguntas)) {
                    Estudiante oldCedulaOfPreguntasListNewPreguntas = preguntasListNewPreguntas.getCedula();
                    preguntasListNewPreguntas.setCedula(estudiante);
                    preguntasListNewPreguntas = em.merge(preguntasListNewPreguntas);
                    if (oldCedulaOfPreguntasListNewPreguntas != null && !oldCedulaOfPreguntasListNewPreguntas.equals(estudiante)) {
                        oldCedulaOfPreguntasListNewPreguntas.getPreguntasList().remove(preguntasListNewPreguntas);
                        oldCedulaOfPreguntasListNewPreguntas = em.merge(oldCedulaOfPreguntasListNewPreguntas);
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
            List<Preguntas> preguntasListOrphanCheck = estudiante.getPreguntasList();
            for (Preguntas preguntasListOrphanCheckPreguntas : preguntasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estudiante (" + estudiante + ") cannot be destroyed since the Preguntas " + preguntasListOrphanCheckPreguntas + " in its preguntasList field has a non-nullable cedula field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
