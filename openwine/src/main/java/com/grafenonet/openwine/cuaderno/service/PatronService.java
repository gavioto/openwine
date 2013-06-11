package com.grafenonet.openwine.cuaderno.service;

import java.util.List;

import com.grafenonet.openwine.cuaderno.domain.Patron;

public interface PatronService {

	public abstract void create(Patron patron);

	public abstract void update(Patron patron);

	public abstract void delete(Patron patron);

	public abstract Patron get(Integer id);

	public abstract List<Patron> list();

}