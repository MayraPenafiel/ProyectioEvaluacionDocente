/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ISTA
 */
@Entity
@Table(name = "asignacion_coevaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionCoevaluacion.findAll", query = "SELECT a FROM AsignacionCoevaluacion a"),
    @NamedQuery(name = "AsignacionCoevaluacion.findByIdAsignacion", query = "SELECT a FROM AsignacionCoevaluacion a WHERE a.asignacionCoevaluacionPK.idAsignacion = :idAsignacion"),
    @NamedQuery(name = "AsignacionCoevaluacion.findByIdDocenteEvaluador", query = "SELECT a FROM AsignacionCoevaluacion a WHERE a.asignacionCoevaluacionPK.idDocenteEvaluador = :idDocenteEvaluador"),
    @NamedQuery(name = "AsignacionCoevaluacion.findByIdDocenteEvaluado", query = "SELECT a FROM AsignacionCoevaluacion a WHERE a.asignacionCoevaluacionPK.idDocenteEvaluado = :idDocenteEvaluado"),
    @NamedQuery(name = "AsignacionCoevaluacion.findByObservacion", query = "SELECT a FROM AsignacionCoevaluacion a WHERE a.observacion = :observacion"),
    @NamedQuery(name = "AsignacionCoevaluacion.findByFechaRegistro", query = "SELECT a FROM AsignacionCoevaluacion a WHERE a.fechaRegistro = :fechaRegistro")})
public class AsignacionCoevaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsignacionCoevaluacionPK asignacionCoevaluacionPK;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @JoinColumn(name = "id_docente_evaluador", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "id_docente_evaluado", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona1;

    public AsignacionCoevaluacion() {
    }

    public AsignacionCoevaluacion(AsignacionCoevaluacionPK asignacionCoevaluacionPK) {
        this.asignacionCoevaluacionPK = asignacionCoevaluacionPK;
    }

    public AsignacionCoevaluacion(int idAsignacion, int idDocenteEvaluador, int idDocenteEvaluado) {
        this.asignacionCoevaluacionPK = new AsignacionCoevaluacionPK(idAsignacion, idDocenteEvaluador, idDocenteEvaluado);
    }

    public AsignacionCoevaluacionPK getAsignacionCoevaluacionPK() {
        return asignacionCoevaluacionPK;
    }

    public void setAsignacionCoevaluacionPK(AsignacionCoevaluacionPK asignacionCoevaluacionPK) {
        this.asignacionCoevaluacionPK = asignacionCoevaluacionPK;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignacionCoevaluacionPK != null ? asignacionCoevaluacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionCoevaluacion)) {
            return false;
        }
        AsignacionCoevaluacion other = (AsignacionCoevaluacion) object;
        if ((this.asignacionCoevaluacionPK == null && other.asignacionCoevaluacionPK != null) || (this.asignacionCoevaluacionPK != null && !this.asignacionCoevaluacionPK.equals(other.asignacionCoevaluacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.evaluacion_docente.model.AsignacionCoevaluacion[ asignacionCoevaluacionPK=" + asignacionCoevaluacionPK + " ]";
    }
    
}
