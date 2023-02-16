/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.controlador;

import com.backrentcarsoft.proyecto.modelo.ClaseAutomovil;
import com.backrentcarsoft.proyecto.servicio.ClaseAutomovilService;
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
public class ClaseAutomovilController {
  @Autowired
    private ClaseAutomovilService claseautomovil;

    @GetMapping("/do/listar")
    public ResponseEntity<List<ClaseAutomovil>> getAll() {
        try {
            return new ResponseEntity<>(claseautomovil.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/do/search/{id}")
    public ResponseEntity<ClaseAutomovil> getById(@PathVariable("id") Long id){
        try {
            return  new ResponseEntity<>(claseautomovil.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/do/crear")
    public ResponseEntity<ClaseAutomovil> createReproducion(@RequestBody ClaseAutomovil claseauto){
        try {
            return new ResponseEntity<>(claseautomovil.save(claseauto), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/do/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Long id) {
        try {
            claseautomovil.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar La clase automovil");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/do/update/{id}")
    public ResponseEntity<ClaseAutomovil> updateClient(@RequestBody ClaseAutomovil clauto, @PathVariable("id") Long id){
        ClaseAutomovil ca =claseautomovil.findById(id);

        if(ca == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                ca.setNombre_clase(clauto.getNombre_clase());
                ca.setPrecio_alquiler_dia(clauto.getPrecio_alquiler_dia());
                

                return new ResponseEntity<>(claseautomovil.save(clauto), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }  
}
