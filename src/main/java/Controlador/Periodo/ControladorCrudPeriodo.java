/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Periodo;

import Entidades.Periodo;
import JpaControllers.PeriodoJpaController;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Iker Gael
 */
public class ControladorCrudPeriodo {
    //Permite acceder a las entidades
    EntityManager em;
    Periodo nuevoPeriodo;
    

    //Mètodo para crear un nuevo periodo
    public void crearPeriodo (Periodo periodo) throws Exception{
        PeriodoJpaController controladorPeriodo = new PeriodoJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
        em = controladorPeriodo.getEntityManager();
        controladorPeriodo.create(periodo);  
    }
}
