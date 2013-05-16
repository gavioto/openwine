package com.grafenonet.openwine.maestros.dao;

import java.util.List;

import com.grafenonet.openwine.maestros.domain.Usuario;

import org.springframework.dao.DataAccessException;

public interface UsuarioDao {
	
	void create(Usuario usuario) throws DataAccessException;
	
	void update(Usuario usuario) throws DataAccessException;
	
	void delete(Integer id) throws DataAccessException;
	
	List<Usuario> list() throws DataAccessException;
	
	Usuario get(Integer id) throws DataAccessException;
	
	Usuario loadUserByUsername(String username) throws DataAccessException;

}
