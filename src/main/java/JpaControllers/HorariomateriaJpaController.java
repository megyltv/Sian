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
import Entidades.Horario;
import Entidades.Horariomateria;
import Entidades.HorariomateriaPK;
import Entidades.Materia;
import JpaControllers.exceptions.NonexistentEntityException;
import JpaControllers.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Megan
 */
public class HorariomateriaJpaController implements Serializable {

    public HorariomateriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Horariomateria horariomateria) throws PreexistingEntityException, Exception {
        if (horariomateria.getHorariomateriaPK() == null) {
            horariomateria.setHorariomateriaPK(new HorariomateriaPK());
        }
        horariomateria.getHorariomateriaPK().setIdhorario(horariomateria.getHorario().getIdhorario());
        horariomateria.getHorariomateriaPK().setIdmateria(horariomateria.getMateria().getIdmateria());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calificacion idcalificacion = horariomateria.getIdcalificacion();
            if (idcalificacion != null) {
                idcalificacion = em.getReference(idcalificacion.getClass(), idcalificacion.getIdcalificacion());
                horariomateria.setIdcalificacion(idcalificacion);
            }
            Horario horario = horariomateria.getHorario();
            if (horario != null) {
                horario = em.getReference(horario.getClass(), horario.getIdhorario());
                horariomateria.setHorario(horario);
            }
            Materia materia = horariomateria.getMateria();
            if (materia != null) {
                materia = em.getReference(materia.getClass(), materia.getIdmateria());
                horariomateria.setMateria(materia);
            }
            em.persist(horariomateria);
            if (idcalificacion != null) {
                idcalificacion.getHorariomateriaList().add(horariomateria);
                idcalificacion = em.merge(idcalificacion);
            }
            if (horario != null) {
                horario.getHorariomateriaList().add(horariomateria);
                horario = em.merge(horario);
            }
            if (materia != null) {
                materia.getHorariomateriaList().add(horariomateria);
                materia = em.merge(materia);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHorariomateria(horariomateria.getHorariomateriaPK()) != null) {
                throw new PreexistingEntityException("Horariomateria " + horariomateria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Horariomateria horariomateria) throws NonexistentEntityException, Exception {
        horariomateria.getHorariomateriaPK().setIdhorario(horariomateria.getHorario().getIdhorario());
        horariomateria.getHorariomateriaPK().setIdmateria(horariomateria.getMateria().getIdmateria());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Horariomateria persistentHorariomateria = em.find(Horariomateria.class, horariomateria.getHorariomateriaPK());
            Calificacion idcalificacionOld = persistentHorariomateria.getIdcalificacion();
            Calificacion idcalificacionNew = horariomateria.getIdcalificacion();
            Horario horarioOld = persistentHorariomateria.getHorario();
            Horario horarioNew = horariomateria.getHorario();
            Materia materiaOld = persistentHorariomateria.getMateria();
            Materia materiaNew = horariomateria.getMateria();
            if (idcalificacionNew != null) {
                idcalificacionNew = em.getReference(idcalificacionNew.getClass(), idcalificacionNew.getIdcalificacion());
                horariomateria.setIdcalificacion(idcalificacionNew);
            }
            if (horarioNew != null) {
                horarioNew = em.getReference(horarioNew.getClass(), horarioNew.getIdhorario());
                horariomateria.setHorario(horarioNew);
            }
            if (materiaNew != null) {
                materiaNew = em.getReference(materiaNew.getClass(), materiaNew.getIdmateria());
                horariomateria.setMateria(materiaNew);
            }
            horariomateria = em.merge(horariomateria);
            if (idcalificacionOld != null && !idcalificacionOld.equals(idcalificacionNew)) {
                idcalificacionOld.getHorariomateriaList().remove(horariomateria);
                idcalificacionOld = em.merge(idcalificacionOld);
            }
            if (idcalificacionNew != null && !idcalificacionNew.equals(idcalificacionOld)) {
                idcalificacionNew.getHorariomateriaList().add(horariomateria);
                idcalificacionNew = em.merge(idcalificacionNew);
            }
            if (horarioOld != null && !horarioOld.equals(horarioNew)) {
                horarioOld.getHorariomateriaList().remove(horariomateria);
                horarioOld = em.merge(horarioOld);
            }
            if (horarioNew != null && !horarioNew.equals(horarioOld)) {
                horarioNew.getHorariomateriaList().add(horariomateria);
                horarioNew = em.merge(horarioNew);
            }
            if (materiaOld != null && !materiaOld.equals(materiaNew)) {
                materiaOld.getHorariomateriaList().remove(horariomateria);
                materiaOld = em.merge(materiaOld);
            }
            if (materiaNew != null && !materiaNew.equals(materiaOld)) {
                materiaNew.getHorariomateriaList().add(horariomateria);
                materiaNew = em.merge(materiaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                HorariomateriaPK id = horariomateria.getHorariomateriaPK();
                if (findHorariomateria(id) == null) {
                    throw new NonexistentEntityException("The horariomateria with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(HorariomateriaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Horariomateria horariomateria;
            try {
                horariomateria = em.getReference(Horariomateria.class, id);
                horariomateria.getHorariomateriaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The horariomateria with id " + id + " no longer exists.", enfe);
            }
            Calificacion idcalificacion = horariomateria.getIdcalificacion();
            if (idcalificacion != null) {
                idcalificacion.getHorariomateriaList().remove(horariomateria);
                idcalificacion = em.merge(idcalificacion);
            }
            Horario horario = horariomateria.getHorario();
            if (horario != null) {
                horario.getHorariomateriaList().remove(horariomateria);
                horario = em.merge(horario);
            }
            Materia materia = horariomateria.getMateria();
            if (materia != null) {
                materia.getHorariomateriaList().remove(horariomateria);
                materia = em.merge(materia);
            }
            em.remove(horariomateria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Horariomateria> findHorariomateriaEntities() {
        return findHorariomateriaEntities(true, -1, -1);
    }

    public List<Horariomateria> findHorariomateriaEntities(int maxResults, int firstResult) {
        return findHorariomateriaEntities(false, maxResults, firstResult);
    }

    private List<Horariomateria> findHorariomateriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Horariomateria.class));
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

    public Horariomateria findHorariomateria(HorariomateriaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Horariomateria.class, id);
        } finally {
            em.close();
        }
    }

    public int getHorariomateriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Horariomateria> rt = cq.from(Horariomateria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
