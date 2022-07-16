/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.controller;

import com.proyecto.evaluaciondocente.model.Persona;
import com.proyecto.evaluaciondocente.services.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listar() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona c) {
        return new ResponseEntity<>(personaService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<Persona> eliminarPersona(@PathVariable Integer id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<Persona> actualizarPersona(@RequestBody Persona c, @PathVariable Integer id) {
        Persona persona = personaService.findById(id);
        persona.setApellido(c.getApellido());
        persona.setAsignacionCoevaluacionList(c.getAsignacionCoevaluacionList());
        persona.setAsignacionCoevaluacionList1(c.getAsignacionCoevaluacionList1());
        persona.setCedula(c.getCedula());
        persona.setCelular(c.getCelular());
        persona.setCorreo(c.getCorreo());
        persona.setDireccion(c.getDireccion());
        persona.setEstadoComision(c.getEstadoComision());
        persona.setEstadoEvaluacion(c.getEstadoEvaluacion());
        persona.setEvaluacionList(c.getEvaluacionList());
        persona.setEvaluacionList1(c.getEvaluacionList1());
        persona.setFechaNacimiento(c.getFechaNacimiento());
        persona.setFoto(c.getFoto());
        persona.setGenero(c.getGenero());
        persona.setIdPersona(c.getIdPersona());
        persona.setIntruccion(c.getIntruccion());
        persona.setNombre(c.getNombre());
        persona.setPersonaMateriaList(c.getPersonaMateriaList());
        persona.setUsuarioList(c.getUsuarioList());
        return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
    }

    @GetMapping("/listarCodigo/{codigo}")
    public Persona encontrarCodigo(@PathVariable Integer id) {
        return personaService.findById(id);
    }
}
