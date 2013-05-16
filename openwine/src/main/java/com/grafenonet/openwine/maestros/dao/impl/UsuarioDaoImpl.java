package com.grafenonet.openwine.maestros.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.maestros.dao.UsuarioDao;
import com.grafenonet.openwine.maestros.domain.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		if (this.sessionFactory == null) {
			throw new IllegalStateException("SessionFactory no inicializada.");
		}
		return this.sessionFactory.getCurrentSession();
	}
		
	
	@Override
	public void create(Usuario usuario) throws DataAccessException {
		getCurrentSession().save(usuario);
		if (usuario.getId() == null) {
			throw new RuntimeException("No se ha podido crear el usuario: " + usuario.toString());
		}
	}

	@Override
	public void update(Usuario usuario) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> list() throws DataAccessException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Query query = getCurrentSession().createQuery("from Usuario");				
		usuarios = query.list();
		return usuarios;
	}

	@Override
	public Usuario get(Integer id) throws DataAccessException {
		return (Usuario) getCurrentSession().get(Usuario.class, id);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Usuario loadUserByUsername(String username) throws DataAccessException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Query query = getCurrentSession().createQuery("from Usuario u where u.fechaBaja is null and u.username = :username");
		query.setParameter("username", username);
		usuarios = query.list();
		
		Usuario usuario = null;
		if (usuarios != null && usuarios.size() > 0) {
			usuario = usuarios.get(0);
		}
		return usuario;
	}

}
