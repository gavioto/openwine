package com.grafenonet.openwine.maestros.dao;

import java.util.List;

import com.grafenonet.openwine.core.dao.hibernate.IGenericDao;
import com.grafenonet.openwine.maestros.domain.Provincia;

public interface ProvinciaDao extends IGenericDao<Provincia> {
	
	List<Provincia> listByPais(Integer id);

}
