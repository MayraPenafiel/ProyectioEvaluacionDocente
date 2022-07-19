/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.evaluaciondocente.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author TUF Gaming
 */
@Embeddable
public class PersonaMateriaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona")
    private int idPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materia")
    private int idMateria;

    public PersonaMateriaPK() {
    }

    public PersonaMateriaPK(int idPersona, int idMateria) {
        this.idPersona = idPersona;
        this.idMateria = idMateria;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPersona;
        hash += (int) idMateria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaMateriaPK)) {
            return false;
        }
        PersonaMateriaPK other = (PersonaMateriaPK) object;
        if (this.idPersona != other.idPersona) {
            return false;
        }
        if (this.idMateria != other.idMateria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.evaluaciondocente.model.PersonaMateriaPK[ idPersona=" + idPersona + ", idMateria=" + idMateria + " ]";
    }
    
}
