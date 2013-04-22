package com.grafenonet.openwine.maestros.dao;

import java.util.List;

import com.grafenonet.openwine.maestros.domain.Usuario;

public interface UsuarioDao {
	
	void create(Usuario usuario);
	
	void update(Usuario usuario);
	
	void delete(Integer id);
	
	List<Usuario> list();
	
	Usuario getById(Integer id);	

}
