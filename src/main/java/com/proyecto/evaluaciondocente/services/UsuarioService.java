/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.evaluaciondocente.services;

import com.proyecto.evaluaciondocente.model.Usuario;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface UsuarioService {
    public Usuario save(Usuario c);
    public List<Usuario> findByAll();
    public Usuario findById(Integer id);
    public void delete(Integer id);
}
