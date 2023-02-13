package com.backrentcarsoft.proyecto.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="comprobante")
@Getter
@Setter
public class Comprobante implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="cod_comp", length = 8)
        private Long cod_comp;
	@Column(name="descripcion", nullable=false, length = 45, unique=false)
	 private String descripcion;
	@Column(name="precio", nullable=false, unique=false)
	 private Double precio;

//        @JsonIgnore
//	@OneToOne(mappedBy="comprobante")
//	private RegistrarDanio comprobantes;
}
