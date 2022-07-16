/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.model;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ISTA
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
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "porcentaje")
    private Integer porcentaje;
    @Column(name = "tipo_formulario")
    private String tipoFormulario;
    @OneToMany(mappedBy = "idTipoFormulario")
    private List<Evaluacion> evaluacionList;
    @OneToMany(mappedBy = "idtipoFormulario")
    private List<FormularioTipoformulario> formularioTipoformularioList;

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
    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    @XmlTransient
    public List<FormularioTipoformulario> getFormularioTipoformularioList() {
        return formularioTipoformularioList;
    }

    public void setFormularioTipoformularioList(List<FormularioTipoformulario> formularioTipoformularioList) {
        this.formularioTipoformularioList = formularioTipoformularioList;
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
        return "com.example.evaluacion_docente.model.TipoFormulario[ idtipoFormulario=" + idtipoFormulario + " ]";
    }
    
}
