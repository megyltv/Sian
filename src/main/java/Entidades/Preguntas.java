/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Megan
 */
@Entity
@Table(name = "preguntas", catalog = "siand", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p"),
    @NamedQuery(name = "Preguntas.findByIdpreguntas", query = "SELECT p FROM Preguntas p WHERE p.idpreguntas = :idpreguntas"),
    @NamedQuery(name = "Preguntas.findByOpcion1", query = "SELECT p FROM Preguntas p WHERE p.opcion1 = :opcion1"),
    @NamedQuery(name = "Preguntas.findByRespuesta1", query = "SELECT p FROM Preguntas p WHERE p.respuesta1 = :respuesta1"),
    @NamedQuery(name = "Preguntas.findByOpcion2", query = "SELECT p FROM Preguntas p WHERE p.opcion2 = :opcion2"),
    @NamedQuery(name = "Preguntas.findByRespuesta2", query = "SELECT p FROM Preguntas p WHERE p.respuesta2 = :respuesta2"),
    @NamedQuery(name = "Preguntas.findByOpcion3", query = "SELECT p FROM Preguntas p WHERE p.opcion3 = :opcion3"),
    @NamedQuery(name = "Preguntas.findByRespuesta31", query = "SELECT p FROM Preguntas p WHERE p.respuesta31 = :respuesta31"),
    @NamedQuery(name = "Preguntas.findByRespuesta32", query = "SELECT p FROM Preguntas p WHERE p.respuesta32 = :respuesta32"),
    @NamedQuery(name = "Preguntas.findByOpcion4", query = "SELECT p FROM Preguntas p WHERE p.opcion4 = :opcion4"),
    @NamedQuery(name = "Preguntas.findByRespuesta4", query = "SELECT p FROM Preguntas p WHERE p.respuesta4 = :respuesta4"),
    @NamedQuery(name = "Preguntas.findByOpcion5", query = "SELECT p FROM Preguntas p WHERE p.opcion5 = :opcion5"),
    @NamedQuery(name = "Preguntas.findByRespuesta5", query = "SELECT p FROM Preguntas p WHERE p.respuesta5 = :respuesta5"),
    @NamedQuery(name = "Preguntas.findByOpcion6", query = "SELECT p FROM Preguntas p WHERE p.opcion6 = :opcion6"),
    @NamedQuery(name = "Preguntas.findByRespuesta6", query = "SELECT p FROM Preguntas p WHERE p.respuesta6 = :respuesta6"),
    @NamedQuery(name = "Preguntas.findByOpcion7", query = "SELECT p FROM Preguntas p WHERE p.opcion7 = :opcion7"),
    @NamedQuery(name = "Preguntas.findByRespuesta7", query = "SELECT p FROM Preguntas p WHERE p.respuesta7 = :respuesta7")})
public class Preguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpreguntas")
    private Integer idpreguntas;
    @Basic(optional = false)
    @Column(name = "opcion1")
    private int opcion1;
    @Column(name = "respuesta1")
    private String respuesta1;
    @Basic(optional = false)
    @Column(name = "opcion2")
    private int opcion2;
    @Column(name = "respuesta2")
    private String respuesta2;
    @Basic(optional = false)
    @Column(name = "opcion3")
    private int opcion3;
    @Column(name = "respuesta31")
    private String respuesta31;
    @Column(name = "respuesta32")
    private String respuesta32;
    @Basic(optional = false)
    @Column(name = "opcion4")
    private int opcion4;
    @Column(name = "respuesta4")
    private String respuesta4;
    @Basic(optional = false)
    @Column(name = "opcion5")
    private int opcion5;
    @Column(name = "respuesta5")
    private String respuesta5;
    @Basic(optional = false)
    @Column(name = "opcion6")
    private int opcion6;
    @Column(name = "respuesta6")
    private String respuesta6;
    @Basic(optional = false)
    @Column(name = "opcion7")
    private int opcion7;
    @Column(name = "respuesta7")
    private String respuesta7;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Estudiante cedula;

    public Preguntas() {
    }

    public Preguntas(Integer idpreguntas) {
        this.idpreguntas = idpreguntas;
    }

    public Preguntas(Integer idpreguntas, int opcion1, int opcion2, int opcion3, int opcion4, int opcion5, int opcion6, int opcion7) {
        this.idpreguntas = idpreguntas;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.opcion5 = opcion5;
        this.opcion6 = opcion6;
        this.opcion7 = opcion7;
    }

    public Integer getIdpreguntas() {
        return idpreguntas;
    }

    public void setIdpreguntas(Integer idpreguntas) {
        this.idpreguntas = idpreguntas;
    }

    public int getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(int opcion1) {
        this.opcion1 = opcion1;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public int getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(int opcion2) {
        this.opcion2 = opcion2;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public int getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(int opcion3) {
        this.opcion3 = opcion3;
    }

    public String getRespuesta31() {
        return respuesta31;
    }

    public void setRespuesta31(String respuesta31) {
        this.respuesta31 = respuesta31;
    }

    public String getRespuesta32() {
        return respuesta32;
    }

    public void setRespuesta32(String respuesta32) {
        this.respuesta32 = respuesta32;
    }

    public int getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(int opcion4) {
        this.opcion4 = opcion4;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }

    public int getOpcion5() {
        return opcion5;
    }

    public void setOpcion5(int opcion5) {
        this.opcion5 = opcion5;
    }

    public String getRespuesta5() {
        return respuesta5;
    }

    public void setRespuesta5(String respuesta5) {
        this.respuesta5 = respuesta5;
    }

    public int getOpcion6() {
        return opcion6;
    }

    public void setOpcion6(int opcion6) {
        this.opcion6 = opcion6;
    }

    public String getRespuesta6() {
        return respuesta6;
    }

    public void setRespuesta6(String respuesta6) {
        this.respuesta6 = respuesta6;
    }

    public int getOpcion7() {
        return opcion7;
    }

    public void setOpcion7(int opcion7) {
        this.opcion7 = opcion7;
    }

    public String getRespuesta7() {
        return respuesta7;
    }

    public void setRespuesta7(String respuesta7) {
        this.respuesta7 = respuesta7;
    }

    public Estudiante getCedula() {
        return cedula;
    }

    public void setCedula(Estudiante cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpreguntas != null ? idpreguntas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preguntas)) {
            return false;
        }
        Preguntas other = (Preguntas) object;
        if ((this.idpreguntas == null && other.idpreguntas != null) || (this.idpreguntas != null && !this.idpreguntas.equals(other.idpreguntas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Preguntas[ idpreguntas=" + idpreguntas + " ]";
    }
    
}
