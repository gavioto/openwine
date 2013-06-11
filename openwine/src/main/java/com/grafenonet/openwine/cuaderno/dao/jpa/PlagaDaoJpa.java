package com.grafenonet.openwine.cuaderno.dao.jpa;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.core.dao.hibernate.GenericDaoJpa;
import com.grafenonet.openwine.cuaderno.dao.PlagaDao;
import com.grafenonet.openwine.cuaderno.domain.Plaga;

@Repository("plagaDao")
public class PlagaDaoJpa extends GenericDaoJpa<Plaga> implements PlagaDao {

	public PlagaDaoJpa() {
		super(Plaga.class);
	}

}
