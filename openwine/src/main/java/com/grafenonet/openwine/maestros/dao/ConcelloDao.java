package com.grafenonet.openwine.maestros.dao;

import java.util.List;

import com.grafenonet.openwine.maestros.domain.Provincia;

public interface ConcelloDao {
	
	void create(ConcelloDao concello);
	
	void update(ConcelloDao concello);
	
	void delete(Integer id);
	
	List<ConcelloDao> list();
	
	List<ConcelloDao> list(Provincia provincia);
	
	List<ConcelloDao> find(String codigo, String nombre, Provincia provincia);

}
