/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.model;

import java.io.Serializable;
import javax.persistence.Column;
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
 * @author ISTA
 */
@Entity
@Table(name = "persona_materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonaMateria.findAll", query = "SELECT p FROM PersonaMateria p"),
    @NamedQuery(name = "PersonaMateria.findByIdPersona", query = "SELECT p FROM PersonaMateria p WHERE p.personaMateriaPK.idPersona = :idPersona"),
    @NamedQuery(name = "PersonaMateria.findByIdMateria", query = "SELECT p FROM PersonaMateria p WHERE p.personaMateriaPK.idMateria = :idMateria"),
    @NamedQuery(name = "PersonaMateria.findByEstado", query = "SELECT p FROM PersonaMateria p WHERE p.estado = :estado")})
public class PersonaMateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonaMateriaPK personaMateriaPK;
    @Column(name = "estado")
    private Integer estado;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materia materia;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    public PersonaMateria() {
    }

    public PersonaMateria(PersonaMateriaPK personaMateriaPK) {
        this.personaMateriaPK = personaMateriaPK;
    }

    public PersonaMateria(int idPersona, int idMateria) {
        this.personaMateriaPK = new PersonaMateriaPK(idPersona, idMateria);
    }

    public PersonaMateriaPK getPersonaMateriaPK() {
        return personaMateriaPK;
    }

    public void setPersonaMateriaPK(PersonaMateriaPK personaMateriaPK) {
        this.personaMateriaPK = personaMateriaPK;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaMateriaPK != null ? personaMateriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaMateria)) {
            return false;
        }
        PersonaMateria other = (PersonaMateria) object;
        if ((this.personaMateriaPK == null && other.personaMateriaPK != null) || (this.personaMateriaPK != null && !this.personaMateriaPK.equals(other.personaMateriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.evaluacion_docente.model.PersonaMateria[ personaMateriaPK=" + personaMateriaPK + " ]";
    }
    
}
