/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.controller;

import com.proyecto.evaluaciondocente.model.Usuario;
import com.proyecto.evaluaciondocente.services.UsuarioService;
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
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar() {
        return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario c) {
        return new ResponseEntity<>(usuarioService.save(c), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable Integer id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario c, @PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        usuario.setContrasenia(c.getContrasenia());
        usuario.setFechaHoraRegistro(c.getFechaHoraRegistro());
        usuario.setIdPersona(c.getIdPersona());
        usuario.setIdRol(c.getIdRol());
        usuario.setIdUsuario(c.getIdUsuario());
        usuario.setUsuario(c.getUsuario());
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
    }
    
    @GetMapping("/listarCodigo/{id}")
    public Usuario encontrarCodigo(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }
}
