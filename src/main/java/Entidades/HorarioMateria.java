/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Megan
 */
@Entity
@Table(name = "horario_materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioMateria.findAll", query = "SELECT h FROM HorarioMateria h"),
    @NamedQuery(name = "HorarioMateria.findByIdmateriahorario", query = "SELECT h FROM HorarioMateria h WHERE h.idmateriahorario = :idmateriahorario"),
    @NamedQuery(name = "HorarioMateria.findByEstado", query = "SELECT h FROM HorarioMateria h WHERE h.estado = :estado")})
public class HorarioMateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmateriahorario")
    private Integer idmateriahorario;
    @Column(name = "estado")
    private Integer estado;
    @JoinColumn(name = "idhorario", referencedColumnName = "idhorario")
    @ManyToOne(optional = false)
    private Horario idhorario;
    @JoinColumn(name = "idmateria", referencedColumnName = "idmateria")
    @ManyToOne(optional = false)
    private Materia idmateria;
    @OneToMany(mappedBy = "idmateriahorario")
    private List<Inscripcion> inscripcionList;

    public HorarioMateria() {
    }

    public HorarioMateria(Integer idmateriahorario) {
        this.idmateriahorario = idmateriahorario;
    }

    public Integer getIdmateriahorario() {
        return idmateriahorario;
    }

    public void setIdmateriahorario(Integer idmateriahorario) {
        this.idmateriahorario = idmateriahorario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Horario getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Horario idhorario) {
        this.idhorario = idhorario;
    }

    public Materia getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Materia idmateria) {
        this.idmateria = idmateria;
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
        hash += (idmateriahorario != null ? idmateriahorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioMateria)) {
            return false;
        }
        HorarioMateria other = (HorarioMateria) object;
        if ((this.idmateriahorario == null && other.idmateriahorario != null) || (this.idmateriahorario != null && !this.idmateriahorario.equals(other.idmateriahorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.HorarioMateria[ idmateriahorario=" + idmateriahorario + " ]";
    }
    
}
