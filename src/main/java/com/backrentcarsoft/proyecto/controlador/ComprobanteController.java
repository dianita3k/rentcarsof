/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.controlador;

import com.backrentcarsoft.proyecto.modelo.Comprobante;
import com.backrentcarsoft.proyecto.servicio.ComprobanteService;
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
public class ComprobanteController {
  @Autowired
    private ComprobanteService compserv;

    @GetMapping("/do/listar")
    public ResponseEntity<List<Comprobante>> getAll() {
        try {
            return new ResponseEntity<>(compserv.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/do/search/{id}")
    public ResponseEntity<Comprobante> getById(@PathVariable("id") Long id){
        try {
            return  new ResponseEntity<>(compserv.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/do/crear")
    public ResponseEntity<Comprobante> createReproducion(@RequestBody Comprobante comp){
        try {
            return new ResponseEntity<>(compserv.save(comp), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/do/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Long id) {
        try {
            compserv.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar el comprobante");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/do/update/{id}")
    public ResponseEntity<Comprobante> updateClient(@RequestBody Comprobante compro, @PathVariable("id") Long id){
        Comprobante co =compserv.findById(id);

        if(co == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                co.setDescripcion(compro.getDescripcion());
                co.setPrecio(compro.getPrecio());

                return new ResponseEntity<>(compserv.save(compro), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
