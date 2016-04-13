package Entidades;

import Entidades.Estudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-13T15:03:34")
@StaticMetamodel(Preguntas.class)
public class Preguntas_ { 

    public static volatile SingularAttribute<Preguntas, Integer> opcion;
    public static volatile ListAttribute<Preguntas, Estudiante> estudianteList;
    public static volatile SingularAttribute<Preguntas, String> respuesta;
    public static volatile SingularAttribute<Preguntas, Integer> numpregunta;
    public static volatile SingularAttribute<Preguntas, Integer> idpreguntas;

}