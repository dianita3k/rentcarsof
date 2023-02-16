/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.implementos;

import com.backrentcarsoft.proyecto.modelo.Automovil;
import com.backrentcarsoft.proyecto.repositorio.AutomovilRepositorio;
import com.backrentcarsoft.proyecto.servicio.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class AutomovilServiceImpl extends  GenericServiceImpl<Automovil, String> implements AutomovilService{ 

    @Autowired
    AutomovilRepositorio automovilRepositorio;
    
    
    @Override
    public CrudRepository<Automovil, String> getDao() {
       return automovilRepositorio;
    }
    
     public Automovil buscarAutomovil(String num_placa) {
        return automovilRepositorio.findByAuto(num_placa);
    }
    
    
    
}
