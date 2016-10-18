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
import java.util.Collection;
import Entidades.Preguntas;
import JpaControllers.exceptions.IllegalOrphanException;
import JpaControllers.exceptions.NonexistentEntityException;
import JpaControllers.exceptions.PreexistingEntityException;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> master
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Iker Gael
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
<<<<<<< HEAD
        if (estudiante.getInscripcionCollection() == null) {
            estudiante.setInscripcionCollection(new ArrayList<Inscripcion>());
=======
        if (estudiante.getInscripcionList() == null) {
            estudiante.setInscripcionList(new ArrayList<Inscripcion>());
>>>>>>> master
        }
        if (estudiante.getPreguntasCollection() == null) {
            estudiante.setPreguntasCollection(new ArrayList<Preguntas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Inscripcion> attachedInscripcionCollection = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionCollectionInscripcionToAttach : estudiante.getInscripcionCollection()) {
                inscripcionCollectionInscripcionToAttach = em.getReference(inscripcionCollectionInscripcionToAttach.getClass(), inscripcionCollectionInscripcionToAttach.getIdinscripcion());
                attachedInscripcionCollection.add(inscripcionCollectionInscripcionToAttach);
            }
            estudiante.setInscripcionCollection(attachedInscripcionCollection);
            Collection<Preguntas> attachedPreguntasCollection = new ArrayList<Preguntas>();
            for (Preguntas preguntasCollectionPreguntasToAttach : estudiante.getPreguntasCollection()) {
                preguntasCollectionPreguntasToAttach = em.getReference(preguntasCollectionPreguntasToAttach.getClass(), preguntasCollectionPreguntasToAttach.getIdpreguntas());
                attachedPreguntasCollection.add(preguntasCollectionPreguntasToAttach);
            }
            estudiante.setPreguntasCollection(attachedPreguntasCollection);
            em.persist(estudiante);
            for (Inscripcion inscripcionCollectionInscripcion : estudiante.getInscripcionCollection()) {
                Estudiante oldIdestudianteOfInscripcionCollectionInscripcion = inscripcionCollectionInscripcion.getIdestudiante();
                inscripcionCollectionInscripcion.setIdestudiante(estudiante);
                inscripcionCollectionInscripcion = em.merge(inscripcionCollectionInscripcion);
                if (oldIdestudianteOfInscripcionCollectionInscripcion != null) {
                    oldIdestudianteOfInscripcionCollectionInscripcion.getInscripcionCollection().remove(inscripcionCollectionInscripcion);
                    oldIdestudianteOfInscripcionCollectionInscripcion = em.merge(oldIdestudianteOfInscripcionCollectionInscripcion);
                }
            }
            for (Preguntas preguntasCollectionPreguntas : estudiante.getPreguntasCollection()) {
                Estudiante oldIdestudianteOfPreguntasCollectionPreguntas = preguntasCollectionPreguntas.getIdestudiante();
                preguntasCollectionPreguntas.setIdestudiante(estudiante);
                preguntasCollectionPreguntas = em.merge(preguntasCollectionPreguntas);
                if (oldIdestudianteOfPreguntasCollectionPreguntas != null) {
                    oldIdestudianteOfPreguntasCollectionPreguntas.getPreguntasCollection().remove(preguntasCollectionPreguntas);
                    oldIdestudianteOfPreguntasCollectionPreguntas = em.merge(oldIdestudianteOfPreguntasCollectionPreguntas);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEstudiante(estudiante.getIdestudiante()) != null) {
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
            Estudiante persistentEstudiante = em.find(Estudiante.class, estudiante.getIdestudiante());
<<<<<<< HEAD
            Collection<Inscripcion> inscripcionCollectionOld = persistentEstudiante.getInscripcionCollection();
            Collection<Inscripcion> inscripcionCollectionNew = estudiante.getInscripcionCollection();
            Collection<Preguntas> preguntasCollectionOld = persistentEstudiante.getPreguntasCollection();
            Collection<Preguntas> preguntasCollectionNew = estudiante.getPreguntasCollection();
            List<String> illegalOrphanMessages = null;
            for (Inscripcion inscripcionCollectionOldInscripcion : inscripcionCollectionOld) {
                if (!inscripcionCollectionNew.contains(inscripcionCollectionOldInscripcion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Inscripcion " + inscripcionCollectionOldInscripcion + " since its idestudiante field is not nullable.");
                }
            }
            for (Preguntas preguntasCollectionOldPreguntas : preguntasCollectionOld) {
                if (!preguntasCollectionNew.contains(preguntasCollectionOldPreguntas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Preguntas " + preguntasCollectionOldPreguntas + " since its idestudiante field is not nullable.");
=======
            List<Inscripcion> inscripcionListOld = persistentEstudiante.getInscripcionList();
            List<Inscripcion> inscripcionListNew = estudiante.getInscripcionList();
            List<Preguntas> preguntasListOld = persistentEstudiante.getPreguntasList();
            List<Preguntas> preguntasListNew = estudiante.getPreguntasList();
            List<String> illegalOrphanMessages = null;
            for (Inscripcion inscripcionListOldInscripcion : inscripcionListOld) {
                if (!inscripcionListNew.contains(inscripcionListOldInscripcion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Inscripcion " + inscripcionListOldInscripcion + " since its idestudiante field is not nullable.");
                }
            }
            for (Preguntas preguntasListOldPreguntas : preguntasListOld) {
                if (!preguntasListNew.contains(preguntasListOldPreguntas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Preguntas " + preguntasListOldPreguntas + " since its idestudiante field is not nullable.");
>>>>>>> master
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
<<<<<<< HEAD
            Collection<Inscripcion> attachedInscripcionCollectionNew = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionCollectionNewInscripcionToAttach : inscripcionCollectionNew) {
                inscripcionCollectionNewInscripcionToAttach = em.getReference(inscripcionCollectionNewInscripcionToAttach.getClass(), inscripcionCollectionNewInscripcionToAttach.getIdinscripcion());
                attachedInscripcionCollectionNew.add(inscripcionCollectionNewInscripcionToAttach);
            }
            inscripcionCollectionNew = attachedInscripcionCollectionNew;
            estudiante.setInscripcionCollection(inscripcionCollectionNew);
            Collection<Preguntas> attachedPreguntasCollectionNew = new ArrayList<Preguntas>();
            for (Preguntas preguntasCollectionNewPreguntasToAttach : preguntasCollectionNew) {
                preguntasCollectionNewPreguntasToAttach = em.getReference(preguntasCollectionNewPreguntasToAttach.getClass(), preguntasCollectionNewPreguntasToAttach.getIdpreguntas());
                attachedPreguntasCollectionNew.add(preguntasCollectionNewPreguntasToAttach);
            }
            preguntasCollectionNew = attachedPreguntasCollectionNew;
            estudiante.setPreguntasCollection(preguntasCollectionNew);
            estudiante = em.merge(estudiante);
            for (Inscripcion inscripcionCollectionNewInscripcion : inscripcionCollectionNew) {
                if (!inscripcionCollectionOld.contains(inscripcionCollectionNewInscripcion)) {
                    Estudiante oldIdestudianteOfInscripcionCollectionNewInscripcion = inscripcionCollectionNewInscripcion.getIdestudiante();
                    inscripcionCollectionNewInscripcion.setIdestudiante(estudiante);
                    inscripcionCollectionNewInscripcion = em.merge(inscripcionCollectionNewInscripcion);
                    if (oldIdestudianteOfInscripcionCollectionNewInscripcion != null && !oldIdestudianteOfInscripcionCollectionNewInscripcion.equals(estudiante)) {
                        oldIdestudianteOfInscripcionCollectionNewInscripcion.getInscripcionCollection().remove(inscripcionCollectionNewInscripcion);
                        oldIdestudianteOfInscripcionCollectionNewInscripcion = em.merge(oldIdestudianteOfInscripcionCollectionNewInscripcion);
                    }
                }
            }
            for (Preguntas preguntasCollectionNewPreguntas : preguntasCollectionNew) {
                if (!preguntasCollectionOld.contains(preguntasCollectionNewPreguntas)) {
                    Estudiante oldIdestudianteOfPreguntasCollectionNewPreguntas = preguntasCollectionNewPreguntas.getIdestudiante();
                    preguntasCollectionNewPreguntas.setIdestudiante(estudiante);
                    preguntasCollectionNewPreguntas = em.merge(preguntasCollectionNewPreguntas);
                    if (oldIdestudianteOfPreguntasCollectionNewPreguntas != null && !oldIdestudianteOfPreguntasCollectionNewPreguntas.equals(estudiante)) {
                        oldIdestudianteOfPreguntasCollectionNewPreguntas.getPreguntasCollection().remove(preguntasCollectionNewPreguntas);
                        oldIdestudianteOfPreguntasCollectionNewPreguntas = em.merge(oldIdestudianteOfPreguntasCollectionNewPreguntas);
=======
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
            for (Inscripcion inscripcionListNewInscripcion : inscripcionListNew) {
                if (!inscripcionListOld.contains(inscripcionListNewInscripcion)) {
                    Estudiante oldIdestudianteOfInscripcionListNewInscripcion = inscripcionListNewInscripcion.getIdestudiante();
                    inscripcionListNewInscripcion.setIdestudiante(estudiante);
                    inscripcionListNewInscripcion = em.merge(inscripcionListNewInscripcion);
                    if (oldIdestudianteOfInscripcionListNewInscripcion != null && !oldIdestudianteOfInscripcionListNewInscripcion.equals(estudiante)) {
                        oldIdestudianteOfInscripcionListNewInscripcion.getInscripcionList().remove(inscripcionListNewInscripcion);
                        oldIdestudianteOfInscripcionListNewInscripcion = em.merge(oldIdestudianteOfInscripcionListNewInscripcion);
                    }
                }
            }
            for (Preguntas preguntasListNewPreguntas : preguntasListNew) {
                if (!preguntasListOld.contains(preguntasListNewPreguntas)) {
                    Estudiante oldIdestudianteOfPreguntasListNewPreguntas = preguntasListNewPreguntas.getIdestudiante();
                    preguntasListNewPreguntas.setIdestudiante(estudiante);
                    preguntasListNewPreguntas = em.merge(preguntasListNewPreguntas);
                    if (oldIdestudianteOfPreguntasListNewPreguntas != null && !oldIdestudianteOfPreguntasListNewPreguntas.equals(estudiante)) {
                        oldIdestudianteOfPreguntasListNewPreguntas.getPreguntasList().remove(preguntasListNewPreguntas);
                        oldIdestudianteOfPreguntasListNewPreguntas = em.merge(oldIdestudianteOfPreguntasListNewPreguntas);
>>>>>>> master
                    }
                }
            }
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
            Collection<Inscripcion> inscripcionCollectionOrphanCheck = estudiante.getInscripcionCollection();
            for (Inscripcion inscripcionCollectionOrphanCheckInscripcion : inscripcionCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estudiante (" + estudiante + ") cannot be destroyed since the Inscripcion " + inscripcionCollectionOrphanCheckInscripcion + " in its inscripcionCollection field has a non-nullable idestudiante field.");
            }
            Collection<Preguntas> preguntasCollectionOrphanCheck = estudiante.getPreguntasCollection();
            for (Preguntas preguntasCollectionOrphanCheckPreguntas : preguntasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estudiante (" + estudiante + ") cannot be destroyed since the Preguntas " + preguntasCollectionOrphanCheckPreguntas + " in its preguntasCollection field has a non-nullable idestudiante field.");
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
