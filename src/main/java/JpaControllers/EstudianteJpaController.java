/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JpaControllers;

import Entidades.Estudiante;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Inscripcion;
import java.util.ArrayList;
import java.util.List;
import Entidades.Preguntas;
import JpaControllers.exceptions.IllegalOrphanException;
import JpaControllers.exceptions.NonexistentEntityException;
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

    public void create(Estudiante estudiante) {
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
            for (Inscripcion inscripcionListInscripcion : estudiante.getInscripcionList()) {
                Estudiante oldIdestudianteOfInscripcionListInscripcion = inscripcionListInscripcion.getIdestudiante();
                inscripcionListInscripcion.setIdestudiante(estudiante);
                inscripcionListInscripcion = em.merge(inscripcionListInscripcion);
                if (oldIdestudianteOfInscripcionListInscripcion != null) {
                    oldIdestudianteOfInscripcionListInscripcion.getInscripcionList().remove(inscripcionListInscripcion);
                    oldIdestudianteOfInscripcionListInscripcion = em.merge(oldIdestudianteOfInscripcionListInscripcion);
                }
            }
            for (Preguntas preguntasListPreguntas : estudiante.getPreguntasList()) {
                Estudiante oldIdestudianteOfPreguntasListPreguntas = preguntasListPreguntas.getIdestudiante();
                preguntasListPreguntas.setIdestudiante(estudiante);
                preguntasListPreguntas = em.merge(preguntasListPreguntas);
                if (oldIdestudianteOfPreguntasListPreguntas != null) {
                    oldIdestudianteOfPreguntasListPreguntas.getPreguntasList().remove(preguntasListPreguntas);
                    oldIdestudianteOfPreguntasListPreguntas = em.merge(oldIdestudianteOfPreguntasListPreguntas);
                }
            }
            em.getTransaction().commit();
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
            Estudiante persistentEstudiante = em.find(Estudiante.class, estudiante.getIdestudiante());
//            List<Inscripcion> inscripcionListOld = persistentEstudiante.getInscripcionList();
//            List<Inscripcion> inscripcionListNew = estudiante.getInscripcionList();
//            List<Preguntas> preguntasListOld = persistentEstudiante.getPreguntasList();
//            List<Preguntas> preguntasListNew = estudiante.getPreguntasList();
//            List<String> illegalOrphanMessages = null;
//            for (Inscripcion inscripcionListOldInscripcion : inscripcionListOld) {
//                if (!inscripcionListNew.contains(inscripcionListOldInscripcion)) {
//                    if (illegalOrphanMessages == null) {
//                        illegalOrphanMessages = new ArrayList<String>();
//                    }
//                    illegalOrphanMessages.add("You must retain Inscripcion " + inscripcionListOldInscripcion + " since its idestudiante field is not nullable.");
//                }
//            }
//            for (Preguntas preguntasListOldPreguntas : preguntasListOld) {
//                if (!preguntasListNew.contains(preguntasListOldPreguntas)) {
//                    if (illegalOrphanMessages == null) {
//                        illegalOrphanMessages = new ArrayList<String>();
//                    }
//                    illegalOrphanMessages.add("You must retain Preguntas " + preguntasListOldPreguntas + " since its idestudiante field is not nullable.");
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
//            estudiante.setInscripcionList(inscripcionListNew);
//            List<Preguntas> attachedPreguntasListNew = new ArrayList<Preguntas>();
//            for (Preguntas preguntasListNewPreguntasToAttach : preguntasListNew) {
//                preguntasListNewPreguntasToAttach = em.getReference(preguntasListNewPreguntasToAttach.getClass(), preguntasListNewPreguntasToAttach.getIdpreguntas());
//                attachedPreguntasListNew.add(preguntasListNewPreguntasToAttach);
//            }
//            preguntasListNew = attachedPreguntasListNew;
//            estudiante.setPreguntasList(preguntasListNew);
            estudiante = em.merge(estudiante);
//            for (Inscripcion inscripcionListNewInscripcion : inscripcionListNew) {
//                if (!inscripcionListOld.contains(inscripcionListNewInscripcion)) {
//                    Estudiante oldIdestudianteOfInscripcionListNewInscripcion = inscripcionListNewInscripcion.getIdestudiante();
//                    inscripcionListNewInscripcion.setIdestudiante(estudiante);
//                    inscripcionListNewInscripcion = em.merge(inscripcionListNewInscripcion);
//                    if (oldIdestudianteOfInscripcionListNewInscripcion != null && !oldIdestudianteOfInscripcionListNewInscripcion.equals(estudiante)) {
//                        oldIdestudianteOfInscripcionListNewInscripcion.getInscripcionList().remove(inscripcionListNewInscripcion);
//                        oldIdestudianteOfInscripcionListNewInscripcion = em.merge(oldIdestudianteOfInscripcionListNewInscripcion);
//                    }
//                }
//            }
//            for (Preguntas preguntasListNewPreguntas : preguntasListNew) {
//                if (!preguntasListOld.contains(preguntasListNewPreguntas)) {
//                    Estudiante oldIdestudianteOfPreguntasListNewPreguntas = preguntasListNewPreguntas.getIdestudiante();
//                    preguntasListNewPreguntas.setIdestudiante(estudiante);
//                    preguntasListNewPreguntas = em.merge(preguntasListNewPreguntas);
//                    if (oldIdestudianteOfPreguntasListNewPreguntas != null && !oldIdestudianteOfPreguntasListNewPreguntas.equals(estudiante)) {
//                        oldIdestudianteOfPreguntasListNewPreguntas.getPreguntasList().remove(preguntasListNewPreguntas);
//                        oldIdestudianteOfPreguntasListNewPreguntas = em.merge(oldIdestudianteOfPreguntasListNewPreguntas);
//                    }
//                }
//            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estudiante.getIdestudiante();
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
                estudiante.getIdestudiante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estudiante with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Inscripcion> inscripcionListOrphanCheck = estudiante.getInscripcionList();
            for (Inscripcion inscripcionListOrphanCheckInscripcion : inscripcionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estudiante (" + estudiante + ") cannot be destroyed since the Inscripcion " + inscripcionListOrphanCheckInscripcion + " in its inscripcionList field has a non-nullable idestudiante field.");
            }
            List<Preguntas> preguntasListOrphanCheck = estudiante.getPreguntasList();
            for (Preguntas preguntasListOrphanCheckPreguntas : preguntasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estudiante (" + estudiante + ") cannot be destroyed since the Preguntas " + preguntasListOrphanCheckPreguntas + " in its preguntasList field has a non-nullable idestudiante field.");
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
