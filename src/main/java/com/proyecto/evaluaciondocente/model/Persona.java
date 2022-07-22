/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.evaluaciondocente.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TUF Gaming
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Persona.findByCedula", query = "SELECT p FROM Persona p WHERE p.cedula = :cedula"),
    @NamedQuery(name = "Persona.findByCelular", query = "SELECT p FROM Persona p WHERE p.celular = :celular"),
    @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo"),
    @NamedQuery(name = "Persona.findByGenero", query = "SELECT p FROM Persona p WHERE p.genero = :genero"),
    @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Persona.findByFoto", query = "SELECT p FROM Persona p WHERE p.foto = :foto"),
    @NamedQuery(name = "Persona.findByIntruccion", query = "SELECT p FROM Persona p WHERE p.intruccion = :intruccion"),
    @NamedQuery(name = "Persona.findByEstadoEvaluacion", query = "SELECT p FROM Persona p WHERE p.estadoEvaluacion = :estadoEvaluacion"),
    @NamedQuery(name = "Persona.findByEstadoComision", query = "SELECT p FROM Persona p WHERE p.estadoComision = :estadoComision")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 45)
    @Column(name = "cedula")
    private String cedula;
    @Size(max = 45)
    @Column(name = "celular")
    private String celular;
    @Size(max = 45)
    @Column(name = "correo")
    private String correo;
    @Column(name = "genero")
    private Integer genero;
    @Size(max = 120)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "foto")
    private String foto;
    @Column(name = "intruccion")
    private Integer intruccion;
    @Column(name = "estado_evaluacion")
    private Integer estadoEvaluacion;
    @Column(name = "estado_comision")
    private Integer estadoComision;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Collection<PersonaMateria> personaMateriaCollection;
    @JsonIgnore
    @OneToMany(mappedBy = "idPersona")
    private Collection<Evaluacion> evaluacionCollection;
    @JsonIgnore
    @OneToMany(mappedBy = "idEstudiante")
    private Collection<Evaluacion> evaluacionCollection1;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Collection<AsignacionCoevaluacion> asignacionCoevaluacionCollection;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona1")
    private Collection<AsignacionCoevaluacion> asignacionCoevaluacionCollection1;
    @JsonIgnore
    @OneToMany(mappedBy = "idPersona")
    private Collection<Usuario> usuarioCollection;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getIntruccion() {
        return intruccion;
    }

    public void setIntruccion(Integer intruccion) {
        this.intruccion = intruccion;
    }

    public Integer getEstadoEvaluacion() {
        return estadoEvaluacion;
    }

    public void setEstadoEvaluacion(Integer estadoEvaluacion) {
        this.estadoEvaluacion = estadoEvaluacion;
    }

    public Integer getEstadoComision() {
        return estadoComision;
    }

    public void setEstadoComision(Integer estadoComision) {
        this.estadoComision = estadoComision;
    }

    @XmlTransient
    public Collection<PersonaMateria> getPersonaMateriaCollection() {
        return personaMateriaCollection;
    }

    public void setPersonaMateriaCollection(Collection<PersonaMateria> personaMateriaCollection) {
        this.personaMateriaCollection = personaMateriaCollection;
    }

    @XmlTransient
    public Collection<Evaluacion> getEvaluacionCollection() {
        return evaluacionCollection;
    }

    public void setEvaluacionCollection(Collection<Evaluacion> evaluacionCollection) {
        this.evaluacionCollection = evaluacionCollection;
    }

    @XmlTransient
    public Collection<Evaluacion> getEvaluacionCollection1() {
        return evaluacionCollection1;
    }

    public void setEvaluacionCollection1(Collection<Evaluacion> evaluacionCollection1) {
        this.evaluacionCollection1 = evaluacionCollection1;
    }

    @XmlTransient
    public Collection<AsignacionCoevaluacion> getAsignacionCoevaluacionCollection() {
        return asignacionCoevaluacionCollection;
    }

    public void setAsignacionCoevaluacionCollection(Collection<AsignacionCoevaluacion> asignacionCoevaluacionCollection) {
        this.asignacionCoevaluacionCollection = asignacionCoevaluacionCollection;
    }

    @XmlTransient
    public Collection<AsignacionCoevaluacion> getAsignacionCoevaluacionCollection1() {
        return asignacionCoevaluacionCollection1;
    }

    public void setAsignacionCoevaluacionCollection1(Collection<AsignacionCoevaluacion> asignacionCoevaluacionCollection1) {
        this.asignacionCoevaluacionCollection1 = asignacionCoevaluacionCollection1;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.evaluaciondocente.model.Persona[ idPersona=" + idPersona + " ]";
    }

}
