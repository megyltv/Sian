/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Registro;

import Entidades.Estudiante;
import Entidades.Preguntas;
import JpaControllers.PreguntasJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Megan
 */
public class ControladorRegistroPreguntas {
    EntityManager em;
    Preguntas pr;
    
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
