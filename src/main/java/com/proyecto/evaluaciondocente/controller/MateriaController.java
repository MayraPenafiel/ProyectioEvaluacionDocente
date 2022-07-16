/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.controller;

import com.proyecto.evaluaciondocente.model.Materia;
import com.proyecto.evaluaciondocente.services.MateriaService;
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
@RequestMapping("/api/materia")
public class MateriaController {

    @Autowired
    MateriaService materiaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Materia>> listar() {
        return new ResponseEntity<>(materiaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Materia> crearMateria(@RequestBody Materia c) {
        int cod = materiaService.findByAll().size() + 1;

        return new ResponseEntity<>(materiaService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<Materia> eliminarMateria(@PathVariable Integer id) {
        materiaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<Materia> actualizarMateria(@RequestBody Materia c, @PathVariable Integer id) {
        Materia materia = materiaService.findById(id);
        materia.setEvaluacionList(c.getEvaluacionList());
        materia.setIdCiclo(c.getIdCiclo());
        materia.setIdMateria(c.getIdMateria());
        materia.setNombreMateria(c.getNombreMateria());
        materia.setPersonaMateriaList(c.getPersonaMateriaList());
        return new ResponseEntity<>(materiaService.save(materia), HttpStatus.CREATED);

    }

    @GetMapping("/listarCodigo/{codigo}")
    public Materia encontrarCodigo(@PathVariable Integer id) {
        return materiaService.findById(id);
    }
}
