/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Estudiante;
import com.proyecto.evaluaciondocente.repository.EstudianteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class EstudianteServiceImp implements EstudianteService{
    @Autowired

    EstudianteRepository estudianteRepository;

    @Override
    public Estudiante save(Estudiante c) {

        return estudianteRepository.save(c);
    }

    @Override
    public List<Estudiante> findByAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public Estudiante findById(Integer id) {
        return estudianteRepository.findById(id).orElse(null);
    }

}
