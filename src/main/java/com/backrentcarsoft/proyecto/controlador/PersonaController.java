/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.controlador;

import com.backrentcarsoft.proyecto.modelo.Persona;
import com.backrentcarsoft.proyecto.servicio.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class PersonaController {
  @Autowired
    private PersonaService per;

    @GetMapping("/do/listar")
    public ResponseEntity<List<Persona>> getAll() {
        try {
            return new ResponseEntity<>(per.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/do/search/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id){
        try {
            return  new ResponseEntity<>(per.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/do/crear")
    public ResponseEntity<Persona> createReproducion(@RequestBody Persona persona){
        try {
            return new ResponseEntity<>(per.save(persona), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/do/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Long id) {
        try {
            per.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar al persona");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/do/update/{id}")
    public ResponseEntity<Persona> updateClient(@RequestBody Persona prs, @PathVariable("id") Long id){
        Persona pe =per.findById(id);

        if(pe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                pe.setNombre(prs.getNombre());
                pe.setApellido(prs.getApellido());
                pe.setCedula(prs.getCedula());
                pe.setDireccion(prs.getDireccion());
                pe.setTelefono(prs.getTelefono());
                pe.setCorreo(prs.getCorreo());
                pe.setEdad(prs.getEdad());
                pe.setUsuario(prs.getUsuario());
                pe.setContrasenia(prs.getContrasenia());
                pe.setCiudad(prs.getCiudad());
                pe.setGenero(prs.getGenero());
                

                return new ResponseEntity<>(per.save(prs), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
