package com.grafenonet.openwine.cuaderno.dao.jpa;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.core.dao.hibernate.GenericDaoJpa;
import com.grafenonet.openwine.cuaderno.dao.TecnicoDao;
import com.grafenonet.openwine.cuaderno.domain.Tecnico;

@Repository("tecnicoDao")
public class TecnicoDaoJpa extends GenericDaoJpa<Tecnico> implements TecnicoDao {

	public TecnicoDaoJpa() {
		super(Tecnico.class);
	}

}
