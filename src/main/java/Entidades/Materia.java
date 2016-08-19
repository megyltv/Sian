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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Megan
 */
@Entity
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByIdmateria", query = "SELECT m FROM Materia m WHERE m.idmateria = :idmateria"),
    @NamedQuery(name = "Materia.findByMateria", query = "SELECT m FROM Materia m WHERE m.materia = :materia"),
    @NamedQuery(name = "Materia.findByNivel", query = "SELECT m FROM Materia m WHERE m.nivel = :nivel")})
public class Materia implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmateria")
    private List<HorarioMateria> horarioMateriaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmateria")
    private Integer idmateria;
    @Basic(optional = false)
    @Column(name = "materia")
    private String materia;
    @Column(name = "nivel")
    private Integer nivel;
    @ManyToMany(mappedBy = "materiaList")
    private List<Horario> horarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmateria")
    private List<Inscripcion> inscripcionList;

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

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @XmlTransient
    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    @XmlTransient
    public List<Inscripcion> getInscripcionList() {
        return inscripcionList;
    }

    public void setInscripcionList(List<Inscripcion> inscripcionList) {
        this.inscripcionList = inscripcionList;
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

    @XmlTransient
    public List<HorarioMateria> getHorarioMateriaList() {
        return horarioMateriaList;
    }

    public void setHorarioMateriaList(List<HorarioMateria> horarioMateriaList) {
        this.horarioMateriaList = horarioMateriaList;
    }
    
}
