/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAControllers;

import Entidades.Calificacion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Estudiante;
import Entidades.MateriaHorario;
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
public class CalificacionJpaController implements Serializable {

    public CalificacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Calificacion calificacion) throws PreexistingEntityException, Exception {
        if (calificacion.getMateriaHorarioList() == null) {
            calificacion.setMateriaHorarioList(new ArrayList<MateriaHorario>());
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
            List<MateriaHorario> attachedMateriaHorarioList = new ArrayList<MateriaHorario>();
            for (MateriaHorario materiaHorarioListMateriaHorarioToAttach : calificacion.getMateriaHorarioList()) {
                materiaHorarioListMateriaHorarioToAttach = em.getReference(materiaHorarioListMateriaHorarioToAttach.getClass(), materiaHorarioListMateriaHorarioToAttach.getMateriaHorarioPK());
                attachedMateriaHorarioList.add(materiaHorarioListMateriaHorarioToAttach);
            }
            calificacion.setMateriaHorarioList(attachedMateriaHorarioList);
            em.persist(calificacion);
            if (cedula != null) {
                cedula.getCalificacionList().add(calificacion);
                cedula = em.merge(cedula);
            }
            for (MateriaHorario materiaHorarioListMateriaHorario : calificacion.getMateriaHorarioList()) {
                Calificacion oldIdcalificacionOfMateriaHorarioListMateriaHorario = materiaHorarioListMateriaHorario.getIdcalificacion();
                materiaHorarioListMateriaHorario.setIdcalificacion(calificacion);
                materiaHorarioListMateriaHorario = em.merge(materiaHorarioListMateriaHorario);
                if (oldIdcalificacionOfMateriaHorarioListMateriaHorario != null) {
                    oldIdcalificacionOfMateriaHorarioListMateriaHorario.getMateriaHorarioList().remove(materiaHorarioListMateriaHorario);
                    oldIdcalificacionOfMateriaHorarioListMateriaHorario = em.merge(oldIdcalificacionOfMateriaHorarioListMateriaHorario);
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
            List<MateriaHorario> materiaHorarioListOld = persistentCalificacion.getMateriaHorarioList();
            List<MateriaHorario> materiaHorarioListNew = calificacion.getMateriaHorarioList();
            if (cedulaNew != null) {
                cedulaNew = em.getReference(cedulaNew.getClass(), cedulaNew.getCedula());
                calificacion.setCedula(cedulaNew);
            }
            List<MateriaHorario> attachedMateriaHorarioListNew = new ArrayList<MateriaHorario>();
            for (MateriaHorario materiaHorarioListNewMateriaHorarioToAttach : materiaHorarioListNew) {
                materiaHorarioListNewMateriaHorarioToAttach = em.getReference(materiaHorarioListNewMateriaHorarioToAttach.getClass(), materiaHorarioListNewMateriaHorarioToAttach.getMateriaHorarioPK());
                attachedMateriaHorarioListNew.add(materiaHorarioListNewMateriaHorarioToAttach);
            }
            materiaHorarioListNew = attachedMateriaHorarioListNew;
            calificacion.setMateriaHorarioList(materiaHorarioListNew);
            calificacion = em.merge(calificacion);
            if (cedulaOld != null && !cedulaOld.equals(cedulaNew)) {
                cedulaOld.getCalificacionList().remove(calificacion);
                cedulaOld = em.merge(cedulaOld);
            }
            if (cedulaNew != null && !cedulaNew.equals(cedulaOld)) {
                cedulaNew.getCalificacionList().add(calificacion);
                cedulaNew = em.merge(cedulaNew);
            }
            for (MateriaHorario materiaHorarioListOldMateriaHorario : materiaHorarioListOld) {
                if (!materiaHorarioListNew.contains(materiaHorarioListOldMateriaHorario)) {
                    materiaHorarioListOldMateriaHorario.setIdcalificacion(null);
                    materiaHorarioListOldMateriaHorario = em.merge(materiaHorarioListOldMateriaHorario);
                }
            }
            for (MateriaHorario materiaHorarioListNewMateriaHorario : materiaHorarioListNew) {
                if (!materiaHorarioListOld.contains(materiaHorarioListNewMateriaHorario)) {
                    Calificacion oldIdcalificacionOfMateriaHorarioListNewMateriaHorario = materiaHorarioListNewMateriaHorario.getIdcalificacion();
                    materiaHorarioListNewMateriaHorario.setIdcalificacion(calificacion);
                    materiaHorarioListNewMateriaHorario = em.merge(materiaHorarioListNewMateriaHorario);
                    if (oldIdcalificacionOfMateriaHorarioListNewMateriaHorario != null && !oldIdcalificacionOfMateriaHorarioListNewMateriaHorario.equals(calificacion)) {
                        oldIdcalificacionOfMateriaHorarioListNewMateriaHorario.getMateriaHorarioList().remove(materiaHorarioListNewMateriaHorario);
                        oldIdcalificacionOfMateriaHorarioListNewMateriaHorario = em.merge(oldIdcalificacionOfMateriaHorarioListNewMateriaHorario);
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
            List<MateriaHorario> materiaHorarioList = calificacion.getMateriaHorarioList();
            for (MateriaHorario materiaHorarioListMateriaHorario : materiaHorarioList) {
                materiaHorarioListMateriaHorario.setIdcalificacion(null);
                materiaHorarioListMateriaHorario = em.merge(materiaHorarioListMateriaHorario);
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
