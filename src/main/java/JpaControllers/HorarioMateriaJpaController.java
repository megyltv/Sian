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
import Entidades.Horario;
import Entidades.HorarioMateria;
import Entidades.Materia;
import Entidades.Inscripcion;
import JpaControllers.exceptions.NonexistentEntityException;
import JpaControllers.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Iker Gael
 */
public class HorarioMateriaJpaController implements Serializable {

    public HorarioMateriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HorarioMateria horarioMateria) throws PreexistingEntityException, Exception {
        if (horarioMateria.getInscripcionCollection() == null) {
            horarioMateria.setInscripcionCollection(new ArrayList<Inscripcion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Horario idhorario = horarioMateria.getIdhorario();
            if (idhorario != null) {
                idhorario = em.getReference(idhorario.getClass(), idhorario.getIdhorario());
                horarioMateria.setIdhorario(idhorario);
            }
            Materia idmateria = horarioMateria.getIdmateria();
            if (idmateria != null) {
                idmateria = em.getReference(idmateria.getClass(), idmateria.getIdmateria());
                horarioMateria.setIdmateria(idmateria);
            }
            Collection<Inscripcion> attachedInscripcionCollection = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionCollectionInscripcionToAttach : horarioMateria.getInscripcionCollection()) {
                inscripcionCollectionInscripcionToAttach = em.getReference(inscripcionCollectionInscripcionToAttach.getClass(), inscripcionCollectionInscripcionToAttach.getIdinscripcion());
                attachedInscripcionCollection.add(inscripcionCollectionInscripcionToAttach);
            }
            horarioMateria.setInscripcionCollection(attachedInscripcionCollection);
            em.persist(horarioMateria);
            if (idhorario != null) {
                idhorario.getHorarioMateriaCollection().add(horarioMateria);
                idhorario = em.merge(idhorario);
            }
            if (idmateria != null) {
                idmateria.getHorarioMateriaCollection().add(horarioMateria);
                idmateria = em.merge(idmateria);
            }
            for (Inscripcion inscripcionCollectionInscripcion : horarioMateria.getInscripcionCollection()) {
                HorarioMateria oldIdmateriahorarioOfInscripcionCollectionInscripcion = inscripcionCollectionInscripcion.getIdmateriahorario();
                inscripcionCollectionInscripcion.setIdmateriahorario(horarioMateria);
                inscripcionCollectionInscripcion = em.merge(inscripcionCollectionInscripcion);
                if (oldIdmateriahorarioOfInscripcionCollectionInscripcion != null) {
                    oldIdmateriahorarioOfInscripcionCollectionInscripcion.getInscripcionCollection().remove(inscripcionCollectionInscripcion);
                    oldIdmateriahorarioOfInscripcionCollectionInscripcion = em.merge(oldIdmateriahorarioOfInscripcionCollectionInscripcion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHorarioMateria(horarioMateria.getIdmateriahorario()) != null) {
                throw new PreexistingEntityException("HorarioMateria " + horarioMateria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HorarioMateria horarioMateria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HorarioMateria persistentHorarioMateria = em.find(HorarioMateria.class, horarioMateria.getIdmateriahorario());
            Horario idhorarioOld = persistentHorarioMateria.getIdhorario();
            Horario idhorarioNew = horarioMateria.getIdhorario();
            Materia idmateriaOld = persistentHorarioMateria.getIdmateria();
            Materia idmateriaNew = horarioMateria.getIdmateria();
<<<<<<< HEAD
            Collection<Inscripcion> inscripcionCollectionOld = persistentHorarioMateria.getInscripcionCollection();
            Collection<Inscripcion> inscripcionCollectionNew = horarioMateria.getInscripcionCollection();
            if (idhorarioNew != null) {
                idhorarioNew = em.getReference(idhorarioNew.getClass(), idhorarioNew.getIdhorario());
                horarioMateria.setIdhorario(idhorarioNew);
            }
            if (idmateriaNew != null) {
                idmateriaNew = em.getReference(idmateriaNew.getClass(), idmateriaNew.getIdmateria());
                horarioMateria.setIdmateria(idmateriaNew);
            }
            Collection<Inscripcion> attachedInscripcionCollectionNew = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionCollectionNewInscripcionToAttach : inscripcionCollectionNew) {
                inscripcionCollectionNewInscripcionToAttach = em.getReference(inscripcionCollectionNewInscripcionToAttach.getClass(), inscripcionCollectionNewInscripcionToAttach.getIdinscripcion());
                attachedInscripcionCollectionNew.add(inscripcionCollectionNewInscripcionToAttach);
            }
            inscripcionCollectionNew = attachedInscripcionCollectionNew;
            horarioMateria.setInscripcionCollection(inscripcionCollectionNew);
            horarioMateria = em.merge(horarioMateria);
            if (idhorarioOld != null && !idhorarioOld.equals(idhorarioNew)) {
                idhorarioOld.getHorarioMateriaCollection().remove(horarioMateria);
                idhorarioOld = em.merge(idhorarioOld);
            }
            if (idhorarioNew != null && !idhorarioNew.equals(idhorarioOld)) {
                idhorarioNew.getHorarioMateriaCollection().add(horarioMateria);
                idhorarioNew = em.merge(idhorarioNew);
            }
            if (idmateriaOld != null && !idmateriaOld.equals(idmateriaNew)) {
                idmateriaOld.getHorarioMateriaCollection().remove(horarioMateria);
                idmateriaOld = em.merge(idmateriaOld);
            }
            if (idmateriaNew != null && !idmateriaNew.equals(idmateriaOld)) {
                idmateriaNew.getHorarioMateriaCollection().add(horarioMateria);
                idmateriaNew = em.merge(idmateriaNew);
            }
            for (Inscripcion inscripcionCollectionOldInscripcion : inscripcionCollectionOld) {
                if (!inscripcionCollectionNew.contains(inscripcionCollectionOldInscripcion)) {
                    inscripcionCollectionOldInscripcion.setIdmateriahorario(null);
                    inscripcionCollectionOldInscripcion = em.merge(inscripcionCollectionOldInscripcion);
                }
            }
            for (Inscripcion inscripcionCollectionNewInscripcion : inscripcionCollectionNew) {
                if (!inscripcionCollectionOld.contains(inscripcionCollectionNewInscripcion)) {
                    HorarioMateria oldIdmateriahorarioOfInscripcionCollectionNewInscripcion = inscripcionCollectionNewInscripcion.getIdmateriahorario();
                    inscripcionCollectionNewInscripcion.setIdmateriahorario(horarioMateria);
                    inscripcionCollectionNewInscripcion = em.merge(inscripcionCollectionNewInscripcion);
                    if (oldIdmateriahorarioOfInscripcionCollectionNewInscripcion != null && !oldIdmateriahorarioOfInscripcionCollectionNewInscripcion.equals(horarioMateria)) {
                        oldIdmateriahorarioOfInscripcionCollectionNewInscripcion.getInscripcionCollection().remove(inscripcionCollectionNewInscripcion);
                        oldIdmateriahorarioOfInscripcionCollectionNewInscripcion = em.merge(oldIdmateriahorarioOfInscripcionCollectionNewInscripcion);
                    }
                }
            }
=======
//            List<Inscripcion> inscripcionListOld = persistentHorarioMateria.getInscripcionList();
//            List<Inscripcion> inscripcionListNew = horarioMateria.getInscripcionList();
//            if (idhorarioNew != null) {
//                idhorarioNew = em.getReference(idhorarioNew.getClass(), idhorarioNew.getIdhorario());
//                horarioMateria.setIdhorario(idhorarioNew);
//            }
//            if (idmateriaNew != null) {
//                idmateriaNew = em.getReference(idmateriaNew.getClass(), idmateriaNew.getIdmateria());
//                horarioMateria.setIdmateria(idmateriaNew);
//            }
//            List<Inscripcion> attachedInscripcionListNew = new ArrayList<Inscripcion>();
//            for (Inscripcion inscripcionListNewInscripcionToAttach : inscripcionListNew) {
//                inscripcionListNewInscripcionToAttach = em.getReference(inscripcionListNewInscripcionToAttach.getClass(), inscripcionListNewInscripcionToAttach.getIdinscripcion());
//                attachedInscripcionListNew.add(inscripcionListNewInscripcionToAttach);
//            }
//            inscripcionListNew = attachedInscripcionListNew;
//            horarioMateria.setInscripcionList(inscripcionListNew);
            horarioMateria = em.merge(horarioMateria);
//            if (idhorarioOld != null && !idhorarioOld.equals(idhorarioNew)) {
//                idhorarioOld.getHorarioMateriaList().remove(horarioMateria);
//                idhorarioOld = em.merge(idhorarioOld);
//            }
//            if (idhorarioNew != null && !idhorarioNew.equals(idhorarioOld)) {
//                idhorarioNew.getHorarioMateriaList().add(horarioMateria);
//                idhorarioNew = em.merge(idhorarioNew);
//            }
//            if (idmateriaOld != null && !idmateriaOld.equals(idmateriaNew)) {
//                idmateriaOld.getHorarioMateriaList().remove(horarioMateria);
//                idmateriaOld = em.merge(idmateriaOld);
//            }
//            if (idmateriaNew != null && !idmateriaNew.equals(idmateriaOld)) {
//                idmateriaNew.getHorarioMateriaList().add(horarioMateria);
//                idmateriaNew = em.merge(idmateriaNew);
//            }
//            for (Inscripcion inscripcionListOldInscripcion : inscripcionListOld) {
//                if (!inscripcionListNew.contains(inscripcionListOldInscripcion)) {
//                    inscripcionListOldInscripcion.setIdmateriahorario(null);
//                    inscripcionListOldInscripcion = em.merge(inscripcionListOldInscripcion);
//                }
//            }
//            for (Inscripcion inscripcionListNewInscripcion : inscripcionListNew) {
//                if (!inscripcionListOld.contains(inscripcionListNewInscripcion)) {
//                    HorarioMateria oldIdmateriahorarioOfInscripcionListNewInscripcion = inscripcionListNewInscripcion.getIdmateriahorario();
//                    inscripcionListNewInscripcion.setIdmateriahorario(horarioMateria);
//                    inscripcionListNewInscripcion = em.merge(inscripcionListNewInscripcion);
//                    if (oldIdmateriahorarioOfInscripcionListNewInscripcion != null && !oldIdmateriahorarioOfInscripcionListNewInscripcion.equals(horarioMateria)) {
//                        oldIdmateriahorarioOfInscripcionListNewInscripcion.getInscripcionList().remove(inscripcionListNewInscripcion);
//                        oldIdmateriahorarioOfInscripcionListNewInscripcion = em.merge(oldIdmateriahorarioOfInscripcionListNewInscripcion);
//                    }
//                }
//            }
>>>>>>> master
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = horarioMateria.getIdmateriahorario();
                if (findHorarioMateria(id) == null) {
                    throw new NonexistentEntityException("The horarioMateria with id " + id + " no longer exists.");
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
            HorarioMateria horarioMateria;
            try {
                horarioMateria = em.getReference(HorarioMateria.class, id);
                horarioMateria.getIdmateriahorario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The horarioMateria with id " + id + " no longer exists.", enfe);
            }
            Horario idhorario = horarioMateria.getIdhorario();
            if (idhorario != null) {
                idhorario.getHorarioMateriaCollection().remove(horarioMateria);
                idhorario = em.merge(idhorario);
            }
            Materia idmateria = horarioMateria.getIdmateria();
            if (idmateria != null) {
                idmateria.getHorarioMateriaCollection().remove(horarioMateria);
                idmateria = em.merge(idmateria);
            }
            Collection<Inscripcion> inscripcionCollection = horarioMateria.getInscripcionCollection();
            for (Inscripcion inscripcionCollectionInscripcion : inscripcionCollection) {
                inscripcionCollectionInscripcion.setIdmateriahorario(null);
                inscripcionCollectionInscripcion = em.merge(inscripcionCollectionInscripcion);
            }
            em.remove(horarioMateria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HorarioMateria> findHorarioMateriaEntities() {
        return findHorarioMateriaEntities(true, -1, -1);
    }

    public List<HorarioMateria> findHorarioMateriaEntities(int maxResults, int firstResult) {
        return findHorarioMateriaEntities(false, maxResults, firstResult);
    }

    private List<HorarioMateria> findHorarioMateriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HorarioMateria.class));
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

    public HorarioMateria findHorarioMateria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HorarioMateria.class, id);
        } finally {
            em.close();
        }
    }

    public int getHorarioMateriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HorarioMateria> rt = cq.from(HorarioMateria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
