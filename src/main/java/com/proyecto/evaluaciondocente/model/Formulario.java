/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.evaluaciondocente.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TUF Gaming
 */
@Entity
@Table(name = "formulario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formulario.findAll", query = "SELECT f FROM Formulario f"),
    @NamedQuery(name = "Formulario.findByIdFormulario", query = "SELECT f FROM Formulario f WHERE f.idFormulario = :idFormulario"),
    @NamedQuery(name = "Formulario.findByPreguntas", query = "SELECT f FROM Formulario f WHERE f.preguntas = :preguntas"),
    @NamedQuery(name = "Formulario.findByObservacion", query = "SELECT f FROM Formulario f WHERE f.observacion = :observacion")})
public class Formulario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_formulario")
    private Integer idFormulario;
    @Size(max = 150)
    @Column(name = "preguntas")
    private String preguntas;
    @Size(max = 45)
    @Column(name = "observacion")
    private String observacion;
    @JsonIgnore
    @OneToMany(mappedBy = "idFormulario")
    private Collection<Evaluacion> evaluacionCollection;
    @JsonIgnore
    @OneToMany(mappedBy = "idFormulario")
    private Collection<FormularioTipoformulario> formularioTipoformularioCollection;

    public Formulario() {
    }

    public Formulario(Integer idFormulario) {
        this.idFormulario = idFormulario;
    }

    public Integer getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Integer idFormulario) {
        this.idFormulario = idFormulario;
    }

    public String getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public Collection<Evaluacion> getEvaluacionCollection() {
        return evaluacionCollection;
    }

    public void setEvaluacionCollection(Collection<Evaluacion> evaluacionCollection) {
        this.evaluacionCollection = evaluacionCollection;
    }

    @XmlTransient
    public Collection<FormularioTipoformulario> getFormularioTipoformularioCollection() {
        return formularioTipoformularioCollection;
    }

    public void setFormularioTipoformularioCollection(Collection<FormularioTipoformulario> formularioTipoformularioCollection) {
        this.formularioTipoformularioCollection = formularioTipoformularioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormulario != null ? idFormulario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulario)) {
            return false;
        }
        Formulario other = (Formulario) object;
        if ((this.idFormulario == null && other.idFormulario != null) || (this.idFormulario != null && !this.idFormulario.equals(other.idFormulario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.evaluaciondocente.model.Formulario[ idFormulario=" + idFormulario + " ]";
    }

}
