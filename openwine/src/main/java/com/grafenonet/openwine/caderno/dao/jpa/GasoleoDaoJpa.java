package com.grafenonet.openwine.caderno.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.caderno.dao.GasoleoDao;
import com.grafenonet.openwine.caderno.domain.Gasoleo;
import com.grafenonet.openwine.maestros.domain.Usuario;

@Repository("gasoleoDao")
public class GasoleoDaoJpa implements GasoleoDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		if (this.sessionFactory == null) {
			throw new IllegalStateException("SessionFactory no inicializada.");
		}
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Gasoleo gasoleo) {	
		this.getCurrentSession().save(gasoleo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gasoleo> findAll(Integer year) {
		List<Gasoleo> tickets = new ArrayList<Gasoleo>();
		if (year != null) {
			Query query = getCurrentSession().createQuery("from Gasoleo where year(fecha) = :p_year and fechaBaja is null order by fecha desc");
			query.setParameter("p_year", year);
			tickets = query.list();
		} else {
			Query query = getCurrentSession().createQuery("from Gasoleo where fechaBaja is null order by fecha desc");					
			tickets = query.list();
		}
		return tickets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Gasoleo findResume(int year) {
		List<Gasoleo> lista = new ArrayList<Gasoleo>();
		Gasoleo ticket = null;		
		
		String  sql = "select sum(importe) as importe, sum(litros) as litros " +
				"from Gasoleo " +
				"where year(fecha) = :p_year and fechaBaja is null ";
		Query query = getCurrentSession().createQuery(sql);
		query.setParameter("p_year", year);

		lista = query.list();
		if (lista != null && !lista.isEmpty()) {
			ticket = lista.get(0);
		}
		return ticket;
	}

	@Override
	public void update(Gasoleo gasoleo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Gasoleo find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
