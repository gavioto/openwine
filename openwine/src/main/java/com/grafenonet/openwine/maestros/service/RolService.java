package com.grafenonet.openwine.maestros.service;

import java.util.List;

import com.grafenonet.openwine.maestros.domain.Rol;

public interface RolService {
	
	Rol get(Integer id);
	List<Rol> list();
	
}
