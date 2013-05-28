package com.grafenonet.openwine.maestros.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grafenonet.openwine.maestros.dao.UsuarioDao;
import com.grafenonet.openwine.maestros.domain.Usuario;
import com.grafenonet.openwine.maestros.service.UsuarioService;

@Service("usuarioService")
@Transactional(rollbackFor = Throwable.class, timeout = 300, propagation = Propagation.REQUIRED)
public class UsuarioServiceImpl implements UsuarioService {
	private static Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	UsuarioDao usuarioDao;

	@Override
	public void create(Usuario usuario) {
		LOG.debug("Iniciando crear usuario ...");
		
		this.usuarioDao.save(usuario);
		
		LOG.debug("Finalizando crear usuario.");
	}

	@Override
	public void update(Usuario usuario) {
		LOG.debug("Iniciando actualizar usuario ...");

		if (LOG.isDebugEnabled()) {
			LOG.debug(" - usuario = " + usuario.toString());
		}
		
		this.usuarioDao.save(usuario);		
		
		LOG.debug("-finalizando actualizar usuario.");
	}

	@Override
	public void delete(Usuario usuario) {
		LOG.debug("Iniciando borrar usuario ...");
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - usuario = " + usuario.toString());
		}		
		
		this.usuarioDao.save(usuario);
		
		LOG.debug("Finalizando borrar usuario.");
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> list() throws RuntimeException {
		LOG.debug("Iniciando listado de usuarios ...");
		
		List<Usuario> usuarios = this.usuarioDao.list(); 
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - usuarios encontrados = " + (usuarios != null ? usuarios.size() : "0"));
		}		
		
		LOG.debug("Finalizando listado de usuarios.");
		return usuarios;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario get(Integer id) throws RuntimeException {
		LOG.debug("Iniciando obtener usuario por id ...");
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + id);
		}
		
		Usuario usuario = this.usuarioDao.get(id);
		if (usuario == null || usuario.getId() == null) {
			throw new RuntimeException("Error al obtener el usuario '" + id + "'.");
		}
		
		if (usuario.getFechaBaja() != null) {
			throw new RuntimeException("El usuario '" + id + "' está dado de baja.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - usuario = " + usuario.toString());
		}
		
		LOG.debug("Finalizando obtener usuario por id.");
		return usuario;
	}

}
