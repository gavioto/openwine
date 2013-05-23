package com.grafenonet.openwine.caderno.service;

import java.util.List;

import com.grafenonet.openwine.caderno.domain.Gasoleo;

public interface GasoleoService {
	
	public void save(Gasoleo ticketGasoil);
	
	public List<Gasoleo> findAll(Integer year);
	
	public Gasoleo findResume(int year);
}
