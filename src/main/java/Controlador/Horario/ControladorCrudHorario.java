/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Horario;

import Entidades.Horario;
import JpaControllers.HorarioJpaController;
import JpaControllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Iker Gael
 */
public class ControladorCrudHorario {
    //Permite acceder a las entidades
    EntityManager em;
    HorarioJpaController controladorHorario = new HorarioJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
Horario horariosBuscada;
    
    //Mètodo para crear un nuevo periodo
    public void crearHorario (Horario horario) throws Exception{
        em = controladorHorario.getEntityManager();
        controladorHorario.create(horario);  
    }
    
    //Método para consultar el horario por medio de su dia 
    public List consultarHorarioPorDia(String dia){
        em = controladorHorario.getEntityManager();
        //ojo enviar el parametro que recibe este metodo como parametro que se le envia a la consulta
        List <Horario> lstHorario = em.createNamedQuery("Horario.findByDia", Horario.class).setParameter("dia", dia).getResultList();        
        return lstHorario;
    }
    
    public Horario consultarHorario(int horario){
        System.out.println("Entro31");
        em = controladorHorario.getEntityManager();
        System.out.println("Entro31");
        List <Horario> lstHorario = em.createNamedQuery("Horario.findByIdhorario", Horario.class).setParameter("idhorario", horario).getResultList();  
        horariosBuscada = new Horario();
        if(!lstHorario.isEmpty()){
            horariosBuscada=lstHorario.get(0);
        }
        return horariosBuscada;
    }
    
    //Método para editar horario
     public void editarHorario (Horario horario) throws NonexistentEntityException, Exception{
        em = controladorHorario.getEntityManager();
         controladorHorario.edit(horario);
     }
    
}
