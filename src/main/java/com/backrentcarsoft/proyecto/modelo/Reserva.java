package com.backrentcarsoft.proyecto.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="reserva")
@Getter
@Setter

public class Reserva implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cod_resv", nullable=false, length = 8, unique=false)
	
        private Long cod_reserva;
	
        @Column(name="horareservarealizad", nullable=false, length = 45, unique=false)
	 private Date horareservarealizad;

	 private Date fecha_iniresv;
	 private Date fecha_finresv;
	 @Column(name="forma_pago", nullable=false, length = 20, unique=false)
	 private String forma_pago;
	 
	
	 //
	//reserva-automovil
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name = "num_placa", referencedColumnName = "num_placa")
	 private Automovil automovil;
	 
	//seguro-reserva
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "cod_seguro", referencedColumnName = "cod_seguro")
	private Seguro seguro;
}