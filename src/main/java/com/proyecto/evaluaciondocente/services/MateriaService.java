/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Materia;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface MateriaService {
    public Materia save(Materia c);
    public List<Materia> findByAll();
    public Materia findById(Integer id);
    public void delete(Integer id);
}
