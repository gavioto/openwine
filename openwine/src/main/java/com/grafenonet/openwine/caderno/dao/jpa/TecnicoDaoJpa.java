package com.grafenonet.openwine.caderno.dao.jpa;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.caderno.dao.TecnicoDao;
import com.grafenonet.openwine.caderno.domain.Tecnico;
import com.grafenonet.openwine.dao.hibernate.GenericDaoJpa;

@Repository("tecnicoDao")
public class TecnicoDaoJpa extends GenericDaoJpa<Tecnico> implements TecnicoDao {

	public TecnicoDaoJpa() {
		super(Tecnico.class);
	}

}
