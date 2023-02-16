/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.implementos;

import com.backrentcarsoft.proyecto.modelo.ClaseAutomovil;
import com.backrentcarsoft.proyecto.repositorio.ClaseAutomovilRepositorio;
import com.backrentcarsoft.proyecto.servicio.ClaseAutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class ClaseAutomovilServiceImpl extends  GenericServiceImpl<ClaseAutomovil, Long> implements ClaseAutomovilService  {

    @Autowired
    ClaseAutomovilRepositorio claseAutomovilRepositorio;
    
    @Override
    public CrudRepository<ClaseAutomovil, Long> getDao() {
    return claseAutomovilRepositorio;
    }
    
     public ClaseAutomovil buscarClaseAutomovil(Long id_clase) {
        return claseAutomovilRepositorio.findByClaseAuto(id_clase);
    }
    
}
