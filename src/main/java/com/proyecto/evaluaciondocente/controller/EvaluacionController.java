/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.controller;


import com.proyecto.evaluaciondocente.model.Evaluacion;
import com.proyecto.evaluaciondocente.services.EvaluacionService;
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
@RequestMapping("/api/evaluacion")
public class EvaluacionController {

    @Autowired
    EvaluacionService evaluacionService;

    @GetMapping("/listar")
    public ResponseEntity<List<Evaluacion>> listar() {
        return new ResponseEntity<>(evaluacionService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Evaluacion> crearEvaluacion(@RequestBody Evaluacion c) {
        return new ResponseEntity<>(evaluacionService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Evaluacion> eliminarEvaluacion(@PathVariable Integer id) {
        evaluacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Evaluacion> actualizarEvaluacion(@RequestBody Evaluacion c, @PathVariable Integer id) {
        Evaluacion evaluacion = evaluacionService.findById(id);
        evaluacion.setCalificacion(c.getCalificacion());
        evaluacion.setFecha(c.getFecha());
        evaluacion.setIdCarrera(c.getIdCarrera());
        evaluacion.setIdCiclo(c.getIdCiclo());
        evaluacion.setIdEstudiante(c.getIdEstudiante());
        evaluacion.setIdEvaluacion(c.getIdEvaluacion());
        evaluacion.setIdFormulario(c.getIdFormulario());
        evaluacion.setIdMateria(c.getIdMateria());
        evaluacion.setIdPersona(c.getIdPersona());
        evaluacion.setIdTipoFormulario(c.getIdTipoFormulario());
        evaluacion.setObservacion(c.getObservacion());
        return new ResponseEntity<>(evaluacionService.save(evaluacion), HttpStatus.CREATED);

    }

    @GetMapping("/listarCodigo/{id}")
    public Evaluacion encontrarCodigo(@PathVariable Integer id) {
        return evaluacionService.findById(id);
    }
}
