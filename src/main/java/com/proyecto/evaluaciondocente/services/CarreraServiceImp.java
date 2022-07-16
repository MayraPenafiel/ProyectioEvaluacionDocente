/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Carrera;
import com.proyecto.evaluaciondocente.repository.CarreraRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class CarreraServiceImp implements CarreraService {

    @Autowired

    CarreraRepository casaRepository;

    @Override
    public Carrera save(Carrera c) {

        return casaRepository.save(c);
    }

    @Override
    public List<Carrera> findByAll() {
        return casaRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        casaRepository.deleteById(id);
    }

    @Override
    public Carrera findById(Integer id) {
        return casaRepository.findById(id).orElse(null);
    }
}
