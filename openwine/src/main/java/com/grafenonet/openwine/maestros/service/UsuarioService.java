package com.grafenonet.openwine.maestros.service;

import java.util.List;

import com.grafenonet.openwine.maestros.domain.Usuario;

public interface UsuarioService {
	void create(Usuario usuario);
	
	void update(Usuario usuario);
	
	void delete(Integer id);
	
	List<Usuario> list();
	
	Usuario get(Integer id);	
	
}
