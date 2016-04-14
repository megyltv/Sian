package Entidades;

import Entidades.Estudiante;
import Entidades.Materia;
import Entidades.PeriodoActual;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-14T16:10:33")
@StaticMetamodel(Inscripcion.class)
public class Inscripcion_ { 

    public static volatile SingularAttribute<Inscripcion, PeriodoActual> idperiodo;
    public static volatile SingularAttribute<Inscripcion, String> idinscripcion;
    public static volatile SingularAttribute<Inscripcion, Estudiante> cedula;
    public static volatile ListAttribute<Inscripcion, Materia> materiaList;

}