package Entidades;

import Entidades.Horario;
import Entidades.Inscripcion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T23:03:19")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile ListAttribute<Materia, Inscripcion> inscripcionList;
    public static volatile SingularAttribute<Materia, String> materia;
    public static volatile SingularAttribute<Materia, Integer> idmateria;
    public static volatile SingularAttribute<Materia, Integer> nivel;
    public static volatile ListAttribute<Materia, Horario> horarioList;

}