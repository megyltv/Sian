/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "inscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i"),
    @NamedQuery(name = "Inscripcion.findByIdinscripcion", query = "SELECT i FROM Inscripcion i WHERE i.idinscripcion = :idinscripcion"),
    @NamedQuery(name = "Inscripcion.findByCalificacion", query = "SELECT i FROM Inscripcion i WHERE i.calificacion = :calificacion"),
    @NamedQuery(name = "Inscripcion.findByObservacion", query = "SELECT i FROM Inscripcion i WHERE i.observacion = :observacion"),
    @NamedQuery(name = "Inscripcion.findByPeriodoHorario", query = "SELECT i FROM Inscripcion i WHERE i.idperiodo = :idperiodo and i.idmateriahorario = :idmateriahorario")})
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinscripcion")
    private String idinscripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "calificacion")
    private BigDecimal calificacion;
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante")
    @ManyToOne(optional = false)
    private Estudiante idestudiante;
    @JoinColumn(name = "idmateriahorario", referencedColumnName = "idmateriahorario")
    @ManyToOne
    private HorarioMateria idmateriahorario;
    @JoinColumn(name = "idperiodo", referencedColumnName = "idperiodo")
    @ManyToOne(optional = false)
    private Periodo idperiodo;

    public Inscripcion() {
    }

    public Inscripcion(String idinscripcion) {
        this.idinscripcion = idinscripcion;
    }

    public String getIdinscripcion() {
        return idinscripcion;
    }

    public void setIdinscripcion(String idinscripcion) {
        this.idinscripcion = idinscripcion;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Estudiante getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Estudiante idestudiante) {
        this.idestudiante = idestudiante;
    }

    public HorarioMateria getIdmateriahorario() {
        return idmateriahorario;
    }

    public void setIdmateriahorario(HorarioMateria idmateriahorario) {
        this.idmateriahorario = idmateriahorario;
    }

    public Periodo getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(Periodo idperiodo) {
        this.idperiodo = idperiodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinscripcion != null ? idinscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.idinscripcion == null && other.idinscripcion != null) || (this.idinscripcion != null && !this.idinscripcion.equals(other.idinscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Inscripcion[ idinscripcion=" + idinscripcion + " ]";
    }
    
}
