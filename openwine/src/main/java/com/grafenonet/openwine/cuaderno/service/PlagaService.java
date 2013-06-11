package com.grafenonet.openwine.cuaderno.service;

import java.util.List;

import com.grafenonet.openwine.cuaderno.domain.Plaga;

public interface PlagaService {

	public abstract void create(Plaga plaga);

	public abstract void update(Plaga plaga);

	public abstract void delete(Plaga plaga);

	public abstract Plaga get(Integer id);

	public abstract List<Plaga> list();

}