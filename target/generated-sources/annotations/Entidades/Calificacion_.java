package Entidades;

import Entidades.Estudiante;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-13T15:03:34")
@StaticMetamodel(Calificacion.class)
public class Calificacion_ { 

    public static volatile SingularAttribute<Calificacion, BigDecimal> calificacion;
    public static volatile SingularAttribute<Calificacion, Integer> idcalificacion;
    public static volatile SingularAttribute<Calificacion, Estudiante> cedula;

}