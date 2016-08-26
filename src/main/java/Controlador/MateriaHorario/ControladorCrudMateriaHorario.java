/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.MateriaHorario;

import Entidades.Horario;
import Entidades.HorarioMateria;
import Entidades.Materia;
import JpaControllers.HorarioJpaController;
import JpaControllers.HorarioMateriaJpaController;
import JpaControllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Megan
 */
public class ControladorCrudMateriaHorario {
    EntityManager em;
    Horario horariosBuscada;
    HorarioMateria horarioMateria;
    HorarioMateriaJpaController controladorHorarioMateria = new HorarioMateriaJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
    
    HorarioJpaController controladorHorario = new HorarioJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
    
    //Mètodo para crear un nueva materia
    public void crearHorarioMateria (HorarioMateria horarioMateria) throws Exception{
        em = controladorHorarioMateria.getEntityManager();
        controladorHorarioMateria.create(horarioMateria);
    }
    
    //Método para editar materia
    public void editarHorarioMateria (HorarioMateria horarioMateria) throws NonexistentEntityException, Exception{
        em = controladorHorarioMateria.getEntityManager();
        controladorHorarioMateria.edit(horarioMateria);
    }
         
    public List consultarListaHorarios(){
        em = controladorHorario.getEntityManager();
        List <Horario> lstHorario = em.createNamedQuery("Horario.findAll", Horario.class).getResultList();  
        
        horariosBuscada = new Horario();
        if (!lstHorario.isEmpty()) {
            horariosBuscada=lstHorario.get(0);
            System.out.println(horariosBuscada.getDia().toString());
        }
        return lstHorario;
    }
     
     //Método para consultar materia
     public HorarioMateria consultarHorarioMateria(Materia materia, Horario horario){
         em = controladorHorarioMateria.getEntityManager();
         List <HorarioMateria> lstHorarioMateria = em.createNamedQuery("HorarioMateria.findByHorarioMateria", HorarioMateria.class).setParameter("idmateria", materia).setParameter("idhorario", horario).getResultList();   
         horarioMateria = new HorarioMateria();
         if (!lstHorarioMateria.isEmpty()) {
            horarioMateria=lstHorarioMateria.get(0);
        }
        return horarioMateria;
     } 
     
     //Metodo para consultar horarios de una materia
     public List consultarListaHorariosPorMateria(Materia materia){
        em = controladorHorarioMateria.getEntityManager();
        List <HorarioMateria> lstHorarioMateria = em.createNamedQuery("HorarioMateria.findByMateria", HorarioMateria.class).setParameter("idmateria", materia).getResultList();  
        
        horarioMateria = new HorarioMateria();
        if (!lstHorarioMateria.isEmpty()) {
            horarioMateria=lstHorarioMateria.get(0);
            System.out.println(horarioMateria.getIdhorario().toString());
        }
        return lstHorarioMateria;
    }
     
    public Horario consultarHorario(int horario){
        em = controladorHorarioMateria.getEntityManager();
        System.out.println("Entro31");
        List <Horario> lstHorario = em.createNamedQuery("Horario.findByIdhorario", Horario.class).setParameter("idhorario", horario).getResultList();  
        horariosBuscada = new Horario();
        if(!lstHorario.isEmpty()){
            horariosBuscada=lstHorario.get(0);
        }
        return horariosBuscada;
    }
}
