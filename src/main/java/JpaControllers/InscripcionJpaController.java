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
import Entidades.Inscripcion;
import Entidades.PeriodoActual;
import Entidades.Materia;
import JpaControllers.exceptions.IllegalOrphanException;
import JpaControllers.exceptions.NonexistentEntityException;
import java.util.ArrayList;
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
        if (inscripcion.getMateriaList() == null) {
            inscripcion.setMateriaList(new ArrayList<Materia>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante cedula = inscripcion.getCedula();
            if (cedula != null) {
                cedula = em.getReference(cedula.getClass(), cedula.getCedula());
                inscripcion.setCedula(cedula);
            }
            PeriodoActual idperiodo = inscripcion.getIdperiodo();
            if (idperiodo != null) {
                idperiodo = em.getReference(idperiodo.getClass(), idperiodo.getIdperiodo());
                inscripcion.setIdperiodo(idperiodo);
            }
            List<Materia> attachedMateriaList = new ArrayList<Materia>();
            for (Materia materiaListMateriaToAttach : inscripcion.getMateriaList()) {
                materiaListMateriaToAttach = em.getReference(materiaListMateriaToAttach.getClass(), materiaListMateriaToAttach.getIdmateria());
                attachedMateriaList.add(materiaListMateriaToAttach);
            }
            inscripcion.setMateriaList(attachedMateriaList);
            em.persist(inscripcion);
            if (cedula != null) {
                cedula.getInscripcionList().add(inscripcion);
                cedula = em.merge(cedula);
            }
            if (idperiodo != null) {
                idperiodo.getInscripcionList().add(inscripcion);
                idperiodo = em.merge(idperiodo);
            }
            for (Materia materiaListMateria : inscripcion.getMateriaList()) {
                Inscripcion oldIdinscripcionOfMateriaListMateria = materiaListMateria.getIdinscripcion();
                materiaListMateria.setIdinscripcion(inscripcion);
                materiaListMateria = em.merge(materiaListMateria);
                if (oldIdinscripcionOfMateriaListMateria != null) {
                    oldIdinscripcionOfMateriaListMateria.getMateriaList().remove(materiaListMateria);
                    oldIdinscripcionOfMateriaListMateria = em.merge(oldIdinscripcionOfMateriaListMateria);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Inscripcion inscripcion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inscripcion persistentInscripcion = em.find(Inscripcion.class, inscripcion.getIdinscripcion());
            Estudiante cedulaOld = persistentInscripcion.getCedula();
            Estudiante cedulaNew = inscripcion.getCedula();
            PeriodoActual idperiodoOld = persistentInscripcion.getIdperiodo();
            PeriodoActual idperiodoNew = inscripcion.getIdperiodo();
            List<Materia> materiaListOld = persistentInscripcion.getMateriaList();
            List<Materia> materiaListNew = inscripcion.getMateriaList();
            List<String> illegalOrphanMessages = null;
            for (Materia materiaListOldMateria : materiaListOld) {
                if (!materiaListNew.contains(materiaListOldMateria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Materia " + materiaListOldMateria + " since its idinscripcion field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (cedulaNew != null) {
                cedulaNew = em.getReference(cedulaNew.getClass(), cedulaNew.getCedula());
                inscripcion.setCedula(cedulaNew);
            }
            if (idperiodoNew != null) {
                idperiodoNew = em.getReference(idperiodoNew.getClass(), idperiodoNew.getIdperiodo());
                inscripcion.setIdperiodo(idperiodoNew);
            }
            List<Materia> attachedMateriaListNew = new ArrayList<Materia>();
            for (Materia materiaListNewMateriaToAttach : materiaListNew) {
                materiaListNewMateriaToAttach = em.getReference(materiaListNewMateriaToAttach.getClass(), materiaListNewMateriaToAttach.getIdmateria());
                attachedMateriaListNew.add(materiaListNewMateriaToAttach);
            }
            materiaListNew = attachedMateriaListNew;
            inscripcion.setMateriaList(materiaListNew);
            inscripcion = em.merge(inscripcion);
            if (cedulaOld != null && !cedulaOld.equals(cedulaNew)) {
                cedulaOld.getInscripcionList().remove(inscripcion);
                cedulaOld = em.merge(cedulaOld);
            }
            if (cedulaNew != null && !cedulaNew.equals(cedulaOld)) {
                cedulaNew.getInscripcionList().add(inscripcion);
                cedulaNew = em.merge(cedulaNew);
            }
            if (idperiodoOld != null && !idperiodoOld.equals(idperiodoNew)) {
                idperiodoOld.getInscripcionList().remove(inscripcion);
                idperiodoOld = em.merge(idperiodoOld);
            }
            if (idperiodoNew != null && !idperiodoNew.equals(idperiodoOld)) {
                idperiodoNew.getInscripcionList().add(inscripcion);
                idperiodoNew = em.merge(idperiodoNew);
            }
            for (Materia materiaListNewMateria : materiaListNew) {
                if (!materiaListOld.contains(materiaListNewMateria)) {
                    Inscripcion oldIdinscripcionOfMateriaListNewMateria = materiaListNewMateria.getIdinscripcion();
                    materiaListNewMateria.setIdinscripcion(inscripcion);
                    materiaListNewMateria = em.merge(materiaListNewMateria);
                    if (oldIdinscripcionOfMateriaListNewMateria != null && !oldIdinscripcionOfMateriaListNewMateria.equals(inscripcion)) {
                        oldIdinscripcionOfMateriaListNewMateria.getMateriaList().remove(materiaListNewMateria);
                        oldIdinscripcionOfMateriaListNewMateria = em.merge(oldIdinscripcionOfMateriaListNewMateria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = inscripcion.getIdinscripcion();
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<Materia> materiaListOrphanCheck = inscripcion.getMateriaList();
            for (Materia materiaListOrphanCheckMateria : materiaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Inscripcion (" + inscripcion + ") cannot be destroyed since the Materia " + materiaListOrphanCheckMateria + " in its materiaList field has a non-nullable idinscripcion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Estudiante cedula = inscripcion.getCedula();
            if (cedula != null) {
                cedula.getInscripcionList().remove(inscripcion);
                cedula = em.merge(cedula);
            }
            PeriodoActual idperiodo = inscripcion.getIdperiodo();
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

    public Inscripcion findInscripcion(Integer id) {
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
