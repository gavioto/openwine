package com.grafenonet.openwine.cuaderno.dao.jpa;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.core.dao.hibernate.GenericDaoJpa;
import com.grafenonet.openwine.cuaderno.dao.VariedadDao;
import com.grafenonet.openwine.cuaderno.domain.Variedad;

@Repository("variedadDao")
public class VariedadDaoJpa extends GenericDaoJpa<Variedad> implements VariedadDao {

	public VariedadDaoJpa() {
		super(Variedad.class);
	}
	

}
