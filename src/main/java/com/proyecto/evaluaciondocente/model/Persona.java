/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ISTA
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
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "celular")
    private String celular;
    @Column(name = "correo")
    private String correo;
    @Column(name = "genero")
    private Integer genero;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "foto")
    private String foto;
    @Column(name = "intruccion")
    private Integer intruccion;
    @Column(name = "estado_evaluacion")
    private Integer estadoEvaluacion;
    @Column(name = "estado_comision")
    private Integer estadoComision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<PersonaMateria> personaMateriaList;
    @OneToMany(mappedBy = "idPersona")
    private List<Evaluacion> evaluacionList;
    @OneToMany(mappedBy = "idEstudiante")
    private List<Evaluacion> evaluacionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<AsignacionCoevaluacion> asignacionCoevaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona1")
    private List<AsignacionCoevaluacion> asignacionCoevaluacionList1;
    @OneToMany(mappedBy = "idPersona")
    private List<Usuario> usuarioList;

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
    public List<PersonaMateria> getPersonaMateriaList() {
        return personaMateriaList;
    }

    public void setPersonaMateriaList(List<PersonaMateria> personaMateriaList) {
        this.personaMateriaList = personaMateriaList;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList1() {
        return evaluacionList1;
    }

    public void setEvaluacionList1(List<Evaluacion> evaluacionList1) {
        this.evaluacionList1 = evaluacionList1;
    }

    @XmlTransient
    public List<AsignacionCoevaluacion> getAsignacionCoevaluacionList() {
        return asignacionCoevaluacionList;
    }

    public void setAsignacionCoevaluacionList(List<AsignacionCoevaluacion> asignacionCoevaluacionList) {
        this.asignacionCoevaluacionList = asignacionCoevaluacionList;
    }

    @XmlTransient
    public List<AsignacionCoevaluacion> getAsignacionCoevaluacionList1() {
        return asignacionCoevaluacionList1;
    }

    public void setAsignacionCoevaluacionList1(List<AsignacionCoevaluacion> asignacionCoevaluacionList1) {
        this.asignacionCoevaluacionList1 = asignacionCoevaluacionList1;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        return "com.example.evaluacion_docente.model.Persona[ idPersona=" + idPersona + " ]";
    }
    
}
