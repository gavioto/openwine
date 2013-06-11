package com.grafenonet.openwine.maestros.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grafenonet.openwine.maestros.dao.RolDao;
import com.grafenonet.openwine.maestros.domain.Rol;
import com.grafenonet.openwine.maestros.service.RolService;

@Service("rolService")
@Transactional(rollbackFor = Throwable.class, timeout = 300, propagation = Propagation.REQUIRED)
public class RolServiceImpl implements RolService {
	private static Logger LOG = LoggerFactory.getLogger(RolServiceImpl.class);

	@Autowired
	private RolDao rolDao;
	
	@Transactional(readOnly = true)
	public Rol get(Integer id) {
		LOG.debug("Iniciando obtener ...");
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + id);
		}
		
		Rol rol = this.rolDao.get(id);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - rol = " + rol.toString());
		}		
		
		LOG.debug("Finalizando obtener.");
		return rol;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Rol> list() {
		LOG.debug("Iniciando listar ...");
		
		List<Rol> roles = this.rolDao.list();
		
		LOG.debug("Finalizando listar.");
		return roles;
	}
	
	

}
