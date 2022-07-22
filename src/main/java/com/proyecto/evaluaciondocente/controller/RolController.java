/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.controller;

import com.proyecto.evaluaciondocente.model.Rol;
import com.proyecto.evaluaciondocente.services.RolService;
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
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    RolService rolService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> listar() {
        return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Rol> crearRol(@RequestBody Rol c) {
        return new ResponseEntity<>(rolService.save(c), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Rol> eliminarRol(@PathVariable Integer id) {
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Rol> actualizarRol(@RequestBody Rol c, @PathVariable Integer id) {
        Rol rol = rolService.findById(id);
        rol.setDescripcion(c.getDescripcion());
        rol.setFechaHoraRegistro(c.getFechaHoraRegistro());
        rol.setRol(c.getRol());
//        rol.setUsuarioList(c.getUsuarioList());
        return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
        
    }
    
    @GetMapping("/listarCodigo/{id}")
    public Rol encontrarCodigo(@PathVariable Integer id) {
        return rolService.findById(id);
    }
}
