package com.grafenonet.openwine.dao.hibernate;

import java.util.List;

import org.hibernate.exception.DataException;

import com.grafenonet.openwine.domain.IGenericDomain;

public interface IGenericDao<T extends IGenericDomain> {
	
	public void save(T object) throws DataException;
	public T get(Integer id) throws DataException;
	public List<T> list() throws DataException;

}
