/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Nathy Cumbicos
 */
@Embeddable
public class MateriaHorarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idmateria")
    private int idmateria;
    @Basic(optional = false)
    @Column(name = "idhorario")
    private int idhorario;

    public MateriaHorarioPK() {
    }

    public MateriaHorarioPK(int idmateria, int idhorario) {
        this.idmateria = idmateria;
        this.idhorario = idhorario;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmateria;
        hash += (int) idhorario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaHorarioPK)) {
            return false;
        }
        MateriaHorarioPK other = (MateriaHorarioPK) object;
        if (this.idmateria != other.idmateria) {
            return false;
        }
        if (this.idhorario != other.idhorario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.MateriaHorarioPK[ idmateria=" + idmateria + ", idhorario=" + idhorario + " ]";
    }
    
}
