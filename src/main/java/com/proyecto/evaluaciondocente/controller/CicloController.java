/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.controller;

import com.proyecto.evaluaciondocente.model.Ciclo;
import com.proyecto.evaluaciondocente.services.CicloService;
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
@RequestMapping("/api/ciclo")
public class CicloController {

    @Autowired
    CicloService cicloService;

    @GetMapping("/listar")
    public ResponseEntity<List<Ciclo>> listar() {
        return new ResponseEntity<>(cicloService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Ciclo> crearCiclo(@RequestBody Ciclo c) {
        return new ResponseEntity<>(cicloService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Ciclo> eliminarCiclo(@PathVariable Integer id) {
        cicloService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<Ciclo> actualizarCiclo(@RequestBody Ciclo c, @PathVariable Integer id) {
        Ciclo ciclo = cicloService.findById(id);
        ciclo.setCiclo(c.getCiclo());
//        ciclo.setEvaluacionList(c.getEvaluacionList());
        ciclo.setIdCarrera(c.getIdCarrera());
//        ciclo.setMateriaList(c.getMateriaList());
        ciclo.setObservaciones(c.getObservaciones());
        return new ResponseEntity<>(cicloService.save(ciclo), HttpStatus.CREATED);

    }

    @GetMapping("/listarCodigo/{id}")
    public Ciclo encontrarCodigo(@PathVariable Integer id) {
        return cicloService.findById(id);
    }
}
