/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAControllers;

import Entidades.Horario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.MateriaHorario;
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
public class HorarioJpaController implements Serializable {

    public HorarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Horario horario) throws PreexistingEntityException, Exception {
        if (horario.getMateriaHorarioList() == null) {
            horario.setMateriaHorarioList(new ArrayList<MateriaHorario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<MateriaHorario> attachedMateriaHorarioList = new ArrayList<MateriaHorario>();
            for (MateriaHorario materiaHorarioListMateriaHorarioToAttach : horario.getMateriaHorarioList()) {
                materiaHorarioListMateriaHorarioToAttach = em.getReference(materiaHorarioListMateriaHorarioToAttach.getClass(), materiaHorarioListMateriaHorarioToAttach.getMateriaHorarioPK());
                attachedMateriaHorarioList.add(materiaHorarioListMateriaHorarioToAttach);
            }
            horario.setMateriaHorarioList(attachedMateriaHorarioList);
            em.persist(horario);
            for (MateriaHorario materiaHorarioListMateriaHorario : horario.getMateriaHorarioList()) {
                Horario oldHorarioOfMateriaHorarioListMateriaHorario = materiaHorarioListMateriaHorario.getHorario();
                materiaHorarioListMateriaHorario.setHorario(horario);
                materiaHorarioListMateriaHorario = em.merge(materiaHorarioListMateriaHorario);
                if (oldHorarioOfMateriaHorarioListMateriaHorario != null) {
                    oldHorarioOfMateriaHorarioListMateriaHorario.getMateriaHorarioList().remove(materiaHorarioListMateriaHorario);
                    oldHorarioOfMateriaHorarioListMateriaHorario = em.merge(oldHorarioOfMateriaHorarioListMateriaHorario);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHorario(horario.getIdhorario()) != null) {
                throw new PreexistingEntityException("Horario " + horario + " already exists.", ex);
            }
            throw ex;
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
            List<MateriaHorario> materiaHorarioListOld = persistentHorario.getMateriaHorarioList();
            List<MateriaHorario> materiaHorarioListNew = horario.getMateriaHorarioList();
            List<String> illegalOrphanMessages = null;
            for (MateriaHorario materiaHorarioListOldMateriaHorario : materiaHorarioListOld) {
                if (!materiaHorarioListNew.contains(materiaHorarioListOldMateriaHorario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain MateriaHorario " + materiaHorarioListOldMateriaHorario + " since its horario field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<MateriaHorario> attachedMateriaHorarioListNew = new ArrayList<MateriaHorario>();
            for (MateriaHorario materiaHorarioListNewMateriaHorarioToAttach : materiaHorarioListNew) {
                materiaHorarioListNewMateriaHorarioToAttach = em.getReference(materiaHorarioListNewMateriaHorarioToAttach.getClass(), materiaHorarioListNewMateriaHorarioToAttach.getMateriaHorarioPK());
                attachedMateriaHorarioListNew.add(materiaHorarioListNewMateriaHorarioToAttach);
            }
            materiaHorarioListNew = attachedMateriaHorarioListNew;
            horario.setMateriaHorarioList(materiaHorarioListNew);
            horario = em.merge(horario);
            for (MateriaHorario materiaHorarioListNewMateriaHorario : materiaHorarioListNew) {
                if (!materiaHorarioListOld.contains(materiaHorarioListNewMateriaHorario)) {
                    Horario oldHorarioOfMateriaHorarioListNewMateriaHorario = materiaHorarioListNewMateriaHorario.getHorario();
                    materiaHorarioListNewMateriaHorario.setHorario(horario);
                    materiaHorarioListNewMateriaHorario = em.merge(materiaHorarioListNewMateriaHorario);
                    if (oldHorarioOfMateriaHorarioListNewMateriaHorario != null && !oldHorarioOfMateriaHorarioListNewMateriaHorario.equals(horario)) {
                        oldHorarioOfMateriaHorarioListNewMateriaHorario.getMateriaHorarioList().remove(materiaHorarioListNewMateriaHorario);
                        oldHorarioOfMateriaHorarioListNewMateriaHorario = em.merge(oldHorarioOfMateriaHorarioListNewMateriaHorario);
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
            List<MateriaHorario> materiaHorarioListOrphanCheck = horario.getMateriaHorarioList();
            for (MateriaHorario materiaHorarioListOrphanCheckMateriaHorario : materiaHorarioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Horario (" + horario + ") cannot be destroyed since the MateriaHorario " + materiaHorarioListOrphanCheckMateriaHorario + " in its materiaHorarioList field has a non-nullable horario field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
