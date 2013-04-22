package com.grafenonet.openwine.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grafenonet.openwine.dao.TicketGasoilDao;
import com.grafenonet.openwine.domain.TicketGasoil;
import com.grafenonet.openwine.service.TicketGasoilService;

@Service("ticketGasoilService")
public class TicketGasoilServiceImpl implements TicketGasoilService {
	private static Logger LOG = LoggerFactory.getLogger(TicketGasoilService.class);
	
	@Autowired 
	TicketGasoilDao ticketGasoilDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(TicketGasoil ticketGasoil) {
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
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TicketGasoil> findAll(Integer year) {
		LOG.debug("Iniciando findAll ...");
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - year = " + year);
		}
		
		LOG.debug("Finalizando findAll.");
		return ticketGasoilDao.findAll(year);
	}

	@Override
	public TicketGasoil findResume(int year) {
		LOG.debug("Iniciando findResume ...");
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - year = " + year);
		}		
		
		LOG.debug("Finalizando findResume.");
		return ticketGasoilDao.findResume(year);		
	}

}
