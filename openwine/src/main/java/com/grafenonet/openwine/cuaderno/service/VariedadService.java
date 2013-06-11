package com.grafenonet.openwine.cuaderno.service;

import java.util.List;

import com.grafenonet.openwine.cuaderno.domain.Variedad;

public interface VariedadService {

	public abstract void create(Variedad variedad);

	public abstract void update(Variedad variedad);

	public abstract void delete(Variedad variedad);

	public abstract Variedad get(Integer id);

	public abstract List<Variedad> list();

}