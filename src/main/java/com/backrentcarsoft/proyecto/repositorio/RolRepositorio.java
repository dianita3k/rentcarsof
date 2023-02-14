/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.repositorio;

import com.backrentcarsoft.proyecto.modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LENOVO
 */
public interface RolRepositorio extends JpaRepository<Rol, Long> {
    public Rol findByRol(Long rol);
}