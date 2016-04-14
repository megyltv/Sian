package Entidades;

import Entidades.Materia;
import Entidades.PeriodoActual;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-14T17:48:47")
@StaticMetamodel(Nivel.class)
public class Nivel_ { 

    public static volatile SingularAttribute<Nivel, PeriodoActual> idperiodo;
    public static volatile SingularAttribute<Nivel, Integer> idnivel;
    public static volatile ListAttribute<Nivel, Materia> materiaList;
    public static volatile SingularAttribute<Nivel, Integer> nivel;

}