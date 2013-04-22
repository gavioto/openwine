package com.grafenonet.openwine.dao;

import java.util.List;

import com.grafenonet.openwine.domain.TicketGasoil;

public interface TicketGasoilDao {
	
	public void save(TicketGasoil ticketGasoil);
	
	public void update(TicketGasoil ticketGasoil);
	
	public void delete(Integer idTicketGasoil);
	
	public TicketGasoil find(Integer idTicketGasoil);
	
	public List<TicketGasoil> findAll(Integer year);
	
	public TicketGasoil findResume(int year);
		

}
