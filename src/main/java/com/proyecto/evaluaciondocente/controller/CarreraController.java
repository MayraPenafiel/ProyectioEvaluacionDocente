/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.controller;

import com.proyecto.evaluaciondocente.model.Carrera;
import com.proyecto.evaluaciondocente.services.CarreraService;
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
@RequestMapping("/api/carrera")
public class CarreraController {
     @Autowired
    CarreraService carreraService;

    @GetMapping("/listar")
    public ResponseEntity<List<Carrera>> listar() {
        return new ResponseEntity<>(carreraService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Carrera> crearCarrera(@RequestBody Carrera c) {
        return new ResponseEntity<>(carreraService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Carrera> eliminarCarrera(@PathVariable Integer id) {
        carreraService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Carrera> actualizarCarrera(@RequestBody Carrera c, @PathVariable Integer id) {
        Carrera carrera = carreraService.findById(id);
        carrera.setCicloList(c.getCicloList());
        carrera.setDescripcion(c.getDescripcion());
        carrera.setEvaluacionList(c.getEvaluacionList());
        carrera.setIdCarrera(c.getIdCarrera());
        carrera.setIdPeriodoAcademico(c.getIdPeriodoAcademico());
        carrera.setNombreCarrera(c.getNombreCarrera());
        return new ResponseEntity<>(carreraService.save(carrera), HttpStatus.CREATED);
    }

    @GetMapping("/listarCodigo/{id}")
    public Carrera encontrarCodigo(@PathVariable Integer id) {
        return carreraService.findById(id);
    }
}
