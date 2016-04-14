package Entidades;

import Entidades.Calificacion;
import Entidades.Horario;
import Entidades.HorariomateriaPK;
import Entidades.Materia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-14T16:10:33")
@StaticMetamodel(Horariomateria.class)
public class Horariomateria_ { 

    public static volatile SingularAttribute<Horariomateria, Horario> horario;
    public static volatile SingularAttribute<Horariomateria, Calificacion> idcalificacion;
    public static volatile SingularAttribute<Horariomateria, HorariomateriaPK> horariomateriaPK;
    public static volatile SingularAttribute<Horariomateria, Materia> materia;

}