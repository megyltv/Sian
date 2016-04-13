/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controlador.exceptions.NonexistentEntityException;
import Controlador.exceptions.PreexistingEntityException;
import Entidades.Calificacion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Estudiante;
import Entidades.Horariomateria;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Megan
 */
public class CalificacionJpaController implements Serializable {

    public CalificacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Calificacion calificacion) throws PreexistingEntityException, Exception {
        if (calificacion.getHorariomateriaList() == null) {
            calificacion.setHorariomateriaList(new ArrayList<Horariomateria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante cedula = calificacion.getCedula();
            if (cedula != null) {
                cedula = em.getReference(cedula.getClass(), cedula.getCedula());
                calificacion.setCedula(cedula);
            }
            List<Horariomateria> attachedHorariomateriaList = new ArrayList<Horariomateria>();
            for (Horariomateria horariomateriaListHorariomateriaToAttach : calificacion.getHorariomateriaList()) {
                horariomateriaListHorariomateriaToAttach = em.getReference(horariomateriaListHorariomateriaToAttach.getClass(), horariomateriaListHorariomateriaToAttach.getHorariomateriaPK());
                attachedHorariomateriaList.add(horariomateriaListHorariomateriaToAttach);
            }
            calificacion.setHorariomateriaList(attachedHorariomateriaList);
            em.persist(calificacion);
            if (cedula != null) {
                cedula.getCalificacionList().add(calificacion);
                cedula = em.merge(cedula);
            }
            for (Horariomateria horariomateriaListHorariomateria : calificacion.getHorariomateriaList()) {
                Calificacion oldIdcalificacionOfHorariomateriaListHorariomateria = horariomateriaListHorariomateria.getIdcalificacion();
                horariomateriaListHorariomateria.setIdcalificacion(calificacion);
                horariomateriaListHorariomateria = em.merge(horariomateriaListHorariomateria);
                if (oldIdcalificacionOfHorariomateriaListHorariomateria != null) {
                    oldIdcalificacionOfHorariomateriaListHorariomateria.getHorariomateriaList().remove(horariomateriaListHorariomateria);
                    oldIdcalificacionOfHorariomateriaListHorariomateria = em.merge(oldIdcalificacionOfHorariomateriaListHorariomateria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCalificacion(calificacion.getIdcalificacion()) != null) {
                throw new PreexistingEntityException("Calificacion " + calificacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Calificacion calificacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calificacion persistentCalificacion = em.find(Calificacion.class, calificacion.getIdcalificacion());
            Estudiante cedulaOld = persistentCalificacion.getCedula();
            Estudiante cedulaNew = calificacion.getCedula();
            List<Horariomateria> horariomateriaListOld = persistentCalificacion.getHorariomateriaList();
            List<Horariomateria> horariomateriaListNew = calificacion.getHorariomateriaList();
            if (cedulaNew != null) {
                cedulaNew = em.getReference(cedulaNew.getClass(), cedulaNew.getCedula());
                calificacion.setCedula(cedulaNew);
            }
            List<Horariomateria> attachedHorariomateriaListNew = new ArrayList<Horariomateria>();
            for (Horariomateria horariomateriaListNewHorariomateriaToAttach : horariomateriaListNew) {
                horariomateriaListNewHorariomateriaToAttach = em.getReference(horariomateriaListNewHorariomateriaToAttach.getClass(), horariomateriaListNewHorariomateriaToAttach.getHorariomateriaPK());
                attachedHorariomateriaListNew.add(horariomateriaListNewHorariomateriaToAttach);
            }
            horariomateriaListNew = attachedHorariomateriaListNew;
            calificacion.setHorariomateriaList(horariomateriaListNew);
            calificacion = em.merge(calificacion);
            if (cedulaOld != null && !cedulaOld.equals(cedulaNew)) {
                cedulaOld.getCalificacionList().remove(calificacion);
                cedulaOld = em.merge(cedulaOld);
            }
            if (cedulaNew != null && !cedulaNew.equals(cedulaOld)) {
                cedulaNew.getCalificacionList().add(calificacion);
                cedulaNew = em.merge(cedulaNew);
            }
            for (Horariomateria horariomateriaListOldHorariomateria : horariomateriaListOld) {
                if (!horariomateriaListNew.contains(horariomateriaListOldHorariomateria)) {
                    horariomateriaListOldHorariomateria.setIdcalificacion(null);
                    horariomateriaListOldHorariomateria = em.merge(horariomateriaListOldHorariomateria);
                }
            }
            for (Horariomateria horariomateriaListNewHorariomateria : horariomateriaListNew) {
                if (!horariomateriaListOld.contains(horariomateriaListNewHorariomateria)) {
                    Calificacion oldIdcalificacionOfHorariomateriaListNewHorariomateria = horariomateriaListNewHorariomateria.getIdcalificacion();
                    horariomateriaListNewHorariomateria.setIdcalificacion(calificacion);
                    horariomateriaListNewHorariomateria = em.merge(horariomateriaListNewHorariomateria);
                    if (oldIdcalificacionOfHorariomateriaListNewHorariomateria != null && !oldIdcalificacionOfHorariomateriaListNewHorariomateria.equals(calificacion)) {
                        oldIdcalificacionOfHorariomateriaListNewHorariomateria.getHorariomateriaList().remove(horariomateriaListNewHorariomateria);
                        oldIdcalificacionOfHorariomateriaListNewHorariomateria = em.merge(oldIdcalificacionOfHorariomateriaListNewHorariomateria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = calificacion.getIdcalificacion();
                if (findCalificacion(id) == null) {
                    throw new NonexistentEntityException("The calificacion with id " + id + " no longer exists.");
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
            Calificacion calificacion;
            try {
                calificacion = em.getReference(Calificacion.class, id);
                calificacion.getIdcalificacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calificacion with id " + id + " no longer exists.", enfe);
            }
            Estudiante cedula = calificacion.getCedula();
            if (cedula != null) {
                cedula.getCalificacionList().remove(calificacion);
                cedula = em.merge(cedula);
            }
            List<Horariomateria> horariomateriaList = calificacion.getHorariomateriaList();
            for (Horariomateria horariomateriaListHorariomateria : horariomateriaList) {
                horariomateriaListHorariomateria.setIdcalificacion(null);
                horariomateriaListHorariomateria = em.merge(horariomateriaListHorariomateria);
            }
            em.remove(calificacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Calificacion> findCalificacionEntities() {
        return findCalificacionEntities(true, -1, -1);
    }

    public List<Calificacion> findCalificacionEntities(int maxResults, int firstResult) {
        return findCalificacionEntities(false, maxResults, firstResult);
    }

    private List<Calificacion> findCalificacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Calificacion.class));
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

    public Calificacion findCalificacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Calificacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalificacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Calificacion> rt = cq.from(Calificacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
