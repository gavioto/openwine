package com.grafenonet.openwine.caderno.dao.jpa;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.caderno.dao.ViticultorDao;
import com.grafenonet.openwine.caderno.domain.Viticultor;
import com.grafenonet.openwine.dao.hibernate.GenericDaoJpa;

@Repository("viticultorDao")
public class ViticultorDaoJpa extends GenericDaoJpa<Viticultor> implements ViticultorDao {

	public ViticultorDaoJpa() {
		super(Viticultor.class);
	}
	
}
