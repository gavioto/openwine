package com.grafenonet.openwine.caderno.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.grafenonet.openwine.caderno.domain.Gasoleo;

public interface GasoleoDao {
	
	public void save(Gasoleo gasoleo) throws DataAccessException;
	
	public void update(Gasoleo gasoleo) throws DataAccessException;
	
	public void delete(Integer id) throws DataAccessException;
	
	public Gasoleo find(Integer id) throws DataAccessException;
	
	public List<Gasoleo> findAll(Integer year) throws DataAccessException;
	
	public Gasoleo findResume(int year) throws DataAccessException;
		

}
