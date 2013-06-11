package com.grafenonet.openwine.cuaderno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grafenonet.openwine.cuaderno.dao.VariedadDao;
import com.grafenonet.openwine.cuaderno.domain.Variedad;
import com.grafenonet.openwine.cuaderno.service.VariedadService;

@Service("variedadService")
@Transactional(rollbackFor = Throwable.class, timeout = 300, propagation = Propagation.REQUIRED)
public class VariedadServiceImpl implements VariedadService {
	private static Logger LOG = LoggerFactory.getLogger(VariedadServiceImpl.class);
	
	@Autowired
	private VariedadDao variedadDao;
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.VariedadService#create(com.grafenonet.openwine.caderno.domain.Variedad)
	 */
	@Override
	public void create(Variedad variedad) {
		LOG.debug("Iniciando servicio crear ...");
		
		if (variedad == null) {
			throw new RuntimeException("Variedad nula.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - variedad = " + variedad.toString());
		}
		
		this.variedadDao.create(variedad);
		
		LOG.debug("Finalizando servicio crear.");			
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.VariedadService#update(com.grafenonet.openwine.caderno.domain.Variedad)
	 */
	@Override
	public void update(Variedad variedad) {
		LOG.debug("Iniciando servicio actualizar ...");
		
		if (variedad == null) {
			throw new RuntimeException("Variedad nula.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - variedad = " + variedad.toString());
		}
		
		this.variedadDao.update(variedad);		
		
		LOG.debug("Finalizando servicio actualizar.");			
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.VariedadService#delete(com.grafenonet.openwine.caderno.domain.Variedad)
	 */
	@Override
	public void delete(Variedad variedad) {
		LOG.debug("Iniciando servicio borrar ...");
		
		if (variedad == null) {
			throw new RuntimeException("Variedad nula.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - variedad = " + variedad.toString());
		}
		
		this.variedadDao.update(variedad);
		
		LOG.debug("Finalizando servicio borrar.");		
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.VariedadService#get(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = true)
	public Variedad get(Integer id) {
		Variedad variedad = null;
		LOG.debug("Iniciando servicio obtener id ...");
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + id);
		}
		
		variedad = this.variedadDao.get(id);
		
		if (variedad == null) {
			throw new RuntimeException("Variedad no existe.");
		}
		if (variedad.getFechaBaja() != null) {
			throw new RuntimeException("Variedad dada de baja.");
		}
				
		LOG.debug("Finalizando servicio obtener id.");		
		return variedad;
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.caderno.service.impl.VariedadService#list()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Variedad> list() {
		List<Variedad> variedades = new ArrayList<Variedad>();
		LOG.debug("Iniciando servicio listar ...");
		
		variedades = this.variedadDao.list();
		
		LOG.debug("Finalizando servicio listar.");		
		return variedades;
	}

}
