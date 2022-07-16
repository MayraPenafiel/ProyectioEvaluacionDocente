/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ISTA
 */
@Entity
@Table(name = "formulario_tipoformulario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormularioTipoformulario.findAll", query = "SELECT f FROM FormularioTipoformulario f"),
    @NamedQuery(name = "FormularioTipoformulario.findByIdFormulariotipoformulario", query = "SELECT f FROM FormularioTipoformulario f WHERE f.idFormulariotipoformulario = :idFormulariotipoformulario")})
public class FormularioTipoformulario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_formulariotipoformulario")
    private Integer idFormulariotipoformulario;
    @JoinColumn(name = "id_formulario", referencedColumnName = "id_formulario")
    @ManyToOne
    private Formulario idFormulario;
    @JoinColumn(name = "idtipo_formulario", referencedColumnName = "idtipo_formulario")
    @ManyToOne
    private TipoFormulario idtipoFormulario;

    public FormularioTipoformulario() {
    }

    public FormularioTipoformulario(Integer idFormulariotipoformulario) {
        this.idFormulariotipoformulario = idFormulariotipoformulario;
    }

    public Integer getIdFormulariotipoformulario() {
        return idFormulariotipoformulario;
    }

    public void setIdFormulariotipoformulario(Integer idFormulariotipoformulario) {
        this.idFormulariotipoformulario = idFormulariotipoformulario;
    }

    public Formulario getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Formulario idFormulario) {
        this.idFormulario = idFormulario;
    }

    public TipoFormulario getIdtipoFormulario() {
        return idtipoFormulario;
    }

    public void setIdtipoFormulario(TipoFormulario idtipoFormulario) {
        this.idtipoFormulario = idtipoFormulario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormulariotipoformulario != null ? idFormulariotipoformulario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormularioTipoformulario)) {
            return false;
        }
        FormularioTipoformulario other = (FormularioTipoformulario) object;
        if ((this.idFormulariotipoformulario == null && other.idFormulariotipoformulario != null) || (this.idFormulariotipoformulario != null && !this.idFormulariotipoformulario.equals(other.idFormulariotipoformulario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.evaluacion_docente.model.FormularioTipoformulario[ idFormulariotipoformulario=" + idFormulariotipoformulario + " ]";
    }
    
}
