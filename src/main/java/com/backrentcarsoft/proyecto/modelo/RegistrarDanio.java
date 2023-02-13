package com.backrentcarsoft.proyecto.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="registrarDanio")
@Getter
@Setter
public class RegistrarDanio  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_rgd",  length = 8)
        private Long cod_rgd;
	@Column(name="descripcion", nullable=false, length = 100, unique=false)
	private String descripcion;
	@Column(name="precio", nullable=false, unique=false)
	private Double precio;
	//daños-automovil
        
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name = "num_placa", referencedColumnName = "num_placa")
	 private Automovil automovil;
        
         @JsonIgnore
	 @OneToMany(mappedBy="registrarDanio")
	 private List<Devolucion> devolucion;
         
        
}
