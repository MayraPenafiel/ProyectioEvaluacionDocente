/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Estudiante;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface EstudianteService {
    public Estudiante save(Estudiante c);
    public List<Estudiante> findByAll();
    public Estudiante findById(Integer id);
    public void delete(Integer id);
    //public Estudiante encontrarCodigo(String cod);
}
