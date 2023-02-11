package com.backrentcarsoft.proyecto.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    
        private Long id;

	@Column(name="nombre", nullable=false, length = 45, unique=false)
	private String nombre;

	private String email;
	private String password;
	
	 //
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "id",referencedColumnName = "id")
			)
	private Collection<Rol> roles;

	

	public Usuario(Long id, String nombre,String email, String user, String password, Collection<Rol> roles) {
		super();
		this.id= id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Usuario(String nombre, String email, String password, Collection<Rol> roles) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Usuario() {
		
	}
        
   
        
        
        

}
