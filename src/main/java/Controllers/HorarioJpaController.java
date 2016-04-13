/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controlador.exceptions.IllegalOrphanException;
import Controlador.exceptions.NonexistentEntityException;
import Controlador.exceptions.PreexistingEntityException;
import Entidades.Horario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Horariomateria;
import java.util.ArrayList;
import java.util.List;
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

    public void create(Horario horario) throws PreexistingEntityException, Exception {
        if (horario.getHorariomateriaList() == null) {
            horario.setHorariomateriaList(new ArrayList<Horariomateria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Horariomateria> attachedHorariomateriaList = new ArrayList<Horariomateria>();
            for (Horariomateria horariomateriaListHorariomateriaToAttach : horario.getHorariomateriaList()) {
                horariomateriaListHorariomateriaToAttach = em.getReference(horariomateriaListHorariomateriaToAttach.getClass(), horariomateriaListHorariomateriaToAttach.getHorariomateriaPK());
                attachedHorariomateriaList.add(horariomateriaListHorariomateriaToAttach);
            }
            horario.setHorariomateriaList(attachedHorariomateriaList);
            em.persist(horario);
            for (Horariomateria horariomateriaListHorariomateria : horario.getHorariomateriaList()) {
                Horario oldHorarioOfHorariomateriaListHorariomateria = horariomateriaListHorariomateria.getHorario();
                horariomateriaListHorariomateria.setHorario(horario);
                horariomateriaListHorariomateria = em.merge(horariomateriaListHorariomateria);
                if (oldHorarioOfHorariomateriaListHorariomateria != null) {
                    oldHorarioOfHorariomateriaListHorariomateria.getHorariomateriaList().remove(horariomateriaListHorariomateria);
                    oldHorarioOfHorariomateriaListHorariomateria = em.merge(oldHorarioOfHorariomateriaListHorariomateria);
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
            List<Horariomateria> horariomateriaListOld = persistentHorario.getHorariomateriaList();
            List<Horariomateria> horariomateriaListNew = horario.getHorariomateriaList();
            List<String> illegalOrphanMessages = null;
            for (Horariomateria horariomateriaListOldHorariomateria : horariomateriaListOld) {
                if (!horariomateriaListNew.contains(horariomateriaListOldHorariomateria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Horariomateria " + horariomateriaListOldHorariomateria + " since its horario field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Horariomateria> attachedHorariomateriaListNew = new ArrayList<Horariomateria>();
            for (Horariomateria horariomateriaListNewHorariomateriaToAttach : horariomateriaListNew) {
                horariomateriaListNewHorariomateriaToAttach = em.getReference(horariomateriaListNewHorariomateriaToAttach.getClass(), horariomateriaListNewHorariomateriaToAttach.getHorariomateriaPK());
                attachedHorariomateriaListNew.add(horariomateriaListNewHorariomateriaToAttach);
            }
            horariomateriaListNew = attachedHorariomateriaListNew;
            horario.setHorariomateriaList(horariomateriaListNew);
            horario = em.merge(horario);
            for (Horariomateria horariomateriaListNewHorariomateria : horariomateriaListNew) {
                if (!horariomateriaListOld.contains(horariomateriaListNewHorariomateria)) {
                    Horario oldHorarioOfHorariomateriaListNewHorariomateria = horariomateriaListNewHorariomateria.getHorario();
                    horariomateriaListNewHorariomateria.setHorario(horario);
                    horariomateriaListNewHorariomateria = em.merge(horariomateriaListNewHorariomateria);
                    if (oldHorarioOfHorariomateriaListNewHorariomateria != null && !oldHorarioOfHorariomateriaListNewHorariomateria.equals(horario)) {
                        oldHorarioOfHorariomateriaListNewHorariomateria.getHorariomateriaList().remove(horariomateriaListNewHorariomateria);
                        oldHorarioOfHorariomateriaListNewHorariomateria = em.merge(oldHorarioOfHorariomateriaListNewHorariomateria);
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
            List<Horariomateria> horariomateriaListOrphanCheck = horario.getHorariomateriaList();
            for (Horariomateria horariomateriaListOrphanCheckHorariomateria : horariomateriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Horario (" + horario + ") cannot be destroyed since the Horariomateria " + horariomateriaListOrphanCheckHorariomateria + " in its horariomateriaList field has a non-nullable horario field.");
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
