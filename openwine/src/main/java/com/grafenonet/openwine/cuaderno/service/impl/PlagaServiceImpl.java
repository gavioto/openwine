package com.grafenonet.openwine.cuaderno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grafenonet.openwine.cuaderno.dao.PlagaDao;
import com.grafenonet.openwine.cuaderno.domain.Plaga;
import com.grafenonet.openwine.cuaderno.service.PlagaService;

@Service("plagaService")
@Transactional(rollbackFor = Throwable.class, timeout = 300, propagation = Propagation.REQUIRED)
public class PlagaServiceImpl implements PlagaService {
	private static Logger LOG = LoggerFactory.getLogger(PlagaServiceImpl.class);
	
	@Autowired
	PlagaDao plagaDao;

	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.PlagaService#create(com.grafenonet.openwine.caderno.domain.Plaga)
	 */
	@Override
	public void create(Plaga plaga) {
		LOG.debug("Iniciando servicio crear ...");
		
		if (plaga == null) {
			throw new RuntimeException("Plaga nula.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - plaga = " + plaga.toString());
		}
		
		this.plagaDao.create(plaga);
		if (plaga.getId() == null) {
			throw new RuntimeException("Error al crear la plaga");
		}
		
		LOG.debug("Finalizando servicio crear.");		
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.PlagaService#update(com.grafenonet.openwine.caderno.domain.Plaga)
	 */
	@Override
	public void update(Plaga plaga) {
		LOG.debug("Iniciando servicio actualizar ...");
		
		if (plaga == null) {
			throw new RuntimeException("Plaga nula.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - plaga = " + plaga.toString());
		}
		
		this.plagaDao.update(plaga);
		
		LOG.debug("Finalizando servicio actualizar.");		
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.PlagaService#delete(com.grafenonet.openwine.caderno.domain.Plaga)
	 */
	@Override
	public void delete(Plaga plaga) {
		LOG.debug("Iniciando servicio borrar ...");
		
		if (plaga == null) {
			throw new RuntimeException("Plaga nula.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - plaga = " + plaga.toString());
		}
		
		this.plagaDao.delete(plaga);
		
		LOG.debug("Finalizando servicio borrar.");
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.PlagaService#get(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = true)
	public Plaga get(Integer id) {
		Plaga plaga = null;
		
		LOG.debug("Iniciando servicio obtener id ...");
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + id);
		}
		
		plaga = this.plagaDao.get(id);
		if (plaga == null || plaga.getId() == null) {
			throw new RuntimeException("Plaga no encontrada");
		}
		
		
		LOG.debug("Finalizando servicio obtener id.");
		return plaga;
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.PlagaService#list()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Plaga> list() {
		List<Plaga> plagas = new ArrayList<Plaga>();
		LOG.debug("Iniciando servicio listar ...");
		
		plagas = this.plagaDao.list();
		
		LOG.debug("Finalizando servicio listar.");
		return plagas;
		
	}
}
