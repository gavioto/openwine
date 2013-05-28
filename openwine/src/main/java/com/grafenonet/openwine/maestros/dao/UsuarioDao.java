package com.grafenonet.openwine.maestros.dao;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataAccessException;

import com.grafenonet.openwine.dao.hibernate.IGenericDao;
import com.grafenonet.openwine.maestros.domain.Usuario;

public interface UsuarioDao extends IGenericDao<Usuario> {
	
	Usuario loadUserByUsername(String username) throws DataAccessException, EntityNotFoundException;

}
