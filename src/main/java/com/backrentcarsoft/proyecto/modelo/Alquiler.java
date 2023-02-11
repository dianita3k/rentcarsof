package com.backrentcarsoft.proyecto.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="alquiler")
@Getter
@Setter

public class Alquiler  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id_alquiler", length = 8)
         private Long id_alquiler;
	 @Column(name="num_dias_alquiler", nullable=false, length = 10, unique=false)
	 private String num_dias_alquiler;
	
	private Date fecha_salida;
        private Date prox_fecha_entrega;
     
     
     @Column(name="documento_garantia", nullable=false, length = 15, unique=false)
	 private String documento_garantia;
     @Column(name="descripcionalqui", nullable=false, length = 150, unique=false)
	 private String descripcion_alquiler;
     @Column(name="precio_total", nullable=false, unique=false)
	 private Double precio_total;
	 
  
}
