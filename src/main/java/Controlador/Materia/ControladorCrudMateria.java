package Controlador.Materia;

import Entidades.Materia;
import JpaControllers.MateriaJpaController;
import JpaControllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ControladorCrudMateria {
    EntityManager em;
    Materia materiaBuscada;
    MateriaJpaController controladorMateria = new MateriaJpaController(Persistence.createEntityManagerFactory("com.mycompany_SianCliente_jar_1.0-SNAPSHOTPU"));
    
    //Mètodo para crear un nueva materia
    public void crearMateria (Materia materia) throws Exception{
        em = controladorMateria.getEntityManager();
        controladorMateria.create(materia);
    }
    
    //Método para editar materia
     public void editarMateria (Materia materia) throws NonexistentEntityException, Exception{
        em = controladorMateria.getEntityManager();
        controladorMateria.edit(materia);
     }
     
     //Método para consultar materia
     public Materia consultarMateriaPorNombre(String materia){
         em = controladorMateria.getEntityManager();
         List <Materia> lstMateria = em.createNamedQuery("Materia.findByMateria", Materia.class).setParameter("materia", materia).getResultList();   
         materiaBuscada = new Materia();
         if (!lstMateria.isEmpty()) {
            materiaBuscada=lstMateria.get(0);
        }
        return materiaBuscada;
     }
}