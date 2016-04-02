/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nathy Cumbicos
 */
@Entity
@Table(name = "inscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i"),
    @NamedQuery(name = "Inscripcion.findByIdinscripcion", query = "SELECT i FROM Inscripcion i WHERE i.idinscripcion = :idinscripcion"),
    @NamedQuery(name = "Inscripcion.findByObservacion", query = "SELECT i FROM Inscripcion i WHERE i.observacion = :observacion")})
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idinscripcion")
    private Integer idinscripcion;
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Estudiante cedula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinscripcion")
    private List<Materia> materiaList;

    public Inscripcion() {
    }

    public Inscripcion(Integer idinscripcion) {
        this.idinscripcion = idinscripcion;
    }

    public Integer getIdinscripcion() {
        return idinscripcion;
    }

    public void setIdinscripcion(Integer idinscripcion) {
        this.idinscripcion = idinscripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Estudiante getCedula() {
        return cedula;
    }

    public void setCedula(Estudiante cedula) {
        this.cedula = cedula;
    }

    @XmlTransient
    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
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
