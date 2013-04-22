package com.grafenonet.openwine.service;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.grafenonet.openwine.domain.TicketGasoil;

public class TicketGasoilServiceTest {
	
	@Autowired
	TicketGasoilService service;

	private Calendar calendar = Calendar.getInstance();
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void findAllTest() {
		List<TicketGasoil> lista = service.findAll(calendar.get(Calendar.YEAR));
		Assert.assertTrue(lista != null && !lista.isEmpty());
	}

}
