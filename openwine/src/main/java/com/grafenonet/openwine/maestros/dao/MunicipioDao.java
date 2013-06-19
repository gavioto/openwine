package com.grafenonet.openwine.maestros.dao;

import java.util.List;

import com.grafenonet.openwine.core.dao.hibernate.IGenericDao;
import com.grafenonet.openwine.maestros.domain.Municipio;

public interface MunicipioDao extends IGenericDao<Municipio> {
	
	List<Municipio> listByProvincia(Integer id);

}
