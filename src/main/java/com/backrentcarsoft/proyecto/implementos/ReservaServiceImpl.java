/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.implementos;

import com.backrentcarsoft.proyecto.modelo.Reserva;
import com.backrentcarsoft.proyecto.repositorio.ReservaRepositorio;
import com.backrentcarsoft.proyecto.servicio.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author LENOVO
 */
public class ReservaServiceImpl extends  GenericServiceImpl<Reserva, Long> implements ReservaService  {

    @Autowired
    ReservaRepositorio reservaRepositorio;
    
    @Override
    public CrudRepository<Reserva, Long> getDao() {
    return reservaRepositorio;
    }
    
     public Reserva buscarReserva(Long cod_reserva) {
        return reservaRepositorio.findByReserva(cod_reserva);
    }
    
}