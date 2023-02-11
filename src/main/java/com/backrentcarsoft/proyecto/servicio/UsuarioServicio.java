package com.backrentcarsoft.proyecto.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.backrentcarsoft.proyecto.controlador.dto.UsuarioRegistroDTO;
import com.backrentcarsoft.proyecto.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
