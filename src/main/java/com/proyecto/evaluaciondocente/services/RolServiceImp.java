/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Rol;
import com.proyecto.evaluaciondocente.repository.RolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class RolServiceImp implements RolService{
    @Autowired

    RolRepository rolRepository;

    @Override
    public Rol save(Rol c) {

        return rolRepository.save(c);
    }

    @Override
    public List<Rol> findByAll() {
        return rolRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        rolRepository.deleteById(id);
    }

    @Override
    public Rol findById(Integer id) {
        return rolRepository.findById(id).orElse(null);
    }

}
