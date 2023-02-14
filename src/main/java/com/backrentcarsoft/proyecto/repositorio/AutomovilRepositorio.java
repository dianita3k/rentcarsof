/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.repositorio;

import com.backrentcarsoft.proyecto.modelo.Automovil;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LENOVO
 */
public interface AutomovilRepositorio   extends JpaRepository<Automovil, Long> {
    public Automovil findByAuto(String automovil);
}
