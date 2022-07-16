/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Rol;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface RolService {
    public Rol save(Rol c);
    public List<Rol> findByAll();
    public Rol findById(Integer id);
    public void delete(Integer id);
}
