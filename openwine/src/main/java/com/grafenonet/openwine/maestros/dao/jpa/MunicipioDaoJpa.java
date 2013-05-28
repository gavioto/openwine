package com.grafenonet.openwine.maestros.dao.jpa;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.dao.hibernate.GenericDaoJpa;
import com.grafenonet.openwine.maestros.dao.MunicipioDao;
import com.grafenonet.openwine.maestros.domain.Municipio;

@Repository("municipioDao")
public class MunicipioDaoJpa extends GenericDaoJpa<Municipio> implements MunicipioDao  {

	public MunicipioDaoJpa() {
		super(Municipio.class);
	}

}
