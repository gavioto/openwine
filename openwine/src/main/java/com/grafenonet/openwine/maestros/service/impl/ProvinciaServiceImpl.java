package com.grafenonet.openwine.maestros.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grafenonet.openwine.maestros.dao.ProvinciaDao;
import com.grafenonet.openwine.maestros.domain.Provincia;
import com.grafenonet.openwine.maestros.service.ProvinciaService;

@Service("provinciaService")
@Transactional(rollbackFor = Throwable.class, timeout = 300, propagation = Propagation.REQUIRED)
public class ProvinciaServiceImpl implements ProvinciaService {
	private static Logger LOG = LoggerFactory.getLogger(ProvinciaServiceImpl.class);
	
	@Autowired
	ProvinciaDao provinciaDao;
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.ProvinciaService#create(com.grafenonet.openwine.maestros.domain.Provincia)
	 */
	@Override
	public void create(Provincia provincia) {
		LOG.debug("Iniciando crear provincia ...");
		
		if (provincia == null) {
			throw new RuntimeException("La provincia es nula.");
		}
			
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + provincia.getId());
			LOG.debug(" - codigo = " + provincia.getCodigo());
			LOG.debug(" - nombre = " + provincia.getNombre());
			LOG.debug(" - pais = " + provincia.getPais().toString());
		}		
		
		provincia.setUsuarioAlta("admin");
		provincia.setFechaAlta(new Date());
		
		this.provinciaDao.create(provincia);
		
		if (provincia.getId() == null) {
			throw new RuntimeException("Error al crear la provincia.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Provincia creada = " + provincia.toString());
		}
		LOG.debug("Finalizando crear provincia.");
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.ProvinciaService#update(com.grafenonet.openwine.maestros.domain.Provincia)
	 */
	@Override
	public void update(Provincia provincia) {
		LOG.debug("Iniciando actualizar provincia ...");
		
		if (provincia == null) {
			throw new RuntimeException("La provincia es nula.");
		}
			
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + provincia.getId());
			LOG.debug(" - codigo = " + provincia.getCodigo());
			LOG.debug(" - nombre = " + provincia.getNombre());
			LOG.debug(" - pais = " + provincia.getPais().toString());
		}		
		
		provincia.setUsuarioModificacion("admin");
		provincia.setFechaModificacion(new Date());
		
		this.provinciaDao.create(provincia);
		
		LOG.debug("Finalizando actualizar provincia.");
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.ProvinciaService#delete(com.grafenonet.openwine.maestros.domain.Provincia)
	 */
	@Override
	public void delete(Provincia provincia) {
		LOG.debug("Iniciando borrar provincia ...");
		
		if (provincia == null) {
			throw new RuntimeException("La provincia es nula.");
		}
		
		if (provincia.getMunicipios() != null || !provincia.getMunicipios().isEmpty()) {
			throw new RuntimeException("La provincia tiene municipios asociados.");
		}
			
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + provincia.getId());
			LOG.debug(" - codigo = " + provincia.getCodigo());
			LOG.debug(" - nombre = " + provincia.getNombre());
			LOG.debug(" - pais = " + provincia.getPais().toString());
		}		
		
		provincia.setUsuarioBaja("admin");
		provincia.setFechaBaja(new Date());
		
		this.provinciaDao.create(provincia);
		
		if (provincia.getFechaBaja() == null) {
			throw new RuntimeException("Error al dar de baja la provincia.");
		}
		

		LOG.debug("Finalizando crear provincia.");
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.ProvinciaService#get(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = true)
	public Provincia get(Integer id) {
		Provincia provincia = null;
		
		LOG.debug("Iniciando obtener provincia ...");
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + id);
		}
				
		provincia = this.provinciaDao.get(id);		
		if (provincia == null || provincia.getId() == null) {
			throw new RuntimeException("Error al obtener la provincia '" + id + "'.");
		}
		
		if (provincia.getFechaBaja() != null) {
			throw new RuntimeException("La provincia '" + id + "' está dada de baja.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - provincia = " + provincia.toString());
		}		
			
		LOG.debug("Finalizando obtener provincia.");				
		return provincia;
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.ProvinciaService#list()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Provincia> list() {
		List<Provincia> provincias = new ArrayList<Provincia>();
		
		LOG.debug("Iniciando obtener provincias ...");
				
		provincias = this.provinciaDao.list();		
			
		LOG.debug("Finalizando obtener provincias.");					
		return provincias;
	}	
}
