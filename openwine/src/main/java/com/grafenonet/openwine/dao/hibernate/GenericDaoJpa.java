package com.grafenonet.openwine.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.exception.DataException;

import com.grafenonet.openwine.domain.IGenericDomain;

public class GenericDaoJpa<T extends IGenericDomain> implements IGenericDao<T>{

	private Class<T> type;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	private EntityManager getEntityManager() {
		if (this.entityManager == null) {
			throw new IllegalStateException("'EntityManager' no inicializada.");
		}
		return this.entityManager;
	}
	
	public GenericDaoJpa(Class<T> type) {
		super();
		this.type = type;
	}
	
	@Override
	public void save(T object) throws DataException {
		this.getEntityManager().persist(object);
	}

	@Override
	public T get(Integer id) throws DataException {
		if (id == null) {
			return null;
		} else {
			return (T) getEntityManager().find(type, id);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() throws DataException {
		List<T> resultado = new ArrayList<T>();
		
		Query query = this.getEntityManager().createQuery("select o from " + type.getName() + " o where o.fecha_baja is null");
		resultado = query.getResultList();
		
		return resultado;
	}

}
