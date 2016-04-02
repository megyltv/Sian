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
@Table(name = "nivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivel.findAll", query = "SELECT n FROM Nivel n"),
    @NamedQuery(name = "Nivel.findByIdnivel", query = "SELECT n FROM Nivel n WHERE n.idnivel = :idnivel"),
    @NamedQuery(name = "Nivel.findByNivel", query = "SELECT n FROM Nivel n WHERE n.nivel = :nivel")})
public class Nivel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idnivel")
    private Integer idnivel;
    @Basic(optional = false)
    @Column(name = "nivel")
    private int nivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnivel")
    private List<Materia> materiaList;
    @JoinColumn(name = "idperiodo", referencedColumnName = "idperiodo")
    @ManyToOne(optional = false)
    private PeriodoActual idperiodo;

    public Nivel() {
    }

    public Nivel(Integer idnivel) {
        this.idnivel = idnivel;
    }

    public Nivel(Integer idnivel, int nivel) {
        this.idnivel = idnivel;
        this.nivel = nivel;
    }

    public Integer getIdnivel() {
        return idnivel;
    }

    public void setIdnivel(Integer idnivel) {
        this.idnivel = idnivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @XmlTransient
    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }

    public PeriodoActual getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(PeriodoActual idperiodo) {
        this.idperiodo = idperiodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnivel != null ? idnivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivel)) {
            return false;
        }
        Nivel other = (Nivel) object;
        if ((this.idnivel == null && other.idnivel != null) || (this.idnivel != null && !this.idnivel.equals(other.idnivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Nivel[ idnivel=" + idnivel + " ]";
    }
    
}
