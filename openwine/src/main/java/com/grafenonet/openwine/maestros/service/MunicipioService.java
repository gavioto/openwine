package com.grafenonet.openwine.maestros.service;

import java.util.List;

import com.grafenonet.openwine.maestros.domain.Municipio;

public interface MunicipioService {

	public abstract void create(Municipio municipio);

	public abstract void update(Municipio municipio);

	public abstract void delete(Municipio municipio);

	public abstract Municipio get(Integer id);

	public abstract List<Municipio> list();

}