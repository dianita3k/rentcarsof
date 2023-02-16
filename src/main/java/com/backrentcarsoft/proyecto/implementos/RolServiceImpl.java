/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.implementos;

import com.backrentcarsoft.proyecto.modelo.Rol;
import com.backrentcarsoft.proyecto.repositorio.RolRepositorio;
import com.backrentcarsoft.proyecto.servicio.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class RolServiceImpl extends  GenericServiceImpl<Rol, Long> implements RolService  {

    @Autowired
    RolRepositorio rolRepositorio;
    
    @Override
    public CrudRepository<Rol, Long> getDao() {
    return rolRepositorio;
    }
    
     public Rol buscarRol(Long id) {
        return rolRepositorio.findByRol(id);
    }
    
}

