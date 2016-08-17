package Entidades;

import Entidades.Estudiante;
import Entidades.Materia;
import Entidades.Periodo;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T23:03:19")
@StaticMetamodel(Inscripcion.class)
public class Inscripcion_ { 

    public static volatile SingularAttribute<Inscripcion, Periodo> idperiodo;
    public static volatile SingularAttribute<Inscripcion, String> idinscripcion;
    public static volatile SingularAttribute<Inscripcion, BigDecimal> calificacion;
    public static volatile SingularAttribute<Inscripcion, Estudiante> idestudiante;
    public static volatile SingularAttribute<Inscripcion, Materia> idmateria;

}