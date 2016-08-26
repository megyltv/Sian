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
import Entidades.HorarioMateria;
import Entidades.Inscripcion;
import Entidades.Periodo;
import JpaControllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Megan
 */
public class InscripcionJpaController implements Serializable {

    public InscripcionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Inscripcion inscripcion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante idestudiante = inscripcion.getIdestudiante();
            if (idestudiante != null) {
                idestudiante = em.getReference(idestudiante.getClass(), idestudiante.getIdestudiante());
                inscripcion.setIdestudiante(idestudiante);
            }
            HorarioMateria idmateriahorario = inscripcion.getIdmateriahorario();
            if (idmateriahorario != null) {
                idmateriahorario = em.getReference(idmateriahorario.getClass(), idmateriahorario.getIdmateriahorario());
                inscripcion.setIdmateriahorario(idmateriahorario);
            }
            Periodo idperiodo = inscripcion.getIdperiodo();
            if (idperiodo != null) {
                idperiodo = em.getReference(idperiodo.getClass(), idperiodo.getIdperiodo());
                inscripcion.setIdperiodo(idperiodo);
            }
            em.persist(inscripcion);
            if (idestudiante != null) {
                idestudiante.getInscripcionList().add(inscripcion);
                idestudiante = em.merge(idestudiante);
            }
            if (idmateriahorario != null) {
                idmateriahorario.getInscripcionList().add(inscripcion);
                idmateriahorario = em.merge(idmateriahorario);
            }
            if (idperiodo != null) {
                idperiodo.getInscripcionList().add(inscripcion);
                idperiodo = em.merge(idperiodo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Inscripcion inscripcion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inscripcion persistentInscripcion = em.find(Inscripcion.class, inscripcion.getIdinscripcion());
            Estudiante idestudianteOld = persistentInscripcion.getIdestudiante();
            Estudiante idestudianteNew = inscripcion.getIdestudiante();
            HorarioMateria idmateriahorarioOld = persistentInscripcion.getIdmateriahorario();
            HorarioMateria idmateriahorarioNew = inscripcion.getIdmateriahorario();
            Periodo idperiodoOld = persistentInscripcion.getIdperiodo();
            Periodo idperiodoNew = inscripcion.getIdperiodo();
            if (idestudianteNew != null) {
                idestudianteNew = em.getReference(idestudianteNew.getClass(), idestudianteNew.getIdestudiante());
                inscripcion.setIdestudiante(idestudianteNew);
            }
            if (idmateriahorarioNew != null) {
                idmateriahorarioNew = em.getReference(idmateriahorarioNew.getClass(), idmateriahorarioNew.getIdmateriahorario());
                inscripcion.setIdmateriahorario(idmateriahorarioNew);
            }
            if (idperiodoNew != null) {
                idperiodoNew = em.getReference(idperiodoNew.getClass(), idperiodoNew.getIdperiodo());
                inscripcion.setIdperiodo(idperiodoNew);
            }
            inscripcion = em.merge(inscripcion);
            if (idestudianteOld != null && !idestudianteOld.equals(idestudianteNew)) {
                idestudianteOld.getInscripcionList().remove(inscripcion);
                idestudianteOld = em.merge(idestudianteOld);
            }
            if (idestudianteNew != null && !idestudianteNew.equals(idestudianteOld)) {
                idestudianteNew.getInscripcionList().add(inscripcion);
                idestudianteNew = em.merge(idestudianteNew);
            }
            if (idmateriahorarioOld != null && !idmateriahorarioOld.equals(idmateriahorarioNew)) {
                idmateriahorarioOld.getInscripcionList().remove(inscripcion);
                idmateriahorarioOld = em.merge(idmateriahorarioOld);
            }
            if (idmateriahorarioNew != null && !idmateriahorarioNew.equals(idmateriahorarioOld)) {
                idmateriahorarioNew.getInscripcionList().add(inscripcion);
                idmateriahorarioNew = em.merge(idmateriahorarioNew);
            }
            if (idperiodoOld != null && !idperiodoOld.equals(idperiodoNew)) {
                idperiodoOld.getInscripcionList().remove(inscripcion);
                idperiodoOld = em.merge(idperiodoOld);
            }
            if (idperiodoNew != null && !idperiodoNew.equals(idperiodoOld)) {
                idperiodoNew.getInscripcionList().add(inscripcion);
                idperiodoNew = em.merge(idperiodoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = inscripcion.getIdinscripcion();
                if (findInscripcion(id) == null) {
                    throw new NonexistentEntityException("The inscripcion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inscripcion inscripcion;
            try {
                inscripcion = em.getReference(Inscripcion.class, id);
                inscripcion.getIdinscripcion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inscripcion with id " + id + " no longer exists.", enfe);
            }
            Estudiante idestudiante = inscripcion.getIdestudiante();
            if (idestudiante != null) {
                idestudiante.getInscripcionList().remove(inscripcion);
                idestudiante = em.merge(idestudiante);
            }
            HorarioMateria idmateriahorario = inscripcion.getIdmateriahorario();
            if (idmateriahorario != null) {
                idmateriahorario.getInscripcionList().remove(inscripcion);
                idmateriahorario = em.merge(idmateriahorario);
            }
            Periodo idperiodo = inscripcion.getIdperiodo();
            if (idperiodo != null) {
                idperiodo.getInscripcionList().remove(inscripcion);
                idperiodo = em.merge(idperiodo);
            }
            em.remove(inscripcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inscripcion> findInscripcionEntities() {
        return findInscripcionEntities(true, -1, -1);
    }

    public List<Inscripcion> findInscripcionEntities(int maxResults, int firstResult) {
        return findInscripcionEntities(false, maxResults, firstResult);
    }

    private List<Inscripcion> findInscripcionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Inscripcion.class));
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

    public Inscripcion findInscripcion(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Inscripcion.class, id);
        } finally {
            em.close();
        }
    }

    public int getInscripcionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Inscripcion> rt = cq.from(Inscripcion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
