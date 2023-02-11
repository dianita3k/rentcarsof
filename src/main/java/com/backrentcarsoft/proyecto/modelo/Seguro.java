package com.backrentcarsoft.proyecto.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="seguro")
@Getter
@Setter
public class Seguro  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_seguro", length =8)
        private Long cod_seguro;
	@Column(name="nom_seguro", nullable=false, length = 50, unique=false)
	private String nom_seguro;
	@Column(name="precio_seguro", nullable=false, unique=false)
	private Double precio_seguro;
	
	//Reserva-seguro
	@JsonIgnore
	@OneToOne(mappedBy="seguro")
	private Reserva reserva;
}

