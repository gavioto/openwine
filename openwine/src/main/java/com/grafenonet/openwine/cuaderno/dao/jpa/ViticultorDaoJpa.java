package com.grafenonet.openwine.cuaderno.dao.jpa;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.core.dao.hibernate.GenericDaoJpa;
import com.grafenonet.openwine.cuaderno.dao.ViticultorDao;
import com.grafenonet.openwine.cuaderno.domain.Viticultor;

@Repository("viticultorDao")
public class ViticultorDaoJpa extends GenericDaoJpa<Viticultor> implements ViticultorDao {

	public ViticultorDaoJpa() {
		super(Viticultor.class);
	}
	
}
