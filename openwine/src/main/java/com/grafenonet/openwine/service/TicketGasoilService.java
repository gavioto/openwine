package com.grafenonet.openwine.service;

import java.util.List;

import com.grafenonet.openwine.domain.TicketGasoil;

public interface TicketGasoilService {
	
	public void save(TicketGasoil ticketGasoil);
	
	public List<TicketGasoil> findAll(Integer year);
	
	public TicketGasoil findResume(int year);
}
