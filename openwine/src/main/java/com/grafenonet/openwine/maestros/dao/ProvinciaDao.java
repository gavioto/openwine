package com.grafenonet.openwine.maestros.dao;

import java.util.List;

import com.grafenonet.openwine.maestros.domain.Pais;
import com.grafenonet.openwine.maestros.domain.Provincia;

public interface ProvinciaDao {
	
	void create(Provincia provincia);
	
	void update(Provincia provincia);
	
	void delete(Integer id);
	
	List<Provincia> list();
	
	List<Provincia> list(Pais pais);
	
	List<Provincia> find(String codigo, String nombre, Pais pais);	

}
