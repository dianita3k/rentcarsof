package com.backrentcarsoft.proyecto.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.backrentcarsoft.proyecto.controlador.dto.UsuarioRegistroDTO;
import com.backrentcarsoft.proyecto.modelo.Rol;
import com.backrentcarsoft.proyecto.modelo.Usuario;
import com.backrentcarsoft.proyecto.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre(),
				passwordEncoder.encode(registroDTO.getPassword()),Arrays.asList(new Rol("ROLE_USER")));
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByUser(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		//return new User(usuario.getUser(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
                return new User(usuario.getUser(),usuario.getPassword(), mapearAutoridadesRoles((Collection<Rol>) usuario.getRol()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}
        
}
