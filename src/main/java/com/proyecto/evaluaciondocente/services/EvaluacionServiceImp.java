/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Evaluacion;
import com.proyecto.evaluaciondocente.repository.EvaluacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class EvaluacionServiceImp implements EvaluacionService{
    @Autowired

    EvaluacionRepository evaluacionRepository;

    @Override
    public Evaluacion save(Evaluacion c) {

        return evaluacionRepository.save(c);
    }

    @Override
    public List<Evaluacion> findByAll() {
        return evaluacionRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        evaluacionRepository.deleteById(id);
    }

    @Override
    public Evaluacion findById(Integer id) {
        return evaluacionRepository.findById(id).orElse(null);
    }

}
