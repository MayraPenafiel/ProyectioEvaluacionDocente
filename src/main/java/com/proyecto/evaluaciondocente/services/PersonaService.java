/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Persona;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface PersonaService {
    public Persona save(Persona c);
    public List<Persona> findByAll();
    public Persona findById(Integer id);
    public void delete(Integer id);
}
