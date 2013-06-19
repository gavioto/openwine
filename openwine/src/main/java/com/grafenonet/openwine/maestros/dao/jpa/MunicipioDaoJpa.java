package com.grafenonet.openwine.maestros.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.core.dao.hibernate.GenericDaoJpa;
import com.grafenonet.openwine.maestros.dao.MunicipioDao;
import com.grafenonet.openwine.maestros.domain.Municipio;

@Repository("municipioDao")
public class MunicipioDaoJpa extends GenericDaoJpa<Municipio> implements MunicipioDao  {

	public MunicipioDaoJpa() {
		super(Municipio.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Municipio> listByProvincia(Integer id) {
		List<Municipio> lista = new ArrayList<Municipio>();
		
		Query query = entityManager.createQuery("from Municipio m where m.fechaBaja is null and m.provincia = :provincia");
		query.setParameter("provincia", id);
		lista = query.getResultList();
		
		return lista;
	}

}
