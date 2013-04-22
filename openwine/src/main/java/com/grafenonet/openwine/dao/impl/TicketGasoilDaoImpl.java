package com.grafenonet.openwine.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grafenonet.openwine.dao.TicketGasoilDao;
import com.grafenonet.openwine.domain.TicketGasoil;

@Repository
public class TicketGasoilDaoImpl implements TicketGasoilDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void save(TicketGasoil ticketGasoil) {
		//sessionFactory.getCurrentSession().save(ticketGasoil);	
		this.getSession().save(ticketGasoil);
	}

	@Override
	public List<TicketGasoil> findAll(Integer year) {
		if (year != null) {
			String query = "from TicketGasoil where year(fecha) = :p_year order by fecha desc";		
			return this.getSession().createQuery(query).setParameter("p_year", year).list();
		} else {
			String query = "from TicketGasoil order by fecha desc";	
			return this.getSession().createQuery(query).list();
		}
	}

	@Override
	public TicketGasoil findResume(int year) {
		TicketGasoil ticket = null;
		StringBuilder query = new StringBuilder();
		query.append("select sum(importe) as importe, sum(litros) as litros " +
				"from TicketGasoil " +
				"where year(fecha) = :p_year ");

		List<TicketGasoil> lista = getSession().createQuery(query.toString()).setParameter(":p_year", year).list();
		if (lista != null && !lista.isEmpty()) {
			ticket = lista.get(0);
		}
		return ticket;
	}

	@Override
	public void update(TicketGasoil ticketGasoil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer idTicketGasoil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TicketGasoil find(Integer idTicketGasoil) {
		// TODO Auto-generated method stub
		return null;
	}

}
