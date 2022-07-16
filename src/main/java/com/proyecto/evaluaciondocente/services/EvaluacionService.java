/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Evaluacion;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface EvaluacionService {
    public Evaluacion save(Evaluacion c);
    public List<Evaluacion> findByAll();
    public Evaluacion findById(Integer id);
    public void delete(Integer id);
   //public Evaluacion encontrarCodigo(String cod);
}
