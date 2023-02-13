/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name="claseautomovil")
@Getter
@Setter

public class ClaseAutomovil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_clase",length = 8)
    private Long id_clase;
    @Column(name="nombre_clase", nullable=false, length = 50, unique=false)
    private String nombre_clase;
        
    @Column(name="precio_alquiler_dia", nullable=false, unique=false)
    private double precio_alquiler_dia;
    
    @JsonIgnore
    @OneToMany(mappedBy="claseAutomovil")
    private List<Automovil> automovil;

    
}
