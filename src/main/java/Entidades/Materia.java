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
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByIdmateria", query = "SELECT m FROM Materia m WHERE m.idmateria = :idmateria"),
    @NamedQuery(name = "Materia.findByMateria", query = "SELECT m FROM Materia m WHERE m.materia = :materia")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idmateria")
    private Integer idmateria;
    @Basic(optional = false)
    @Column(name = "materia")
    private String materia;
    @JoinColumn(name = "idinscripcion", referencedColumnName = "idinscripcion")
    @ManyToOne(optional = false)
    private Inscripcion idinscripcion;
    @JoinColumn(name = "idnivel", referencedColumnName = "idnivel")
    @ManyToOne(optional = false)
    private Nivel idnivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private List<MateriaHorario> materiaHorarioList;

    public Materia() {
    }

    public Materia(Integer idmateria) {
        this.idmateria = idmateria;
    }

    public Materia(Integer idmateria, String materia) {
        this.idmateria = idmateria;
        this.materia = materia;
    }

    public Integer getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Integer idmateria) {
        this.idmateria = idmateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Inscripcion getIdinscripcion() {
        return idinscripcion;
    }

    public void setIdinscripcion(Inscripcion idinscripcion) {
        this.idinscripcion = idinscripcion;
    }

    public Nivel getIdnivel() {
        return idnivel;
    }

    public void setIdnivel(Nivel idnivel) {
        this.idnivel = idnivel;
    }

    @XmlTransient
    public List<MateriaHorario> getMateriaHorarioList() {
        return materiaHorarioList;
    }

    public void setMateriaHorarioList(List<MateriaHorario> materiaHorarioList) {
        this.materiaHorarioList = materiaHorarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmateria != null ? idmateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idmateria == null && other.idmateria != null) || (this.idmateria != null && !this.idmateria.equals(other.idmateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Materia[ idmateria=" + idmateria + " ]";
    }
    
}
