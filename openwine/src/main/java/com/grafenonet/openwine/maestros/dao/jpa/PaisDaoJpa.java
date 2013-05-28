package com.grafenonet.openwine.maestros.dao.jpa;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.dao.hibernate.GenericDaoJpa;
import com.grafenonet.openwine.maestros.dao.PaisDao;
import com.grafenonet.openwine.maestros.domain.Pais;

@Repository("paisDao")
public class PaisDaoJpa extends GenericDaoJpa<Pais> implements PaisDao {

	public PaisDaoJpa() {
		super(Pais.class);
	}
	
	

}
