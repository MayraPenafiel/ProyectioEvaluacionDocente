/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.controller;

import com.proyecto.evaluaciondocente.model.Estudiante;
import com.proyecto.evaluaciondocente.services.EstudianteService;
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
@RequestMapping("/api/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Estudiante>> listar() {
        return new ResponseEntity<>(estudianteService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante c) {
        return new ResponseEntity<>(estudianteService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Estudiante> eliminarEstudiante(@PathVariable Integer id) {
        estudianteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@RequestBody Estudiante c, @PathVariable Integer id) {
        Estudiante estudiante = estudianteService.findById(id);
        estudiante.setApellido(c.getApellido());
        estudiante.setCedula(c.getCedula());
        estudiante.setNombre(c.getNombre());
        return new ResponseEntity<>(estudianteService.save(estudiante), HttpStatus.CREATED);
    }

    @GetMapping("/listarCodigo/{id}")
    public Estudiante encontrarCodigo(@PathVariable Integer id) {
        return estudianteService.findById(id);
    }
}
