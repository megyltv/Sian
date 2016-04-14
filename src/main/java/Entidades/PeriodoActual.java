/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Megan
 */
@Entity
@Table(name = "periodo_actual", catalog = "siand", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodoActual.findAll", query = "SELECT p FROM PeriodoActual p"),
    @NamedQuery(name = "PeriodoActual.findByIdperiodo", query = "SELECT p FROM PeriodoActual p WHERE p.idperiodo = :idperiodo"),
    @NamedQuery(name = "PeriodoActual.findByPeriodo", query = "SELECT p FROM PeriodoActual p WHERE p.periodo = :periodo"),
    @NamedQuery(name = "PeriodoActual.findByFechainicio", query = "SELECT p FROM PeriodoActual p WHERE p.fechainicio = :fechainicio"),
    @NamedQuery(name = "PeriodoActual.findByFechafin", query = "SELECT p FROM PeriodoActual p WHERE p.fechafin = :fechafin")})
public class PeriodoActual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperiodo")
    private Integer idperiodo;
    @Basic(optional = false)
    @Column(name = "periodo")
    private String periodo;
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperiodo")
    private List<Inscripcion> inscripcionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperiodo")
    private List<Nivel> nivelList;

    public PeriodoActual() {
    }

    public PeriodoActual(Integer idperiodo) {
        this.idperiodo = idperiodo;
    }

    public PeriodoActual(Integer idperiodo, String periodo) {
        this.idperiodo = idperiodo;
        this.periodo = periodo;
    }

    public Integer getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(Integer idperiodo) {
        this.idperiodo = idperiodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    @XmlTransient
    public List<Inscripcion> getInscripcionList() {
        return inscripcionList;
    }

    public void setInscripcionList(List<Inscripcion> inscripcionList) {
        this.inscripcionList = inscripcionList;
    }

    @XmlTransient
    public List<Nivel> getNivelList() {
        return nivelList;
    }

    public void setNivelList(List<Nivel> nivelList) {
        this.nivelList = nivelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperiodo != null ? idperiodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodoActual)) {
            return false;
        }
        PeriodoActual other = (PeriodoActual) object;
        if ((this.idperiodo == null && other.idperiodo != null) || (this.idperiodo != null && !this.idperiodo.equals(other.idperiodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PeriodoActual[ idperiodo=" + idperiodo + " ]";
    }
    
}
