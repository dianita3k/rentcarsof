/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.implementos;

import com.backrentcarsoft.proyecto.modelo.RegistrarDanio;
import com.backrentcarsoft.proyecto.repositorio.RegistrarDanioRepositorio;
import com.backrentcarsoft.proyecto.servicio.RegistrarDanioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class RegistrarDanioServiceImpl extends  GenericServiceImpl<RegistrarDanio, Long> implements RegistrarDanioService  {

    @Autowired
   RegistrarDanioRepositorio registrarDanioRepositorio;
    
    @Override
    public CrudRepository<RegistrarDanio, Long> getDao() {
    return registrarDanioRepositorio;
    }
    
     public RegistrarDanio buscarRegistrarDanio(Long cod_rgd) {
        return registrarDanioRepositorio.findByRegistrarDanio(cod_rgd);
    }
    
}
