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
 * @author Megan
 */
@Entity
@Table(name = "horariomateria", catalog = "siand", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horariomateria.findAll", query = "SELECT h FROM Horariomateria h"),
    @NamedQuery(name = "Horariomateria.findByIdmateria", query = "SELECT h FROM Horariomateria h WHERE h.horariomateriaPK.idmateria = :idmateria"),
    @NamedQuery(name = "Horariomateria.findByIdhorario", query = "SELECT h FROM Horariomateria h WHERE h.horariomateriaPK.idhorario = :idhorario")})
public class Horariomateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HorariomateriaPK horariomateriaPK;
    @JoinColumn(name = "idcalificacion", referencedColumnName = "idcalificacion")
    @ManyToOne
    private Calificacion idcalificacion;
    @JoinColumn(name = "idhorario", referencedColumnName = "idhorario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Horario horario;
    @JoinColumn(name = "idmateria", referencedColumnName = "idmateria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materia materia;

    public Horariomateria() {
    }

    public Horariomateria(HorariomateriaPK horariomateriaPK) {
        this.horariomateriaPK = horariomateriaPK;
    }

    public Horariomateria(int idmateria, int idhorario) {
        this.horariomateriaPK = new HorariomateriaPK(idmateria, idhorario);
    }

    public HorariomateriaPK getHorariomateriaPK() {
        return horariomateriaPK;
    }

    public void setHorariomateriaPK(HorariomateriaPK horariomateriaPK) {
        this.horariomateriaPK = horariomateriaPK;
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
        hash += (horariomateriaPK != null ? horariomateriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horariomateria)) {
            return false;
        }
        Horariomateria other = (Horariomateria) object;
        if ((this.horariomateriaPK == null && other.horariomateriaPK != null) || (this.horariomateriaPK != null && !this.horariomateriaPK.equals(other.horariomateriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Horariomateria[ horariomateriaPK=" + horariomateriaPK + " ]";
    }
    
}
