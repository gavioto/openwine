package com.grafenonet.openwine.core.dao.hibernate;

import java.util.List;

import org.hibernate.exception.DataException;

import com.grafenonet.openwine.core.domain.BaseEntity;

// IGenericDomain
public interface IGenericDao<T extends BaseEntity> {
	
	public void create(T object) throws DataException;
	public void update(T object) throws DataException;
	public void delete(T object) throws DataException;
	public T get(Integer id) throws DataException;
	public List<T> list() throws DataException;

}
