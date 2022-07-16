/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Formulario;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface FormularioService {
    public Formulario save(Formulario c);
    public List<Formulario> findByAll();
    public Formulario findById(Integer id);
    public void delete(Integer id);
}
