/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.implementos;

import com.backrentcarsoft.proyecto.modelo.Devolucion;
import com.backrentcarsoft.proyecto.repositorio.DevolucionRepositorio;
import com.backrentcarsoft.proyecto.servicio.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class DevolucionServiceImpl extends  GenericServiceImpl<Devolucion, Long> implements DevolucionService {

    
    @Autowired
    DevolucionRepositorio alquilerRepositorio;
    
    @Override
    public CrudRepository<Devolucion, Long> getDao() {
        return alquilerRepositorio;
    }
    
    public Devolucion buscarAlquiler(Long id_dev) {
        return alquilerRepositorio.findByDevolucion(id_dev);
    }
    
}