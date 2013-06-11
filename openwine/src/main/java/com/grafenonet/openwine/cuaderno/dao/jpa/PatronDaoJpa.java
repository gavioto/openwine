package com.grafenonet.openwine.cuaderno.dao.jpa;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.core.dao.hibernate.GenericDaoJpa;
import com.grafenonet.openwine.cuaderno.dao.PatronDao;
import com.grafenonet.openwine.cuaderno.domain.Patron;

@Repository("patronDao")
public class PatronDaoJpa extends GenericDaoJpa<Patron> implements PatronDao {

	public PatronDaoJpa() {
		super(Patron.class);
	}

}
