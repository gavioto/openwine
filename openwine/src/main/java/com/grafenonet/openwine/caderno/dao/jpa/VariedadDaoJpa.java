package com.grafenonet.openwine.caderno.dao.jpa;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.caderno.dao.VariedadDao;
import com.grafenonet.openwine.caderno.domain.Variedad;
import com.grafenonet.openwine.dao.hibernate.GenericDaoJpa;

@Repository("variedadDao")
public class VariedadDaoJpa extends GenericDaoJpa<Variedad> implements VariedadDao {

	public VariedadDaoJpa() {
		super(Variedad.class);
	}
	

}
