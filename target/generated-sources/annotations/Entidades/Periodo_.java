package Entidades;

import Entidades.Inscripcion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T23:03:19")
@StaticMetamodel(Periodo.class)
public class Periodo_ { 

    public static volatile SingularAttribute<Periodo, Date> fechainicio;
    public static volatile SingularAttribute<Periodo, Integer> idperiodo;
    public static volatile SingularAttribute<Periodo, String> periodo;
    public static volatile ListAttribute<Periodo, Inscripcion> inscripcionList;
    public static volatile SingularAttribute<Periodo, Date> fechafin;

}