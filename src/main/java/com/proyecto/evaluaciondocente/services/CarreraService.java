/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Carrera;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface CarreraService {
    public Carrera save(Carrera c);
    public List<Carrera> findByAll();
    public Carrera findById(Integer id);
    public void delete(Integer id);
    //public Carrera encontrarCodigo(String cod);
}
