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

import com.grafenonet.openwine.maestros.dao.PaisDao;
import com.grafenonet.openwine.maestros.domain.Pais;
import com.grafenonet.openwine.maestros.service.PaisService;

@Service("paisService")
@Transactional(rollbackFor = Throwable.class, timeout = 300, propagation = Propagation.REQUIRED)
public class PaisServiceImpl implements PaisService {
	private static Logger LOG = LoggerFactory.getLogger(PaisServiceImpl.class);
	
	@Autowired
	PaisDao paisDao;
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.PaisService#create(com.grafenonet.openwine.maestros.domain.Pais)
	 */
	@Override
	public void create(Pais pais) {
		LOG.debug("Iniciando crear pais ...");
		
		if (pais == null) {
			throw new RuntimeException("El pais es nulo.");
		}
			
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + pais.getId());
			LOG.debug(" - codigo = " + pais.getCodigo());
			LOG.debug(" - nombre = " + pais.getNombre());
		}		
		
		pais.setUsuarioAlta("admin");
		pais.setFechaAlta(new Date());
		
		this.paisDao.create(pais);
		
		if (pais.getId() == null) {
			throw new RuntimeException("Error al crear el pais.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Pais creado = " + pais.toString());
		}
		LOG.debug("Finalizando crear pais.");
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.PaisService#update(com.grafenonet.openwine.maestros.domain.Pais)
	 */
	@Override
	public void update(Pais pais) {
		LOG.debug("Iniciando actualizar pais ...");
		
		if (pais == null) {
			throw new RuntimeException("El pais es nulo.");
		}
			
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + pais.getId());
			LOG.debug(" - codigo = " + pais.getCodigo());
			LOG.debug(" - nombre = " + pais.getNombre());
		}
		
		pais.setUsuarioModificacion("admin");
		pais.setFechaModificacion(new Date());
		
		this.paisDao.create(pais);
			
		LOG.debug("Finalizando actualizar pais.");				
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.PaisService#delete(com.grafenonet.openwine.maestros.domain.Pais)
	 */
	@Override
	public void delete(Pais pais) {
		LOG.debug("Iniciando borrar pais ...");
		
		if (pais == null) {
			throw new RuntimeException("El pais es nulo.");
		}		
		
		if (pais.getProvincias() != null || !pais.getProvincias().isEmpty()) {
			throw new RuntimeException("El pais tiene provincias asociadas.");
		}		
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - pais = " + pais.toString());
		}
		
		pais.setUsuarioBaja("admin");
		pais.setFechaBaja(new Date());
		
		this.paisDao.create(pais);
		
		if (pais.getFechaBaja() == null) {
			throw new RuntimeException("Error al dar de baja el pais.");
		}
			
		LOG.debug("Finalizando borrar pais.");		
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.PaisService#get(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly = true)
	public Pais get(Integer id) {
		Pais pais = null;
		
		LOG.debug("Iniciando obtener pais ...");
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - id = " + id);
		}
				
		pais = this.paisDao.get(id);		
		if (pais == null || pais.getId() == null) {
			throw new RuntimeException("Error al obtener el pais '" + id + "'.");
		}
		
		if (pais.getFechaBaja() != null) {
			throw new RuntimeException("El pais '" + id + "' está dado de baja.");
		}
			
		LOG.debug("Finalizando obtener pais.");				
		return pais;
	}
	
	/* (non-Javadoc)
	 * @see com.grafenonet.openwine.maestros.service.impl.PaisService#list()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Pais> list() {
		List<Pais> paises = new ArrayList<Pais>();
		
		LOG.debug("Iniciando obtener paises ...");
				
		paises = this.paisDao.list();		
			
		LOG.debug("Finalizando obtener paises.");					
		return paises;
	}

}
