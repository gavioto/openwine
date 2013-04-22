package com.grafenonet.openwine.maestros.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grafenonet.openwine.maestros.dao.UsuarioDao;
import com.grafenonet.openwine.maestros.domain.Usuario;
import com.grafenonet.openwine.maestros.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	private static Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	UsuarioDao usuarioDao;

	@Override
	public void create(Usuario usuario) {
		this.usuarioDao.create(usuario);		
	}

	@Override
	public void update(Usuario usuario) {
		this.usuarioDao.update(usuario);
	}

	@Override
	public void delete(Integer id) {
		this.usuarioDao.delete(id);
	}

	@Override
	public List<Usuario> list() {
		return this.usuarioDao.list();
	}

	@Override
	public Usuario getById(Integer id) {
		return this.usuarioDao.getById(id);
	}

}
