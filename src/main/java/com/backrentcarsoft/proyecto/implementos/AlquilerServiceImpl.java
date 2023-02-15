/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.implementos;

import com.backrentcarsoft.proyecto.modelo.Alquiler;
import com.backrentcarsoft.proyecto.repositorio.AlquilerRepositorio;
import com.backrentcarsoft.proyecto.servicio.AlquilerServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class AlquilerServiceImpl extends  GenericServiceImpl<Alquiler, Long> implements AlquilerServicio {

    
    @Autowired
    AlquilerRepositorio alquilerRepositorio;
    
    @Override
    public CrudRepository<Alquiler, Long> getDao() {
        return alquilerRepositorio;
    }
    
    public Alquiler buscarAlquiler(Long id_alquiler) {
        return alquilerRepositorio.findByAlquiler(id_alquiler);
    }
    
}
