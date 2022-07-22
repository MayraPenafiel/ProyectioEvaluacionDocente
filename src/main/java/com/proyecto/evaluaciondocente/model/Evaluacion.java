/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.evaluaciondocente.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TUF Gaming
 */
@Entity
@Table(name = "evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByIdEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.idEvaluacion = :idEvaluacion"),
    @NamedQuery(name = "Evaluacion.findByCalificacion", query = "SELECT e FROM Evaluacion e WHERE e.calificacion = :calificacion"),
    @NamedQuery(name = "Evaluacion.findByFecha", query = "SELECT e FROM Evaluacion e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Evaluacion.findByObservacion", query = "SELECT e FROM Evaluacion e WHERE e.observacion = :observacion")})
public class Evaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evaluacion")
    private Integer idEvaluacion;
    @Column(name = "calificacion")
    private Integer calificacion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 255)
    @Column(name = "observacion")
    private String observacion;
    @JsonIgnore
    @JoinColumn(name = "id_carrera", referencedColumnName = "id_carrera")
    @ManyToOne
    private Carrera idCarrera;
    @JsonIgnore
    @JoinColumn(name = "id_ciclo", referencedColumnName = "id_ciclo")
    @ManyToOne
    private Ciclo idCiclo;
    @JsonIgnore
    @JoinColumn(name = "id_formulario", referencedColumnName = "id_formulario")
    @ManyToOne
    private Formulario idFormulario;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne
    private Materia idMateria;
    @JsonIgnore
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona idPersona;
    @JsonIgnore
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona idEstudiante;
    @JsonIgnore
    @JoinColumn(name = "id_tipo_formulario", referencedColumnName = "idtipo_formulario")
    @ManyToOne
    private TipoFormulario idTipoFormulario;

    public Evaluacion() {
    }

    public Evaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Integer getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Ciclo getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Ciclo idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Formulario getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Formulario idFormulario) {
        this.idFormulario = idFormulario;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Persona getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Persona idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public TipoFormulario getIdTipoFormulario() {
        return idTipoFormulario;
    }

    public void setIdTipoFormulario(TipoFormulario idTipoFormulario) {
        this.idTipoFormulario = idTipoFormulario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluacion != null ? idEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.idEvaluacion == null && other.idEvaluacion != null) || (this.idEvaluacion != null && !this.idEvaluacion.equals(other.idEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.evaluaciondocente.model.Evaluacion[ idEvaluacion=" + idEvaluacion + " ]";
    }

}
