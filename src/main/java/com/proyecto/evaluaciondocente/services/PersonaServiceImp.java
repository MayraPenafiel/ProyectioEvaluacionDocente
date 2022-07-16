/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Persona;
import com.proyecto.evaluaciondocente.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class PersonaServiceImp implements PersonaService{
    @Autowired

    PersonaRepository personaRepository;

    @Override
    public Persona save(Persona c) {

        return personaRepository.save(c);
    }

    @Override
    public List<Persona> findByAll() {
        return personaRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findById(Integer id) {
        return personaRepository.findById(id).orElse(null);
    }

}
