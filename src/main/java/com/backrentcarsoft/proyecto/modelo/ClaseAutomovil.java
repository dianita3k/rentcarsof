/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backrentcarsoft.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name="claseAutomovil")
@Getter
@Setter
public class ClaseAutomovil {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_clase",length = 8)
    private Long id_clase;
         @Column(name="nombre_clase", nullable=false, length = 50, unique=false)
	private String nombre_clase;
        
        @Column(name="precio_alquiler_dia", nullable=false, unique=false)
	private double precio_alquiler_dia;
         
    
}
