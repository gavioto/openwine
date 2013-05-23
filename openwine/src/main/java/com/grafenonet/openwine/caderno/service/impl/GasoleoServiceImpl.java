package com.grafenonet.openwine.caderno.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grafenonet.openwine.caderno.dao.GasoleoDao;
import com.grafenonet.openwine.caderno.domain.Gasoleo;
import com.grafenonet.openwine.caderno.service.GasoleoService;

@Service("ticketGasoilService")
@Transactional(rollbackFor = Throwable.class, timeout = 300, propagation = Propagation.REQUIRED)
public class GasoleoServiceImpl implements GasoleoService {
	private static Logger LOG = LoggerFactory.getLogger(GasoleoService.class);
	
	@Autowired 
	GasoleoDao ticketGasoilDao;

	@Override
	public void save(Gasoleo ticketGasoil) {
		LOG.debug("Iniciando save ...");
		
		if (ticketGasoil == null) {
			throw new RuntimeException("Ticket gasoil a guardar nulo.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - fecha = " + ticketGasoil.getFecha());
			LOG.debug(" - importe = " + ticketGasoil.getImporte());
			LOG.debug(" - litros = " + ticketGasoil.getLitros());
		}
		
		ticketGasoilDao.save(ticketGasoil);
		
		LOG.debug("Finalizando save-");
	}

	@Override
	@Transactional(readOnly = true)
	public List<Gasoleo> findAll(Integer year) {
		LOG.debug("Iniciando findAll ...");
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - year = " + year);
		}
		
		LOG.debug("Finalizando findAll.");
		return ticketGasoilDao.findAll(year);
	}

	@Override
	@Transactional(readOnly = true)
	public Gasoleo findResume(int year) {
		LOG.debug("Iniciando findResume ...");
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - year = " + year);
		}		
		
		LOG.debug("Finalizando findResume.");
		return ticketGasoilDao.findResume(year);		
	}

}
