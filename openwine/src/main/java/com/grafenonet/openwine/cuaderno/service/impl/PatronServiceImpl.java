package com.grafenonet.openwine.cuaderno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grafenonet.openwine.cuaderno.dao.PatronDao;
import com.grafenonet.openwine.cuaderno.domain.Patron;
import com.grafenonet.openwine.cuaderno.service.PatronService;

@Service("patronService")
@Transactional(rollbackFor = Throwable.class, timeout = 300, propagation = Propagation.REQUIRED)
public class PatronServiceImpl implements PatronService {
	private static Logger LOG = LoggerFactory.getLogger(PatronServiceImpl.class);
	
	@Autowired
	private PatronDao patronDao;
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.PatronService#create(com.grafenonet.openwine.caderno.domain.Patron)
	 */
	@Override
	public void create(Patron patron) {
		LOG.debug("Iniciando servicio crear ...");
		
		if (patron == null) {
			throw new RuntimeException("Patrón nulo.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - patron = " + patron.toString());
		}
	
		this.patronDao.create(patron);
		
		LOG.debug("Finalizando servicio crear.");		
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.PatronService#update(com.grafenonet.openwine.caderno.domain.Patron)
	 */
	@Override
	public void update(Patron patron) {
		LOG.debug("Iniciando servicio actualizar ...");
		
		if (patron == null) {
			throw new RuntimeException("Patrón nulo.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - patron = " + patron.toString());
		}			
				
		this.patronDao.update(patron);
		
		LOG.debug("Finalizando servicio actualizar.");		
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.PatronService#delete(com.grafenonet.openwine.caderno.domain.Patron)
	 */
	@Override
	public void delete(Patron patron) {
		LOG.debug("Iniciando servicio borrar ...");
		
		if (patron == null) {
			throw new RuntimeException("Patrón nulo.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - patron = " + patron.toString());
		}
		
		this.patronDao.delete(patron);
		
		LOG.debug("Finalizando servicio borrar.");		
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.PatronService#get(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = true)
	public Patron get(Integer id) {
		Patron patron = null;
		LOG.debug("Iniciando servicio obtener id ...");
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + id);
		}
		
		patron = this.patronDao.get(id);	
		if (patron == null || patron.getId() == null) {
			throw new RuntimeException("Patrón no encontrado.");
		}
		
		LOG.debug("Finalizando servicio obtener id.");		
		return patron;
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.PatronService#list()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Patron> list() {
		LOG.debug("Iniciando servicio listar ...");
		List<Patron> patrones = new ArrayList<Patron>();		
		
		patrones = this.patronDao.list();		
		
		LOG.debug("Finalizando servicio listar.");
		return patrones;
	}

}
