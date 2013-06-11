package com.grafenonet.openwine.core.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grafenonet.openwine.core.domain.BaseEntity;

public abstract class GenericDaoJpa<T extends BaseEntity> implements IGenericDao<T>{
	private static Logger LOG = LoggerFactory.getLogger(GenericDaoJpa.class);
	
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
	public void create(T object) throws DataException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Iniciando create ...");
			LOG.debug(" - objeto = " + object.toString());
		}
		
		object.setFechaAlta(new Date());
		object.setUsuarioAlta("admin");
		
		this.getEntityManager().persist(object);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Finalizando create.");
		}				
	}
	
	@Override
	public void update(T object) throws DataException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Iniciando update ...");
			LOG.debug(" - objeto = " + object.toString());
		}
		
		T older = get(object.getId());
		if (older == null) {
			throw new RuntimeException("Elemento no encontrado.");
		}
		object.setFechaAlta(older.getFechaAlta());
		object.setUsuarioAlta(older.getUsuarioAlta());		
		
		object.setFechaModificacion(new Date());
		object.setUsuarioModificacion("admin");
		
		this.getEntityManager().merge(object);
		this.getEntityManager().flush();
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Finalizando update.");
		}		
	}
	
	@Override
	public void delete(T object) throws DataException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Iniciando delete ...");
			LOG.debug(" - objeto = " + object.toString());
		}
		
		T older = get(object.getId());
		if (older == null) {
			throw new RuntimeException("Elemento no encontrado.");
		}
		object.setFechaAlta(older.getFechaAlta());
		object.setUsuarioAlta(older.getUsuarioAlta());
		object.setFechaModificacion(older.getFechaModificacion());
		object.setUsuarioModificacion(older.getUsuarioModificacion());
		
		object.setFechaBaja(new Date());
		object.setUsuarioBaja("admin");
		
		this.getEntityManager().merge(object);
		this.getEntityManager().flush();
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Finalizando delete.");
		}		
	}

	@Override
	public T get(Integer id) throws DataException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Iniciando get ...");
			LOG.debug(" - objeto = " + type.getName());
			LOG.debug(" - id = " + id);
		}
		
		T t = null;
		
		if (id != null) {
			t = (T) this.getEntityManager().find(type, id);
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - T = " + t == null ? "null" : t.toString());
			LOG.debug("Finalizando get.");
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() throws DataException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Iniciando list ...");
			LOG.debug(" - objeto = " + type.getName());
		}
		
		List<T> resultado = new ArrayList<T>();
		
		Query query = this.getEntityManager().createQuery("select o from " + type.getName() + " o where o.fechaBaja is null");
		resultado = query.getResultList();
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - numero de registros = " + resultado.size());
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Finalizando list.");
		}
		return resultado;
	}

}
