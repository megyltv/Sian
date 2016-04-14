package Entidades;

import Entidades.Inscripcion;
import Entidades.Nivel;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-14T17:48:47")
@StaticMetamodel(PeriodoActual.class)
public class PeriodoActual_ { 

    public static volatile SingularAttribute<PeriodoActual, Date> fechainicio;
    public static volatile SingularAttribute<PeriodoActual, Integer> idperiodo;
    public static volatile ListAttribute<PeriodoActual, Nivel> nivelList;
    public static volatile SingularAttribute<PeriodoActual, String> periodo;
    public static volatile ListAttribute<PeriodoActual, Inscripcion> inscripcionList;
    public static volatile SingularAttribute<PeriodoActual, Date> fechafin;

}