package com.grafenonet.openwine.maestros.dao.jpa;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.core.dao.hibernate.GenericDaoJpa;
import com.grafenonet.openwine.maestros.dao.RolDao;
import com.grafenonet.openwine.maestros.domain.Rol;

@Repository("rolDao")
public class RolDaoJpa extends GenericDaoJpa<Rol> implements RolDao {

	public RolDaoJpa() {
		super(Rol.class);
	}

}
