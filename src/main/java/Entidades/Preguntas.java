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
    @NamedQuery(name = "Preguntas.findByNumpregunta", query = "SELECT p FROM Preguntas p WHERE p.numpregunta = :numpregunta"),
    @NamedQuery(name = "Preguntas.findByOpcion", query = "SELECT p FROM Preguntas p WHERE p.opcion = :opcion"),
    @NamedQuery(name = "Preguntas.findByRespuesta", query = "SELECT p FROM Preguntas p WHERE p.respuesta = :respuesta")})
public class Preguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpreguntas")
    private Integer idpreguntas;
    @Basic(optional = false)
    @Column(name = "numpregunta")
    private int numpregunta;
    @Basic(optional = false)
    @Column(name = "opcion")
    private int opcion;
    @Column(name = "respuesta")
    private String respuesta;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Estudiante cedula;

    public Preguntas() {
    }

    public Preguntas(Integer idpreguntas) {
        this.idpreguntas = idpreguntas;
    }

    public Preguntas(Integer idpreguntas, int numpregunta, int opcion) {
        this.idpreguntas = idpreguntas;
        this.numpregunta = numpregunta;
        this.opcion = opcion;
    }

    public Integer getIdpreguntas() {
        return idpreguntas;
    }

    public void setIdpreguntas(Integer idpreguntas) {
        this.idpreguntas = idpreguntas;
    }

    public int getNumpregunta() {
        return numpregunta;
    }

    public void setNumpregunta(int numpregunta) {
        this.numpregunta = numpregunta;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
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