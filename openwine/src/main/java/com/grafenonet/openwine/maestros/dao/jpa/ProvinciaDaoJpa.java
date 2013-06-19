package com.grafenonet.openwine.maestros.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.core.dao.hibernate.GenericDaoJpa;
import com.grafenonet.openwine.maestros.dao.ProvinciaDao;
import com.grafenonet.openwine.maestros.domain.Provincia;

@Repository("provinciaDao")
public class ProvinciaDaoJpa extends GenericDaoJpa<Provincia> implements ProvinciaDao  {

	public ProvinciaDaoJpa() {
		super(Provincia.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> listByPais(Integer id) {
		List<Provincia> lista = new ArrayList<Provincia>();
		
		Query query = entityManager.createQuery("from Provincia p where p.fechaBaja is null and p.pais = :pais");
		query.setParameter("pais", id);
		lista = query.getResultList();
		
		return lista;
	}

}
