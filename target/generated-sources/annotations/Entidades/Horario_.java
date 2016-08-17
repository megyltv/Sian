package Entidades;

import Entidades.Materia;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T23:03:19")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile SingularAttribute<Horario, Integer> estado;
    public static volatile SingularAttribute<Horario, String> hora;
    public static volatile ListAttribute<Horario, Materia> materiaList;
    public static volatile SingularAttribute<Horario, Integer> idhorario;
    public static volatile SingularAttribute<Horario, String> dia;

}