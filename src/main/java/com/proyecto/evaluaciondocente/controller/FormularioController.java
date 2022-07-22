/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.controller;

import com.proyecto.evaluaciondocente.model.Formulario;
import com.proyecto.evaluaciondocente.services.FormularioService;
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
@RequestMapping("/api/formulario")
public class FormularioController {

    @Autowired
    FormularioService formularioService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Formulario>> listar() {
        return new ResponseEntity<>(formularioService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Formulario> crearFormulario(@RequestBody Formulario c) {
        return new ResponseEntity<>(formularioService.save(c), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Formulario> eliminarFormulario(@PathVariable Integer id) {
        formularioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Formulario> actualizarFormulario(@RequestBody Formulario c, @PathVariable Integer id) {
        Formulario formulario = formularioService.findById(id);
//        formulario.setEvaluacionList(c.getEvaluacionList());
//        formulario.setFormularioTipoformularioList(c.getFormularioTipoformularioList());
        formulario.setObservacion(c.getObservacion());
        formulario.setPreguntas(c.getPreguntas());
        return new ResponseEntity<>(formularioService.save(formulario), HttpStatus.CREATED);
        
    }
    
    @GetMapping("/listarCodigo/{id}")
    public Formulario encontrarCodigo(@PathVariable Integer id) {
        return formularioService.findById(id);
    }
}
