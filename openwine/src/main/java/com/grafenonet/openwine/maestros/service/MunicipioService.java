package com.grafenonet.openwine.maestros.service;

import java.util.List;

import com.grafenonet.openwine.maestros.domain.Municipio;

public interface MunicipioService {

	void create(Municipio municipio);

	void update(Municipio municipio);

	void delete(Municipio municipio);

	Municipio get(Integer id);

	List<Municipio> list();
	
	List<Municipio> listByProvincia(Integer id);

}