/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.evaluaciondocente.model;

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
@Table(name = "tipo_formulario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFormulario.findAll", query = "SELECT t FROM TipoFormulario t"),
    @NamedQuery(name = "TipoFormulario.findByIdtipoFormulario", query = "SELECT t FROM TipoFormulario t WHERE t.idtipoFormulario = :idtipoFormulario"),
    @NamedQuery(name = "TipoFormulario.findByObservacion", query = "SELECT t FROM TipoFormulario t WHERE t.observacion = :observacion"),
    @NamedQuery(name = "TipoFormulario.findByPorcentaje", query = "SELECT t FROM TipoFormulario t WHERE t.porcentaje = :porcentaje"),
    @NamedQuery(name = "TipoFormulario.findByTipoFormulario", query = "SELECT t FROM TipoFormulario t WHERE t.tipoFormulario = :tipoFormulario")})
public class TipoFormulario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_formulario")
    private Integer idtipoFormulario;
    @Size(max = 255)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "porcentaje")
    private Integer porcentaje;
    @Size(max = 255)
    @Column(name = "tipo_formulario")
    private String tipoFormulario;
    @OneToMany(mappedBy = "idTipoFormulario")
    private Collection<Evaluacion> evaluacionCollection;
    @OneToMany(mappedBy = "idtipoFormulario")
    private Collection<FormularioTipoformulario> formularioTipoformularioCollection;

    public TipoFormulario() {
    }

    public TipoFormulario(Integer idtipoFormulario) {
        this.idtipoFormulario = idtipoFormulario;
    }

    public Integer getIdtipoFormulario() {
        return idtipoFormulario;
    }

    public void setIdtipoFormulario(Integer idtipoFormulario) {
        this.idtipoFormulario = idtipoFormulario;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTipoFormulario() {
        return tipoFormulario;
    }

    public void setTipoFormulario(String tipoFormulario) {
        this.tipoFormulario = tipoFormulario;
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
        hash += (idtipoFormulario != null ? idtipoFormulario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFormulario)) {
            return false;
        }
        TipoFormulario other = (TipoFormulario) object;
        if ((this.idtipoFormulario == null && other.idtipoFormulario != null) || (this.idtipoFormulario != null && !this.idtipoFormulario.equals(other.idtipoFormulario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.evaluaciondocente.model.TipoFormulario[ idtipoFormulario=" + idtipoFormulario + " ]";
    }
    
}
