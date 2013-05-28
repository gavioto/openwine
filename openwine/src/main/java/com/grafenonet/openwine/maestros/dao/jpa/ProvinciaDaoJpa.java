package com.grafenonet.openwine.maestros.dao.jpa;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.dao.hibernate.GenericDaoJpa;
import com.grafenonet.openwine.maestros.dao.ProvinciaDao;
import com.grafenonet.openwine.maestros.domain.Provincia;

@Repository("provinciaDao")
public class ProvinciaDaoJpa extends GenericDaoJpa<Provincia> implements ProvinciaDao  {

	public ProvinciaDaoJpa() {
		super(Provincia.class);
	}

}
