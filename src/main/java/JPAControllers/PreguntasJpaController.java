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
import Entidades.Preguntas;
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
public class PreguntasJpaController implements Serializable {

    public PreguntasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Preguntas preguntas) throws PreexistingEntityException, Exception {
        if (preguntas.getEstudianteList() == null) {
            preguntas.setEstudianteList(new ArrayList<Estudiante>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Estudiante> attachedEstudianteList = new ArrayList<Estudiante>();
            for (Estudiante estudianteListEstudianteToAttach : preguntas.getEstudianteList()) {
                estudianteListEstudianteToAttach = em.getReference(estudianteListEstudianteToAttach.getClass(), estudianteListEstudianteToAttach.getCedula());
                attachedEstudianteList.add(estudianteListEstudianteToAttach);
            }
            preguntas.setEstudianteList(attachedEstudianteList);
            em.persist(preguntas);
            for (Estudiante estudianteListEstudiante : preguntas.getEstudianteList()) {
                Preguntas oldIdpreguntasOfEstudianteListEstudiante = estudianteListEstudiante.getIdpreguntas();
                estudianteListEstudiante.setIdpreguntas(preguntas);
                estudianteListEstudiante = em.merge(estudianteListEstudiante);
                if (oldIdpreguntasOfEstudianteListEstudiante != null) {
                    oldIdpreguntasOfEstudianteListEstudiante.getEstudianteList().remove(estudianteListEstudiante);
                    oldIdpreguntasOfEstudianteListEstudiante = em.merge(oldIdpreguntasOfEstudianteListEstudiante);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPreguntas(preguntas.getIdpreguntas()) != null) {
                throw new PreexistingEntityException("Preguntas " + preguntas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Preguntas preguntas) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Preguntas persistentPreguntas = em.find(Preguntas.class, preguntas.getIdpreguntas());
            List<Estudiante> estudianteListOld = persistentPreguntas.getEstudianteList();
            List<Estudiante> estudianteListNew = preguntas.getEstudianteList();
            List<String> illegalOrphanMessages = null;
            for (Estudiante estudianteListOldEstudiante : estudianteListOld) {
                if (!estudianteListNew.contains(estudianteListOldEstudiante)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Estudiante " + estudianteListOldEstudiante + " since its idpreguntas field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Estudiante> attachedEstudianteListNew = new ArrayList<Estudiante>();
            for (Estudiante estudianteListNewEstudianteToAttach : estudianteListNew) {
                estudianteListNewEstudianteToAttach = em.getReference(estudianteListNewEstudianteToAttach.getClass(), estudianteListNewEstudianteToAttach.getCedula());
                attachedEstudianteListNew.add(estudianteListNewEstudianteToAttach);
            }
            estudianteListNew = attachedEstudianteListNew;
            preguntas.setEstudianteList(estudianteListNew);
            preguntas = em.merge(preguntas);
            for (Estudiante estudianteListNewEstudiante : estudianteListNew) {
                if (!estudianteListOld.contains(estudianteListNewEstudiante)) {
                    Preguntas oldIdpreguntasOfEstudianteListNewEstudiante = estudianteListNewEstudiante.getIdpreguntas();
                    estudianteListNewEstudiante.setIdpreguntas(preguntas);
                    estudianteListNewEstudiante = em.merge(estudianteListNewEstudiante);
                    if (oldIdpreguntasOfEstudianteListNewEstudiante != null && !oldIdpreguntasOfEstudianteListNewEstudiante.equals(preguntas)) {
                        oldIdpreguntasOfEstudianteListNewEstudiante.getEstudianteList().remove(estudianteListNewEstudiante);
                        oldIdpreguntasOfEstudianteListNewEstudiante = em.merge(oldIdpreguntasOfEstudianteListNewEstudiante);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = preguntas.getIdpreguntas();
                if (findPreguntas(id) == null) {
                    throw new NonexistentEntityException("The preguntas with id " + id + " no longer exists.");
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
            Preguntas preguntas;
            try {
                preguntas = em.getReference(Preguntas.class, id);
                preguntas.getIdpreguntas();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The preguntas with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Estudiante> estudianteListOrphanCheck = preguntas.getEstudianteList();
            for (Estudiante estudianteListOrphanCheckEstudiante : estudianteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Preguntas (" + preguntas + ") cannot be destroyed since the Estudiante " + estudianteListOrphanCheckEstudiante + " in its estudianteList field has a non-nullable idpreguntas field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(preguntas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Preguntas> findPreguntasEntities() {
        return findPreguntasEntities(true, -1, -1);
    }

    public List<Preguntas> findPreguntasEntities(int maxResults, int firstResult) {
        return findPreguntasEntities(false, maxResults, firstResult);
    }

    private List<Preguntas> findPreguntasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Preguntas.class));
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

    public Preguntas findPreguntas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Preguntas.class, id);
        } finally {
            em.close();
        }
    }

    public int getPreguntasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Preguntas> rt = cq.from(Preguntas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
