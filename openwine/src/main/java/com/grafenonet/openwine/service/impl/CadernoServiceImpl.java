package com.grafenonet.openwine.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grafenonet.openwine.domain.TicketGasoil;
import com.grafenonet.openwine.service.CadernoService;
import com.grafenonet.openwine.service.TicketGasoilService;

@Service
public class CadernoServiceImpl implements CadernoService {
	
	private static Logger LOG = LoggerFactory.getLogger(CadernoServiceImpl.class);
	
	@Autowired
	private TicketGasoilService ticketGasoilService;

	@Override
	public TicketGasoil getResumenTickets(int year) {
		LOG.debug("Iniciando getResumenTickets ...");
		
		BigDecimal importe = new BigDecimal(0);
		BigDecimal litros = new BigDecimal(0);
		Date date = new Date();
		
		List<TicketGasoil> tickets = ticketGasoilService.findAll(year);
		for (TicketGasoil ticket : tickets) {
			
				importe = importe.add(ticket.getImporte());
				litros = litros.add(ticket.getLitros());
			
		}
		
		TicketGasoil ticketGasoil = new TicketGasoil();
		ticketGasoil.setFecha(date);
		ticketGasoil.setImporte(importe);
		ticketGasoil.setLitros(litros);
				
		LOG.debug("Finalizando getResumenTickets.");
		return ticketGasoil;
		
	}

}
