/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ISTA
 */
@Entity
@Table(name = "periodo_academico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodoAcademico.findAll", query = "SELECT p FROM PeriodoAcademico p"),
    @NamedQuery(name = "PeriodoAcademico.findByIdPeriodoAcademico", query = "SELECT p FROM PeriodoAcademico p WHERE p.idPeriodoAcademico = :idPeriodoAcademico"),
    @NamedQuery(name = "PeriodoAcademico.findByPeriodo", query = "SELECT p FROM PeriodoAcademico p WHERE p.periodo = :periodo"),
    @NamedQuery(name = "PeriodoAcademico.findByFechaInicio", query = "SELECT p FROM PeriodoAcademico p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "PeriodoAcademico.findByFechaFin", query = "SELECT p FROM PeriodoAcademico p WHERE p.fechaFin = :fechaFin")})
public class PeriodoAcademico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_periodo_academico")
    private Integer idPeriodoAcademico;
    @Column(name = "periodo")
    private String periodo;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(mappedBy = "idPeriodoAcademico")
    private List<Carrera> carreraList;

    public PeriodoAcademico() {
    }

    public PeriodoAcademico(Integer idPeriodoAcademico) {
        this.idPeriodoAcademico = idPeriodoAcademico;
    }

    public Integer getIdPeriodoAcademico() {
        return idPeriodoAcademico;
    }

    public void setIdPeriodoAcademico(Integer idPeriodoAcademico) {
        this.idPeriodoAcademico = idPeriodoAcademico;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public List<Carrera> getCarreraList() {
        return carreraList;
    }

    public void setCarreraList(List<Carrera> carreraList) {
        this.carreraList = carreraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodoAcademico != null ? idPeriodoAcademico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodoAcademico)) {
            return false;
        }
        PeriodoAcademico other = (PeriodoAcademico) object;
        if ((this.idPeriodoAcademico == null && other.idPeriodoAcademico != null) || (this.idPeriodoAcademico != null && !this.idPeriodoAcademico.equals(other.idPeriodoAcademico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.evaluacion_docente.model.PeriodoAcademico[ idPeriodoAcademico=" + idPeriodoAcademico + " ]";
    }
    
}
