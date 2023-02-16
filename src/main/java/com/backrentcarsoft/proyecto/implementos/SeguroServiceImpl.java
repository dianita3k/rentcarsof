/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.implementos;

import com.backrentcarsoft.proyecto.modelo.Seguro;
import com.backrentcarsoft.proyecto.repositorio.SeguroRepositorio;
import com.backrentcarsoft.proyecto.servicio.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author LENOVO
 */
public class SeguroServiceImpl extends  GenericServiceImpl<Seguro, Long> implements SeguroService  {

    @Autowired
    SeguroRepositorio seguroRepositorio;
    
    @Override
    public CrudRepository<Seguro, Long> getDao() {
    return seguroRepositorio;
    }
    
     public Seguro buscarSeguro(Long cod_seguro) {
        return seguroRepositorio.findBySeguro(cod_seguro);
    }
    
}