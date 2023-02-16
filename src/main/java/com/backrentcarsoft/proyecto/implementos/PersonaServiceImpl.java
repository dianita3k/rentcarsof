/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.implementos;

import com.backrentcarsoft.proyecto.modelo.Persona;
import com.backrentcarsoft.proyecto.repositorio.PersonaRepositorio;
import com.backrentcarsoft.proyecto.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class PersonaServiceImpl extends  GenericServiceImpl<Persona, Long> implements PersonaService  {

    @Autowired
    PersonaRepositorio personaRepositorio;
    
    @Override
    public CrudRepository<Persona, Long> getDao() {
    return personaRepositorio;
    }
    
     public Persona buscarPersona(Long id_persona) {
        return personaRepositorio.findByPersona(id_persona);
    }
    
}
