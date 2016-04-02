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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Nathy Cumbicos
 */
@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByCedula", query = "SELECT e FROM Estudiante e WHERE e.cedula = :cedula"),
    @NamedQuery(name = "Estudiante.findByNombres", query = "SELECT e FROM Estudiante e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Estudiante.findByApellidos", query = "SELECT e FROM Estudiante e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Estudiante.findByFechanac", query = "SELECT e FROM Estudiante e WHERE e.fechanac = :fechanac"),
    @NamedQuery(name = "Estudiante.findByTelefono", query = "SELECT e FROM Estudiante e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Estudiante.findByCelular", query = "SELECT e FROM Estudiante e WHERE e.celular = :celular"),
    @NamedQuery(name = "Estudiante.findByCorreo", query = "SELECT e FROM Estudiante e WHERE e.correo = :correo"),
    @NamedQuery(name = "Estudiante.findByNivelinst", query = "SELECT e FROM Estudiante e WHERE e.nivelinst = :nivelinst"),
    @NamedQuery(name = "Estudiante.findByProfesion", query = "SELECT e FROM Estudiante e WHERE e.profesion = :profesion"),
    @NamedQuery(name = "Estudiante.findBySector", query = "SELECT e FROM Estudiante e WHERE e.sector = :sector"),
    @NamedQuery(name = "Estudiante.findByEstadocivil", query = "SELECT e FROM Estudiante e WHERE e.estadocivil = :estadocivil"),
    @NamedQuery(name = "Estudiante.findByNombcony", query = "SELECT e FROM Estudiante e WHERE e.nombcony = :nombcony"),
    @NamedQuery(name = "Estudiante.findByCreycony", query = "SELECT e FROM Estudiante e WHERE e.creycony = :creycony"),
    @NamedQuery(name = "Estudiante.findByHijos", query = "SELECT e FROM Estudiante e WHERE e.hijos = :hijos"),
    @NamedQuery(name = "Estudiante.findByNombemerg", query = "SELECT e FROM Estudiante e WHERE e.nombemerg = :nombemerg"),
    @NamedQuery(name = "Estudiante.findByTelfemerg", query = "SELECT e FROM Estudiante e WHERE e.telfemerg = :telfemerg")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cedula")
    private Integer cedula;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "fechanac")
    @Temporal(TemporalType.DATE)
    private Date fechanac;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "celular")
    private Integer celular;
    @Column(name = "correo")
    private String correo;
    @Column(name = "nivelinst")
    private String nivelinst;
    @Column(name = "profesion")
    private String profesion;
    @Column(name = "sector")
    private String sector;
    @Column(name = "estadocivil")
    private String estadocivil;
    @Column(name = "nombcony")
    private String nombcony;
    @Column(name = "creycony")
    private Integer creycony;
    @Column(name = "hijos")
    private Integer hijos;
    @Column(name = "nombemerg")
    private String nombemerg;
    @Column(name = "telfemerg")
    private Integer telfemerg;
    @JoinColumn(name = "idpreguntas", referencedColumnName = "idpreguntas")
    @ManyToOne(optional = false)
    private Preguntas idpreguntas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedula")
    private List<Calificacion> calificacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedula")
    private List<Inscripcion> inscripcionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedula")
    private List<PeriodoActual> periodoActualList;

    public Estudiante() {
    }

    public Estudiante(Integer cedula) {
        this.cedula = cedula;
    }

    public Estudiante(Integer cedula, String nombres, String apellidos) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNivelinst() {
        return nivelinst;
    }

    public void setNivelinst(String nivelinst) {
        this.nivelinst = nivelinst;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getNombcony() {
        return nombcony;
    }

    public void setNombcony(String nombcony) {
        this.nombcony = nombcony;
    }

    public Integer getCreycony() {
        return creycony;
    }

    public void setCreycony(Integer creycony) {
        this.creycony = creycony;
    }

    public Integer getHijos() {
        return hijos;
    }

    public void setHijos(Integer hijos) {
        this.hijos = hijos;
    }

    public String getNombemerg() {
        return nombemerg;
    }

    public void setNombemerg(String nombemerg) {
        this.nombemerg = nombemerg;
    }

    public Integer getTelfemerg() {
        return telfemerg;
    }

    public void setTelfemerg(Integer telfemerg) {
        this.telfemerg = telfemerg;
    }

    public Preguntas getIdpreguntas() {
        return idpreguntas;
    }

    public void setIdpreguntas(Preguntas idpreguntas) {
        this.idpreguntas = idpreguntas;
    }

    @XmlTransient
    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    @XmlTransient
    public List<Inscripcion> getInscripcionList() {
        return inscripcionList;
    }

    public void setInscripcionList(List<Inscripcion> inscripcionList) {
        this.inscripcionList = inscripcionList;
    }

    @XmlTransient
    public List<PeriodoActual> getPeriodoActualList() {
        return periodoActualList;
    }

    public void setPeriodoActualList(List<PeriodoActual> periodoActualList) {
        this.periodoActualList = periodoActualList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estudiante[ cedula=" + cedula + " ]";
    }
    
}
