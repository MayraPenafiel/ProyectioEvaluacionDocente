/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.evaluaciondocente.repository;

import com.proyecto.evaluaciondocente.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    
}
