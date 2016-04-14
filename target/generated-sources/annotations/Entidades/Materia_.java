package Entidades;

import Entidades.Horariomateria;
import Entidades.Inscripcion;
import Entidades.Nivel;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-14T16:10:33")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, Inscripcion> idinscripcion;
    public static volatile SingularAttribute<Materia, Nivel> idnivel;
    public static volatile ListAttribute<Materia, Horariomateria> horariomateriaList;
    public static volatile SingularAttribute<Materia, String> materia;
    public static volatile SingularAttribute<Materia, Integer> idmateria;

}