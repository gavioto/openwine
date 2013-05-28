package com.grafenonet.openwine.maestros.service;

import java.util.List;

import com.grafenonet.openwine.maestros.domain.Provincia;

public interface ProvinciaService {

	public abstract void create(Provincia provincia);

	public abstract void update(Provincia provincia);

	public abstract void delete(Provincia provincia);

	public abstract Provincia get(Integer id);

	public abstract List<Provincia> list();

}