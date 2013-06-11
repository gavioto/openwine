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

import com.grafenonet.openwine.maestros.dao.MunicipioDao;
import com.grafenonet.openwine.maestros.domain.Municipio;
import com.grafenonet.openwine.maestros.service.MunicipioService;

@Service("municipioService")
@Transactional(rollbackFor = Throwable.class, timeout = 300, propagation = Propagation.REQUIRED)
public class MunicipioServiceImpl implements MunicipioService {
	private static Logger LOG = LoggerFactory.getLogger(MunicipioServiceImpl.class);
	
	@Autowired
	MunicipioDao municipioDao;
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.MunicipioService#create(com.grafenonet.openwine.maestros.domain.Municipio)
	 */
	@Override
	public void create(Municipio municipio) {
		LOG.debug("Iniciando crear municipio ...");
		
		if (municipio == null) {
			throw new RuntimeException("El municipio es nulo.");
		}
			
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + municipio.getId());
			LOG.debug(" - codigo = " + municipio.getCodigo());
			LOG.debug(" - nombre = " + municipio.getNombre());
			LOG.debug(" - provincia = " + municipio.getProvincia().toString());
		}		
		
		municipio.setUsuarioAlta("admin");
		municipio.setFechaAlta(new Date());
		
		this.municipioDao.create(municipio);
		
		if (municipio.getId() == null) {
			throw new RuntimeException("Error al crear el municipio.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Municipio creado = " + municipio.toString());
		}
		LOG.debug("Finalizando crear municipio.");
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.MunicipioService#update(com.grafenonet.openwine.maestros.domain.Municipio)
	 */
	@Override
	public void update(Municipio municipio) {
		LOG.debug("Iniciando actualizar municipio ...");
		
		if (municipio == null) {
			throw new RuntimeException("El municipio es nulo.");
		}
			
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + municipio.getId());
			LOG.debug(" - codigo = " + municipio.getCodigo());
			LOG.debug(" - nombre = " + municipio.getNombre());
			LOG.debug(" - provincia = " + municipio.getProvincia().toString());
		}		
		
		municipio.setUsuarioModificacion("admin");
		municipio.setFechaModificacion(new Date());
		
		this.municipioDao.create(municipio);
		
		LOG.debug("Finalizando actualizar municipio.");
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.MunicipioService#delete(com.grafenonet.openwine.maestros.domain.Municipio)
	 */
	@Override
	public void delete(Municipio municipio) {
		LOG.debug("Iniciando borrar municipio ...");
		
		if (municipio == null) {
			throw new RuntimeException("El municipio es nulo.");
		}
			
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + municipio.getId());
			LOG.debug(" - codigo = " + municipio.getCodigo());
			LOG.debug(" - nombre = " + municipio.getNombre());
			LOG.debug(" - provincia = " + municipio.getProvincia().toString());
		}		
		
		municipio.setUsuarioBaja("admin");
		municipio.setFechaBaja(new Date());
		
		this.municipioDao.create(municipio);
		
		if (municipio.getFechaBaja() == null) {
			throw new RuntimeException("Error al dar de baja el municipio.");
		}
		
		LOG.debug("Finalizando actualizar municipio.");
	}
	
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.MunicipioService#get(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = true)
	public Municipio get(Integer id) {
		Municipio municipio = null;
		
		LOG.debug("Iniciando obtener municipio ...");
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + id);
		}		
			
		municipio = this.municipioDao.get(id);
		if (municipio == null || municipio.getId() == null) {
			throw new RuntimeException("Error al obtener el municipio '" + id + "'.");
		}
		
		if (municipio.getFechaBaja() != null) {
			throw new RuntimeException("El municipio '" + id + "' está dado de baja.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - municipio = " + municipio.toString());
		}		
		
		LOG.debug("Finalizando obtener municipio.");
		return municipio;
	}	
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.MunicipioService#list()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Municipio> list() {
		List<Municipio> municipios = new ArrayList<Municipio>();
		
		LOG.debug("Iniciando obtener municipios ...");
		
		municipios = this.municipioDao.list();
		
		LOG.debug("Finalizando obtener municipios.");		
		return municipios;
	}
}
