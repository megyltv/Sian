package Controlador.Calificacion;

import Entidades.HorarioMateria;
import Entidades.Inscripcion;
import Entidades.Periodo;
import JpaControllers.InscripcionJpaController;
import JpaControllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ControladorCrudInscripcion {
    EntityManager em;
    InscripcionJpaController controladorInscripcion = new InscripcionJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
    Inscripcion inscripcionBuscada;
    
    public List consultarListaMaterias(Periodo periodo, HorarioMateria matHora){
        em = controladorInscripcion.getEntityManager();
        List <Inscripcion> lstInscripcion = em.createNamedQuery("Inscripcion.findByPeriodoHorario", Inscripcion.class).setParameter("idperiodo", periodo).setParameter("idmateriahorario", matHora).getResultList();  
        return lstInscripcion;
    }
    
    public void editarInscripcion (Inscripcion inscripcion) throws NonexistentEntityException, Exception{
        em = controladorInscripcion.getEntityManager();
        controladorInscripcion.edit(inscripcion);
    }
}
