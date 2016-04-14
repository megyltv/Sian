package Entidades;

import Entidades.Estudiante;
import Entidades.Horariomateria;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-14T16:10:33")
@StaticMetamodel(Calificacion.class)
public class Calificacion_ { 

    public static volatile SingularAttribute<Calificacion, BigDecimal> calificacion;
    public static volatile SingularAttribute<Calificacion, Integer> idcalificacion;
    public static volatile SingularAttribute<Calificacion, Estudiante> cedula;
    public static volatile ListAttribute<Calificacion, Horariomateria> horariomateriaList;

}