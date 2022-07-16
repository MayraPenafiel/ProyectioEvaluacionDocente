/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Ciclo;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface CicloService {
    public Ciclo save(Ciclo c);
    public List<Ciclo> findByAll();
    public Ciclo findById(Integer id);
    public void delete(Integer id);
    //public Ciclo encontrarCodigo(String cod);
}
