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
import Entidades.Calificacion;
import Entidades.Horario;
import Entidades.Materia;
import Entidades.MateriaHorario;
import Entidades.MateriaHorarioPK;
import JPAControllers.exceptions.NonexistentEntityException;
import JPAControllers.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Nathy Cumbicos
 */
public class MateriaHorarioJpaController implements Serializable {

    public MateriaHorarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MateriaHorario materiaHorario) throws PreexistingEntityException, Exception {
        if (materiaHorario.getMateriaHorarioPK() == null) {
            materiaHorario.setMateriaHorarioPK(new MateriaHorarioPK());
        }
        materiaHorario.getMateriaHorarioPK().setIdmateria(materiaHorario.getMateria().getIdmateria());
        materiaHorario.getMateriaHorarioPK().setIdhorario(materiaHorario.getHorario().getIdhorario());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calificacion idcalificacion = materiaHorario.getIdcalificacion();
            if (idcalificacion != null) {
                idcalificacion = em.getReference(idcalificacion.getClass(), idcalificacion.getIdcalificacion());
                materiaHorario.setIdcalificacion(idcalificacion);
            }
            Horario horario = materiaHorario.getHorario();
            if (horario != null) {
                horario = em.getReference(horario.getClass(), horario.getIdhorario());
                materiaHorario.setHorario(horario);
            }
            Materia materia = materiaHorario.getMateria();
            if (materia != null) {
                materia = em.getReference(materia.getClass(), materia.getIdmateria());
                materiaHorario.setMateria(materia);
            }
            em.persist(materiaHorario);
            if (idcalificacion != null) {
                idcalificacion.getMateriaHorarioList().add(materiaHorario);
                idcalificacion = em.merge(idcalificacion);
            }
            if (horario != null) {
                horario.getMateriaHorarioList().add(materiaHorario);
                horario = em.merge(horario);
            }
            if (materia != null) {
                materia.getMateriaHorarioList().add(materiaHorario);
                materia = em.merge(materia);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMateriaHorario(materiaHorario.getMateriaHorarioPK()) != null) {
                throw new PreexistingEntityException("MateriaHorario " + materiaHorario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MateriaHorario materiaHorario) throws NonexistentEntityException, Exception {
        materiaHorario.getMateriaHorarioPK().setIdmateria(materiaHorario.getMateria().getIdmateria());
        materiaHorario.getMateriaHorarioPK().setIdhorario(materiaHorario.getHorario().getIdhorario());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MateriaHorario persistentMateriaHorario = em.find(MateriaHorario.class, materiaHorario.getMateriaHorarioPK());
            Calificacion idcalificacionOld = persistentMateriaHorario.getIdcalificacion();
            Calificacion idcalificacionNew = materiaHorario.getIdcalificacion();
            Horario horarioOld = persistentMateriaHorario.getHorario();
            Horario horarioNew = materiaHorario.getHorario();
            Materia materiaOld = persistentMateriaHorario.getMateria();
            Materia materiaNew = materiaHorario.getMateria();
            if (idcalificacionNew != null) {
                idcalificacionNew = em.getReference(idcalificacionNew.getClass(), idcalificacionNew.getIdcalificacion());
                materiaHorario.setIdcalificacion(idcalificacionNew);
            }
            if (horarioNew != null) {
                horarioNew = em.getReference(horarioNew.getClass(), horarioNew.getIdhorario());
                materiaHorario.setHorario(horarioNew);
            }
            if (materiaNew != null) {
                materiaNew = em.getReference(materiaNew.getClass(), materiaNew.getIdmateria());
                materiaHorario.setMateria(materiaNew);
            }
            materiaHorario = em.merge(materiaHorario);
            if (idcalificacionOld != null && !idcalificacionOld.equals(idcalificacionNew)) {
                idcalificacionOld.getMateriaHorarioList().remove(materiaHorario);
                idcalificacionOld = em.merge(idcalificacionOld);
            }
            if (idcalificacionNew != null && !idcalificacionNew.equals(idcalificacionOld)) {
                idcalificacionNew.getMateriaHorarioList().add(materiaHorario);
                idcalificacionNew = em.merge(idcalificacionNew);
            }
            if (horarioOld != null && !horarioOld.equals(horarioNew)) {
                horarioOld.getMateriaHorarioList().remove(materiaHorario);
                horarioOld = em.merge(horarioOld);
            }
            if (horarioNew != null && !horarioNew.equals(horarioOld)) {
                horarioNew.getMateriaHorarioList().add(materiaHorario);
                horarioNew = em.merge(horarioNew);
            }
            if (materiaOld != null && !materiaOld.equals(materiaNew)) {
                materiaOld.getMateriaHorarioList().remove(materiaHorario);
                materiaOld = em.merge(materiaOld);
            }
            if (materiaNew != null && !materiaNew.equals(materiaOld)) {
                materiaNew.getMateriaHorarioList().add(materiaHorario);
                materiaNew = em.merge(materiaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                MateriaHorarioPK id = materiaHorario.getMateriaHorarioPK();
                if (findMateriaHorario(id) == null) {
                    throw new NonexistentEntityException("The materiaHorario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(MateriaHorarioPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MateriaHorario materiaHorario;
            try {
                materiaHorario = em.getReference(MateriaHorario.class, id);
                materiaHorario.getMateriaHorarioPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materiaHorario with id " + id + " no longer exists.", enfe);
            }
            Calificacion idcalificacion = materiaHorario.getIdcalificacion();
            if (idcalificacion != null) {
                idcalificacion.getMateriaHorarioList().remove(materiaHorario);
                idcalificacion = em.merge(idcalificacion);
            }
            Horario horario = materiaHorario.getHorario();
            if (horario != null) {
                horario.getMateriaHorarioList().remove(materiaHorario);
                horario = em.merge(horario);
            }
            Materia materia = materiaHorario.getMateria();
            if (materia != null) {
                materia.getMateriaHorarioList().remove(materiaHorario);
                materia = em.merge(materia);
            }
            em.remove(materiaHorario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MateriaHorario> findMateriaHorarioEntities() {
        return findMateriaHorarioEntities(true, -1, -1);
    }

    public List<MateriaHorario> findMateriaHorarioEntities(int maxResults, int firstResult) {
        return findMateriaHorarioEntities(false, maxResults, firstResult);
    }

    private List<MateriaHorario> findMateriaHorarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MateriaHorario.class));
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

    public MateriaHorario findMateriaHorario(MateriaHorarioPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MateriaHorario.class, id);
        } finally {
            em.close();
        }
    }

    public int getMateriaHorarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MateriaHorario> rt = cq.from(MateriaHorario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
