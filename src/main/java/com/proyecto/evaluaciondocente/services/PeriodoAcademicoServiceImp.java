/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.PeriodoAcademico;
import com.proyecto.evaluaciondocente.repository.PeriodoAcademicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class PeriodoAcademicoServiceImp  implements PeriodoAcademicoService{
    @Autowired

    PeriodoAcademicoRepository periodoAcademicoRepository;

    @Override
    public PeriodoAcademico save(PeriodoAcademico c) {

        return periodoAcademicoRepository.save(c);
    }

    @Override
    public List<PeriodoAcademico> findByAll() {
        return periodoAcademicoRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        periodoAcademicoRepository.deleteById(id);
    }

    @Override
    public PeriodoAcademico findById(Integer id) {
        return periodoAcademicoRepository.findById(id).orElse(null);
    }

}
