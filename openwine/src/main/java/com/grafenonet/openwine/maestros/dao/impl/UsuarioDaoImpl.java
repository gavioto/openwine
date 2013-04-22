package com.grafenonet.openwine.maestros.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.maestros.dao.UsuarioDao;
import com.grafenonet.openwine.maestros.domain.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}	

	@Override
	public void create(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
