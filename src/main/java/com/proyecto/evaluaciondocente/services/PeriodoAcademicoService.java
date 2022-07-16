/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.PeriodoAcademico;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface PeriodoAcademicoService {
    public PeriodoAcademico save(PeriodoAcademico c);
    public List<PeriodoAcademico> findByAll();
    public PeriodoAcademico findById(Integer id);
    public void delete(Integer id);
}
