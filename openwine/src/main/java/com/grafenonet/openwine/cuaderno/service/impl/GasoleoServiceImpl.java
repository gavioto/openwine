package com.grafenonet.openwine.cuaderno.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grafenonet.openwine.cuaderno.dao.GasoleoDao;
import com.grafenonet.openwine.cuaderno.domain.Gasoleo;
import com.grafenonet.openwine.cuaderno.service.GasoleoService;

@Service("gasoleoService")
@Transactional(rollbackFor = Throwable.class, timeout = 300, propagation = Propagation.REQUIRED)
public class GasoleoServiceImpl implements GasoleoService {
	private static Logger LOG = LoggerFactory.getLogger(GasoleoService.class);
	
	@Autowired 
	GasoleoDao gasoleoDao;

	@Override
	public void create(Gasoleo gasoleo) {
		LOG.debug("Iniciando servicio crear ...");
		
		if (gasoleo == null) {
			throw new RuntimeException("Gasoleo nulo.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - fecha = " + gasoleo.getFecha());
			LOG.debug(" - importe = " + gasoleo.getImporte());
			LOG.debug(" - litros = " + gasoleo.getLitros());
		}
		
		this.gasoleoDao.create(gasoleo);
		
		LOG.debug("Finalizando servicio crear.");
	}

	@Override
	public void update(Gasoleo gasoleo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Gasoleo gasoleo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Gasoleo get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gasoleo> list(Integer year) {
		LOG.debug("Iniciando servicio listar ...");
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - year = " + year);
		}
		
		LOG.debug("Finalizando servicio listar.");
		return gasoleoDao.list();		
	}


}
