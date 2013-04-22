package com.grafenonet.openwine.maestros.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.maestros.dao.PaisDao;
import com.grafenonet.openwine.maestros.domain.Pais;

@Repository
public class PaisDaoImpl implements PaisDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();		
	}	

	@Override
	public void create(Pais pais) {
		this.getSession().save(pais);
	}

	@Override
	public void update(Pais pais) {
		
		
	}

	@Override
	public void delete(Integer id) {
		String query = "Pais set fecha_baja = :p_fecha_baja where id_pais = :id_pais";
		Query q = this.getSession().createQuery(query);
		q.setParameter(":p_fecha_baja", new Date());
		q.setParameter(":p_id_pais", id);
		q.executeUpdate();
	}
	

	@Override
	public List<Pais> list() {
		String query = "from Pais where order by codigo asc, nombre asc";		
		return this.getSession().createQuery(query).list();
	}

	@Override
	public List<Pais> find(String codigo, String nombre) {
		Pais pais = new Pais();
		pais.setCodigo(codigo);
		pais.setNombre(nombre);
				
		String query = "from Pais";
		String queryWhere = "";
		if (codigo != null) {
			queryWhere = " codigo = :p_codigo";
		}
		if (nombre != null) {
			if (queryWhere != null) {
				queryWhere += " AND";
			}
			queryWhere += " nombre = :p_nombre";
		}
		if (queryWhere != null) {
			query += " WHERE" + queryWhere;
		}
		query += " order by codigo asc, nombre asc";
		
		return this.getSession().createQuery(query).setProperties(pais).list();
	}

	@Override
	public Pais getById(Integer id) {
		String query = "from Pais where id_pais = :p_id_pais";
		List<Pais> resultado =  this.getSession().createQuery(query).setParameter("p_id_pais", id).list();
		if (resultado != null && !resultado.isEmpty()) {
			return resultado.get(0);
		}
		return null;
	}

}
