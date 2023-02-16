/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.controlador;

import com.backrentcarsoft.proyecto.modelo.Devolucion;
import com.backrentcarsoft.proyecto.servicio.DevolucionService;
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
public class DevolucionController {
 @Autowired
    private DevolucionService devserv;

    @GetMapping("/do/listar")
    public ResponseEntity<List<Devolucion>> getAll() {
        try {
            return new ResponseEntity<>(devserv.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/do/search/{id}")
    public ResponseEntity<Devolucion> getById(@PathVariable("id") Long id){
        try {
            return  new ResponseEntity<>(devserv.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/do/crear")
    public ResponseEntity<Devolucion> createReproducion(@RequestBody Devolucion dev){
        try {
            return new ResponseEntity<>(devserv.save(dev), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/do/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Long id) {
        try {
            devserv.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar la devolucion");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/do/update/{id}")
    public ResponseEntity<Devolucion> updateClient(@RequestBody Devolucion devl, @PathVariable("id") Long id){
        Devolucion dv =devserv.findById(id);

        if(dv == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                dv.setFecha_dv(devl.getFecha_dv());
                dv.setLugar_dv(devl.getLugar_dv());

                return new ResponseEntity<>(devserv.save(devl), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
