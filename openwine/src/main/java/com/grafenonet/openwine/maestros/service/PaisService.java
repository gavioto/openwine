package com.grafenonet.openwine.maestros.service;

import java.util.List;

import com.grafenonet.openwine.maestros.domain.Pais;

public interface PaisService {

	public abstract void create(Pais pais);

	public abstract void update(Pais pais);

	public abstract void delete(Pais pais);

	public abstract Pais get(Integer id);

	public abstract List<Pais> list();

}