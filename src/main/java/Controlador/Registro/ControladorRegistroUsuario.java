package Controlador.Registro;

import JpaControllers.EstudianteJpaController;
import JpaControllers.exceptions.NonexistentEntityException;
import JpaControllers.PreguntasJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import Entidades.Estudiante;
import Entidades.Preguntas;

public class ControladorRegistroUsuario {
    EntityManager em;
    Estudiante est;
    Preguntas pr;

    //Estudiante
    public void crearEstudiante (Estudiante estudiante) throws Exception{
        EstudianteJpaController controladorEstudiante = new EstudianteJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
        em = controladorEstudiante.getEntityManager();
        controladorEstudiante.create(estudiante);  
    }
    
    public void editarEstudiante (Estudiante estudiante) throws NonexistentEntityException, Exception{
        EstudianteJpaController controladorEstudiante = new EstudianteJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
        em = controladorEstudiante.getEntityManager();
        controladorEstudiante.edit(estudiante);
    }
    
    public Estudiante consultarCedula(int cedula){
        EstudianteJpaController controladorEstudiante = new EstudianteJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));     
        em = controladorEstudiante.getEntityManager();
        List <Estudiante> lstEstudiante = em.createNamedQuery("Estudiante.findByCedula", Estudiante.class).setParameter("cedula", cedula).getResultList();        
        est = new Estudiante();
        if (!lstEstudiante.isEmpty()) {
            est=lstEstudiante.get(0);
        }
        return est;
    }
    
    //Preguntas
    public void crearPreguntas (Preguntas pregunta) throws Exception{
        PreguntasJpaController controladorPreguntas = new PreguntasJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
        em = controladorPreguntas.getEntityManager();
        controladorPreguntas.create(pregunta);
    }
    
    public Preguntas consultarCedulaPreguntas(Estudiante idEstudiante){
        PreguntasJpaController controladorPreguntas = new PreguntasJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
        em = controladorPreguntas.getEntityManager();
        List <Preguntas> lstPreguntas = em.createNamedQuery("Preguntas.findByIdEstudiante",Preguntas.class).setParameter("idestudiante",idEstudiante).getResultList();
        pr = new Preguntas();
        if (!lstPreguntas.isEmpty()){
            pr=lstPreguntas.get(0);
        }
        return pr;
    }
    
    public void editarPregunta (Preguntas pregunta) throws Exception{
        PreguntasJpaController controladorPreguntas = new PreguntasJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
        em = controladorPreguntas.getEntityManager();
        controladorPreguntas.edit(pregunta);
    }
    
    public void eliminarPregunta (Estudiante estudiante){
        
    }
    
    
}
