package Entidades;

import Entidades.Calificacion;
import Entidades.Inscripcion;
import Entidades.Preguntas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-14T16:10:33")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, String> apellidos;
    public static volatile SingularAttribute<Estudiante, String> nombcony;
    public static volatile SingularAttribute<Estudiante, Integer> cedula;
    public static volatile SingularAttribute<Estudiante, String> estadocivil;
    public static volatile SingularAttribute<Estudiante, Integer> hijos;
    public static volatile ListAttribute<Estudiante, Inscripcion> inscripcionList;
    public static volatile ListAttribute<Estudiante, Preguntas> preguntasList;
    public static volatile SingularAttribute<Estudiante, Integer> telfemerg;
    public static volatile SingularAttribute<Estudiante, String> nombres;
    public static volatile SingularAttribute<Estudiante, Integer> creycony;
    public static volatile SingularAttribute<Estudiante, String> nombemerg;
    public static volatile SingularAttribute<Estudiante, Date> fechanac;
    public static volatile SingularAttribute<Estudiante, String> correo;
    public static volatile SingularAttribute<Estudiante, String> nivelinst;
    public static volatile SingularAttribute<Estudiante, Integer> celular;
    public static volatile SingularAttribute<Estudiante, Integer> telefono;
    public static volatile SingularAttribute<Estudiante, String> profesion;
    public static volatile ListAttribute<Estudiante, Calificacion> calificacionList;
    public static volatile SingularAttribute<Estudiante, String> sector;

}