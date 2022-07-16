/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Materia;
import com.proyecto.evaluaciondocente.repository.MateriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class MateriaServiceImp implements MateriaService{
    @Autowired

    MateriaRepository casaRepository;

    @Override
    public Materia save(Materia c) {

        return casaRepository.save(c);
    }

    @Override
    public List<Materia> findByAll() {
        return casaRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        casaRepository.deleteById(id);
    }

    @Override
    public Materia findById(Integer id) {
        return casaRepository.findById(id).orElse(null);
    }
}
