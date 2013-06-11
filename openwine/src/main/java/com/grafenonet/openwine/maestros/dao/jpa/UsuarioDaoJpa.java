package com.grafenonet.openwine.maestros.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.core.dao.hibernate.GenericDaoJpa;
import com.grafenonet.openwine.maestros.dao.UsuarioDao;
import com.grafenonet.openwine.maestros.domain.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoJpa extends GenericDaoJpa<Usuario> implements UsuarioDao {
	
	public UsuarioDaoJpa() {
		super(Usuario.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario loadUserByUsername(String username) throws DataAccessException, EntityNotFoundException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		Query query = entityManager.createQuery("from Usuario u where u.fechaBaja is null and u.username = :username");
		query.setParameter("username", username);
		usuarios = query.getResultList();
		
		Usuario usuario = null;
		if (usuarios != null && usuarios.size() > 0) {
			usuario = usuarios.get(0);
		}
		return usuario;
	}

}
