/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Formulario;
import com.proyecto.evaluaciondocente.repository.FormularioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class FormularioServiceImp implements FormularioService{
    @Autowired

    FormularioRepository formularioRepository;

    @Override
    public Formulario save(Formulario c) {

        return formularioRepository.save(c);
    }

    @Override
    public List<Formulario> findByAll() {
        return formularioRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        formularioRepository.deleteById(id);
    }

    @Override
    public Formulario findById(Integer id) {
        return formularioRepository.findById(id).orElse(null);
    }

}
