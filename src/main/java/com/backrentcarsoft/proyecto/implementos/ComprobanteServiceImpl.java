/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.implementos;

import com.backrentcarsoft.proyecto.modelo.Comprobante;
import com.backrentcarsoft.proyecto.repositorio.ComprobanteRepositorio;
import com.backrentcarsoft.proyecto.servicio.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class ComprobanteServiceImpl extends  GenericServiceImpl<Comprobante, Long> implements ComprobanteService  {

    @Autowired
    ComprobanteRepositorio comprobanteRepositorio;
    
    @Override
    public CrudRepository<Comprobante, Long> getDao() {
    return comprobanteRepositorio;
    }
    
     public Comprobante buscarComprobante(Long cod_comp) {
        return comprobanteRepositorio.findByComprobante(cod_comp);
    }
    
}
