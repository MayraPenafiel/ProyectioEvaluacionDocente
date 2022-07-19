/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.controller;

import com.proyecto.evaluaciondocente.model.PeriodoAcademico;
import com.proyecto.evaluaciondocente.services.PeriodoAcademicoService;
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
@RequestMapping("/api/periodoAcademico")
public class PeriodoAcademicoController {

    @Autowired
    PeriodoAcademicoService periodoAcademicoService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<PeriodoAcademico>> listar() {
        return new ResponseEntity<>(periodoAcademicoService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<PeriodoAcademico> crearPeriodoAcademico(@RequestBody PeriodoAcademico c) {
        return new ResponseEntity<>(periodoAcademicoService.save(c), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<PeriodoAcademico> eliminarPeriodoAcademico(@PathVariable Integer id) {
        periodoAcademicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<PeriodoAcademico> actualizarPeriodoAcademico(@RequestBody PeriodoAcademico c, @PathVariable String codigo) {
        int id = Integer.parseInt(codigo.substring(3));
        PeriodoAcademico periodoAcademico = periodoAcademicoService.findById(id);
        periodoAcademico.setCarreraCollection(c.getCarreraCollection());
        periodoAcademico.setFechaFin(c.getFechaFin());
        periodoAcademico.setFechaInicio(c.getFechaInicio());
        periodoAcademico.setIdPeriodoAcademico(c.getIdPeriodoAcademico());
        periodoAcademico.setPeriodo(c.getPeriodo());
        return new ResponseEntity<>(periodoAcademicoService.save(periodoAcademico), HttpStatus.CREATED);
        
    }
    
    @GetMapping("/listarCodigo/{codigo}")
    public PeriodoAcademico encontrarCodigo(@PathVariable Integer id) {
        return periodoAcademicoService.findById(id);
    }
}
