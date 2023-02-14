/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.repositorio;

import com.backrentcarsoft.proyecto.modelo.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LENOVO
 */
public interface AlquilerRepositorio  extends JpaRepository<Alquiler, Long> {
    public Alquiler findByAlquiler(Long alquiler);
}
