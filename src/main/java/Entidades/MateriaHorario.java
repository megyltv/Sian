/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nathy Cumbicos
 */
@Entity
@Table(name = "materia_horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaHorario.findAll", query = "SELECT m FROM MateriaHorario m"),
    @NamedQuery(name = "MateriaHorario.findByIdmateria", query = "SELECT m FROM MateriaHorario m WHERE m.materiaHorarioPK.idmateria = :idmateria"),
    @NamedQuery(name = "MateriaHorario.findByIdhorario", query = "SELECT m FROM MateriaHorario m WHERE m.materiaHorarioPK.idhorario = :idhorario")})
public class MateriaHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MateriaHorarioPK materiaHorarioPK;
    @JoinColumn(name = "idcalificacion", referencedColumnName = "idcalificacion")
    @ManyToOne
    private Calificacion idcalificacion;
    @JoinColumn(name = "idhorario", referencedColumnName = "idhorario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Horario horario;
    @JoinColumn(name = "idmateria", referencedColumnName = "idmateria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materia materia;

    public MateriaHorario() {
    }

    public MateriaHorario(MateriaHorarioPK materiaHorarioPK) {
        this.materiaHorarioPK = materiaHorarioPK;
    }

    public MateriaHorario(int idmateria, int idhorario) {
        this.materiaHorarioPK = new MateriaHorarioPK(idmateria, idhorario);
    }

    public MateriaHorarioPK getMateriaHorarioPK() {
        return materiaHorarioPK;
    }

    public void setMateriaHorarioPK(MateriaHorarioPK materiaHorarioPK) {
        this.materiaHorarioPK = materiaHorarioPK;
    }

    public Calificacion getIdcalificacion() {
        return idcalificacion;
    }

    public void setIdcalificacion(Calificacion idcalificacion) {
        this.idcalificacion = idcalificacion;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaHorarioPK != null ? materiaHorarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaHorario)) {
            return false;
        }
        MateriaHorario other = (MateriaHorario) object;
        if ((this.materiaHorarioPK == null && other.materiaHorarioPK != null) || (this.materiaHorarioPK != null && !this.materiaHorarioPK.equals(other.materiaHorarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.MateriaHorario[ materiaHorarioPK=" + materiaHorarioPK + " ]";
    }
    
}
