package com.grafenonet.openwine.cuaderno.dao.jpa;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.core.dao.hibernate.GenericDaoJpa;
import com.grafenonet.openwine.cuaderno.dao.GasoleoDao;
import com.grafenonet.openwine.cuaderno.domain.Gasoleo;

@Repository("gasoleoDao")
public class GasoleoDaoJpa extends GenericDaoJpa<Gasoleo> implements GasoleoDao {

	public GasoleoDaoJpa() {
		super(Gasoleo.class);
	}

}
