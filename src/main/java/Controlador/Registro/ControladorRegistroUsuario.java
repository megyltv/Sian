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
        EntityManager em = controladorEstudiante.getEntityManager();
        controladorEstudiante.create(estudiante);
         
    }
    
    public void editarEstudiante (Estudiante estudiante){
        
    }
    
    public void eliminarEstudiante (Estudiante estudiante){
        
    }
    
    public void consultarCedula(){
        EstudianteJpaController controladorEstudiante = new EstudianteJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
        EntityManager em = controladorEstudiante.getEntityManager();
        List <Estudiante> lstEstudiante = em.createNativeQuery("Estudiante.findByCedula", Estudiante.class).setParameter("cedula", 1714594551).getResultList();
    }
    
    //Preguntas
    public void crearPreguntas (Preguntas pregunta) throws Exception{
        PreguntasJpaController controladorPreguntas = new PreguntasJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
        EntityManager em = controladorPreguntas.getEntityManager();
        controladorPreguntas.create(pregunta);
    }
    
    public void editarPregunta (Estudiante estudiante){
        
    }
    
    public void eliminarPregunta (Estudiante estudiante){
        
    }
    
    
}
