/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Ciclo;
import com.proyecto.evaluaciondocente.repository.CicloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class CicloServiceImp implements CicloService{
    @Autowired

    CicloRepository cicloRepository;

    @Override
    public Ciclo save(Ciclo c) {

        return cicloRepository.save(c);
    }

    @Override
    public List<Ciclo> findByAll() {
        return cicloRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        cicloRepository.deleteById(id);
    }

    @Override
    public Ciclo findById(Integer id) {
        return cicloRepository.findById(id).orElse(null);
    }


}
