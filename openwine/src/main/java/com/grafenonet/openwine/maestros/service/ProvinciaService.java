package com.grafenonet.openwine.maestros.service;

import java.util.List;

import com.grafenonet.openwine.maestros.domain.Provincia;

public interface ProvinciaService {

	public void create(Provincia provincia);

	public void update(Provincia provincia);

	public void delete(Provincia provincia);

	public Provincia get(Integer id);

	public List<Provincia> list();
	
	public List<Provincia> listByPais(Integer id);	

}