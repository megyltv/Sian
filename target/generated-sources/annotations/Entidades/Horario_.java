package Entidades;

import Entidades.Horariomateria;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-14T16:10:33")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile SingularAttribute<Horario, String> hora;
    public static volatile ListAttribute<Horario, Horariomateria> horariomateriaList;
    public static volatile SingularAttribute<Horario, Integer> idhorario;
    public static volatile SingularAttribute<Horario, String> dia;

}