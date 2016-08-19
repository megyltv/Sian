/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Periodo;

import Entidades.Periodo;
import JpaControllers.PeriodoJpaController;
import JpaControllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Iker Gael
 */
public class ControladorCrudPeriodo {
    //Permite acceder a las entidades
    EntityManager em;
    Periodo periodoBuscado;
    PeriodoJpaController controladorPeriodo = new PeriodoJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));

    //Mètodo para crear un nuevo periodo
    public void crearPeriodo (Periodo periodo) throws Exception{
        em = controladorPeriodo.getEntityManager();
        controladorPeriodo.create(periodo);  
    }
    
    //Método para consultar periodopor medio de su nombre 
    public Periodo consultarPeriodoPorNombre(String periodo){
        em = controladorPeriodo.getEntityManager();
        //ojo enviar el parametro que recibe este metodo como parametro que se le envia a la consulta
        List <Periodo> lstPeriodo = em.createNamedQuery("Periodo.findByPeriodo", Periodo.class).setParameter("periodo", periodo).getResultList();        
        periodoBuscado = new Periodo();
        if (!lstPeriodo.isEmpty()) {
            periodoBuscado=lstPeriodo.get(0);
        }
        return periodoBuscado;
    }
    
     //Método para editar periodo
     public void editarPeriodo (Periodo periodo) throws NonexistentEntityException, Exception{
        em = controladorPeriodo.getEntityManager();
         controladorPeriodo.edit(periodo);
     }
    
}
