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
import Entidades.Estudiante;
import Entidades.Preguntas;
import JpaControllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Megan
 */
public class PreguntasJpaController implements Serializable {

    public PreguntasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Preguntas preguntas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante cedula = preguntas.getCedula();
            if (cedula != null) {
                cedula = em.getReference(cedula.getClass(), cedula.getCedula());
                preguntas.setCedula(cedula);
            }
            em.persist(preguntas);
            if (cedula != null) {
                cedula.getPreguntasList().add(preguntas);
                cedula = em.merge(cedula);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Preguntas preguntas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Preguntas persistentPreguntas = em.find(Preguntas.class, preguntas.getIdpreguntas());
            Estudiante cedulaOld = persistentPreguntas.getCedula();
            Estudiante cedulaNew = preguntas.getCedula();
            if (cedulaNew != null) {
                cedulaNew = em.getReference(cedulaNew.getClass(), cedulaNew.getCedula());
                preguntas.setCedula(cedulaNew);
            }
            preguntas = em.merge(preguntas);
            if (cedulaOld != null && !cedulaOld.equals(cedulaNew)) {
                cedulaOld.getPreguntasList().remove(preguntas);
                cedulaOld = em.merge(cedulaOld);
            }
            if (cedulaNew != null && !cedulaNew.equals(cedulaOld)) {
                cedulaNew.getPreguntasList().add(preguntas);
                cedulaNew = em.merge(cedulaNew);
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

    public void destroy(Integer id) throws NonexistentEntityException {
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
            Estudiante cedula = preguntas.getCedula();
            if (cedula != null) {
                cedula.getPreguntasList().remove(preguntas);
                cedula = em.merge(cedula);
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
