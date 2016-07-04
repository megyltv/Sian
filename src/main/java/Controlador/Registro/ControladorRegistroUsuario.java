/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Registro;

import JpaControllers.EstudianteJpaController;
import JpaControllers.exceptions.NonexistentEntityException;
import JpaControllers.PreguntasJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import Entidades.Estudiante;
import Entidades.Preguntas;



/**
 *
 * @author Megan
 */
public class ControladorRegistroUsuario {
    EntityManager em;
    Estudiante est;
    Preguntas pr;
    /*public static void main(String args[]) throws NonexistentEntityException, Exception{
        EstudianteJpaController controladorEstudiante = new EstudianteJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
        EntityManager em = controladorEstudiante.getEntityManager();
        List <Estudiante> lstEstudiante = em.createNamedQuery("Estudiante.findByCedula", Estudiante.class).setParameter("cedula", 17).getResultList();
    
        for(Estudiante est : lstEstudiante){
            System.out.println(est.getApellidos());
            System.out.println(est.getTelefono());
        }
        int telf=2823652;
        lstEstudiante.get(0).setTelefono(telf);
        controladorEstudiante.edit(lstEstudiante.get(0));
        System.out.println(lstEstudiante.get(0).getTelefono());
    }*/
    
    //Estudiante
    public void crearEstudiante (Estudiante estudiante) throws Exception{
        EstudianteJpaController controladorEstudiante = new EstudianteJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
        em = controladorEstudiante.getEntityManager();
        controladorEstudiante.create(estudiante);
        
    }
    
    public void editarEstudiante (Estudiante estudiante){
        
    }
    
    public void eliminarEstudiante (Estudiante estudiante){
        
    }
    
    public Estudiante consultarCedula(Estudiante cedula){
        EstudianteJpaController controladorEstudiante = new EstudianteJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));     
        em = controladorEstudiante.getEntityManager();
        List <Estudiante> lstEstudiante = em.createNamedQuery("Estudiante.findByCedula", Estudiante.class).setParameter("cedula", cedula.getCedula()).getResultList();        
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
    
    public Preguntas consultarCedulaPreguntas(Estudiante cedula){
        PreguntasJpaController controladorPreguntas = new PreguntasJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
        em = controladorPreguntas.getEntityManager();
        List <Preguntas> lstPreguntas = em.createNamedQuery("Preguntas.findByCedula",Preguntas.class).setParameter("cedula", cedula.getCedula()).getResultList();
        pr = new Preguntas();
        if (!lstPreguntas.isEmpty()){
            pr=lstPreguntas.get(0);
        }
        return pr;
    }
    
    public void editarPregunta (Estudiante estudiante){
        PreguntasJpaController controladorEstudiante = new PreguntasJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
        em = controladorEstudiante.getEntityManager();
        
    }
    
    public void eliminarPregunta (Estudiante estudiante){
        
    }
    
    
}
