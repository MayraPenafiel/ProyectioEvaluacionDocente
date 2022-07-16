/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Usuario;
import com.proyecto.evaluaciondocente.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class UsuarioServiceImp implements UsuarioService{
    @Autowired

    UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario c) {

        return usuarioRepository.save(c);
    }

    @Override
    public List<Usuario> findByAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

}
