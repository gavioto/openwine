package com.grafenonet.openwine.maestros.dao;

import java.util.List;

import com.grafenonet.openwine.maestros.domain.Pais;

public interface PaisDao {
	
	void create(Pais pais);
	
	void update(Pais pais);
	
	void delete(Integer id);
	
	List<Pais> list();
		
	List<Pais> find(String codigo, String nombre);
	
	Pais getById(Integer id);

}
