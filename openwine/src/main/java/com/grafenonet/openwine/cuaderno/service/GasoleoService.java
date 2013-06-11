package com.grafenonet.openwine.cuaderno.service;

import java.util.List;

import com.grafenonet.openwine.cuaderno.domain.Gasoleo;

public interface GasoleoService {
	
	public void create(Gasoleo gasoleo);
	
	public void update(Gasoleo gasoleo);
	
	public void delete(Gasoleo gasoleo);
	
	public Gasoleo get(Integer id);
	
	public List<Gasoleo> list(Integer year);
	
}
