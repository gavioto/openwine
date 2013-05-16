package com.grafenonet.openwine.maestros.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.maestros.dao.RolDao;
import com.grafenonet.openwine.maestros.domain.Rol;

@Repository
public class RolDaoImpl implements RolDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		if (this.sessionFactory == null) {
			throw new IllegalStateException("SessionFactory no inicializada.");
		}
		return this.sessionFactory.getCurrentSession();
	}
	

	@Override
	public Rol getRol(Long id) {
		Rol rol = (Rol) getCurrentSession().load(Rol.class, id);
		return rol;
	}

}
