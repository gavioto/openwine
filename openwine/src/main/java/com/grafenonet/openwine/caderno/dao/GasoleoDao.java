package com.grafenonet.openwine.caderno.dao;

import java.util.List;

import com.grafenonet.openwine.caderno.domain.Gasoleo;

public interface GasoleoDao {
	
	public void save(Gasoleo ticketGasoil);
	
	public void update(Gasoleo ticketGasoil);
	
	public void delete(Integer idTicketGasoil);
	
	public Gasoleo find(Integer idTicketGasoil);
	
	public List<Gasoleo> findAll(Integer year);
	
	public Gasoleo findResume(int year);
		

}
