/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JpaControllers;

import Entidades.Horario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Materia;
import java.util.ArrayList;
import java.util.List;
import Entidades.HorarioMateria;
import JpaControllers.exceptions.IllegalOrphanException;
import JpaControllers.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Megan
 */
public class HorarioJpaController implements Serializable {

    public HorarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Horario horario) {
        if (horario.getMateriaList() == null) {
            horario.setMateriaList(new ArrayList<Materia>());
        }
        if (horario.getHorarioMateriaList() == null) {
            horario.setHorarioMateriaList(new ArrayList<HorarioMateria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Materia> attachedMateriaList = new ArrayList<Materia>();
            for (Materia materiaListMateriaToAttach : horario.getMateriaList()) {
                materiaListMateriaToAttach = em.getReference(materiaListMateriaToAttach.getClass(), materiaListMateriaToAttach.getIdmateria());
                attachedMateriaList.add(materiaListMateriaToAttach);
            }
            horario.setMateriaList(attachedMateriaList);
            List<HorarioMateria> attachedHorarioMateriaList = new ArrayList<HorarioMateria>();
            for (HorarioMateria horarioMateriaListHorarioMateriaToAttach : horario.getHorarioMateriaList()) {
                horarioMateriaListHorarioMateriaToAttach = em.getReference(horarioMateriaListHorarioMateriaToAttach.getClass(), horarioMateriaListHorarioMateriaToAttach.getIdmateriahorario());
                attachedHorarioMateriaList.add(horarioMateriaListHorarioMateriaToAttach);
            }
            horario.setHorarioMateriaList(attachedHorarioMateriaList);
            em.persist(horario);
            for (Materia materiaListMateria : horario.getMateriaList()) {
                materiaListMateria.getHorarioList().add(horario);
                materiaListMateria = em.merge(materiaListMateria);
            }
            for (HorarioMateria horarioMateriaListHorarioMateria : horario.getHorarioMateriaList()) {
                Horario oldIdhorarioOfHorarioMateriaListHorarioMateria = horarioMateriaListHorarioMateria.getIdhorario();
                horarioMateriaListHorarioMateria.setIdhorario(horario);
                horarioMateriaListHorarioMateria = em.merge(horarioMateriaListHorarioMateria);
                if (oldIdhorarioOfHorarioMateriaListHorarioMateria != null) {
                    oldIdhorarioOfHorarioMateriaListHorarioMateria.getHorarioMateriaList().remove(horarioMateriaListHorarioMateria);
                    oldIdhorarioOfHorarioMateriaListHorarioMateria = em.merge(oldIdhorarioOfHorarioMateriaListHorarioMateria);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Horario horario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Horario persistentHorario = em.find(Horario.class, horario.getIdhorario());
            List<Materia> materiaListOld = persistentHorario.getMateriaList();
            List<Materia> materiaListNew = horario.getMateriaList();
            List<HorarioMateria> horarioMateriaListOld = persistentHorario.getHorarioMateriaList();
            List<HorarioMateria> horarioMateriaListNew = horario.getHorarioMateriaList();
            List<String> illegalOrphanMessages = null;
            for (HorarioMateria horarioMateriaListOldHorarioMateria : horarioMateriaListOld) {
                if (!horarioMateriaListNew.contains(horarioMateriaListOldHorarioMateria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HorarioMateria " + horarioMateriaListOldHorarioMateria + " since its idhorario field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Materia> attachedMateriaListNew = new ArrayList<Materia>();
            for (Materia materiaListNewMateriaToAttach : materiaListNew) {
                materiaListNewMateriaToAttach = em.getReference(materiaListNewMateriaToAttach.getClass(), materiaListNewMateriaToAttach.getIdmateria());
                attachedMateriaListNew.add(materiaListNewMateriaToAttach);
            }
            materiaListNew = attachedMateriaListNew;
            horario.setMateriaList(materiaListNew);
            List<HorarioMateria> attachedHorarioMateriaListNew = new ArrayList<HorarioMateria>();
            for (HorarioMateria horarioMateriaListNewHorarioMateriaToAttach : horarioMateriaListNew) {
                horarioMateriaListNewHorarioMateriaToAttach = em.getReference(horarioMateriaListNewHorarioMateriaToAttach.getClass(), horarioMateriaListNewHorarioMateriaToAttach.getIdmateriahorario());
                attachedHorarioMateriaListNew.add(horarioMateriaListNewHorarioMateriaToAttach);
            }
            horarioMateriaListNew = attachedHorarioMateriaListNew;
            horario.setHorarioMateriaList(horarioMateriaListNew);
            horario = em.merge(horario);
            for (Materia materiaListOldMateria : materiaListOld) {
                if (!materiaListNew.contains(materiaListOldMateria)) {
                    materiaListOldMateria.getHorarioList().remove(horario);
                    materiaListOldMateria = em.merge(materiaListOldMateria);
                }
            }
            for (Materia materiaListNewMateria : materiaListNew) {
                if (!materiaListOld.contains(materiaListNewMateria)) {
                    materiaListNewMateria.getHorarioList().add(horario);
                    materiaListNewMateria = em.merge(materiaListNewMateria);
                }
            }
            for (HorarioMateria horarioMateriaListNewHorarioMateria : horarioMateriaListNew) {
                if (!horarioMateriaListOld.contains(horarioMateriaListNewHorarioMateria)) {
                    Horario oldIdhorarioOfHorarioMateriaListNewHorarioMateria = horarioMateriaListNewHorarioMateria.getIdhorario();
                    horarioMateriaListNewHorarioMateria.setIdhorario(horario);
                    horarioMateriaListNewHorarioMateria = em.merge(horarioMateriaListNewHorarioMateria);
                    if (oldIdhorarioOfHorarioMateriaListNewHorarioMateria != null && !oldIdhorarioOfHorarioMateriaListNewHorarioMateria.equals(horario)) {
                        oldIdhorarioOfHorarioMateriaListNewHorarioMateria.getHorarioMateriaList().remove(horarioMateriaListNewHorarioMateria);
                        oldIdhorarioOfHorarioMateriaListNewHorarioMateria = em.merge(oldIdhorarioOfHorarioMateriaListNewHorarioMateria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = horario.getIdhorario();
                if (findHorario(id) == null) {
                    throw new NonexistentEntityException("The horario with id " + id + " no longer exists.");
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
            Horario horario;
            try {
                horario = em.getReference(Horario.class, id);
                horario.getIdhorario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The horario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<HorarioMateria> horarioMateriaListOrphanCheck = horario.getHorarioMateriaList();
            for (HorarioMateria horarioMateriaListOrphanCheckHorarioMateria : horarioMateriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Horario (" + horario + ") cannot be destroyed since the HorarioMateria " + horarioMateriaListOrphanCheckHorarioMateria + " in its horarioMateriaList field has a non-nullable idhorario field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Materia> materiaList = horario.getMateriaList();
            for (Materia materiaListMateria : materiaList) {
                materiaListMateria.getHorarioList().remove(horario);
                materiaListMateria = em.merge(materiaListMateria);
            }
            em.remove(horario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Horario> findHorarioEntities() {
        return findHorarioEntities(true, -1, -1);
    }

    public List<Horario> findHorarioEntities(int maxResults, int firstResult) {
        return findHorarioEntities(false, maxResults, firstResult);
    }

    private List<Horario> findHorarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Horario.class));
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

    public Horario findHorario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Horario.class, id);
        } finally {
            em.close();
        }
    }

    public int getHorarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Horario> rt = cq.from(Horario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
