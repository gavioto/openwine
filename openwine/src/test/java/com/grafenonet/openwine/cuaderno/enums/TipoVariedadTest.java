package com.grafenonet.openwine.cuaderno.enums;

import static org.junit.Assert.*;

import org.junit.Test;

public class TipoVariedadTest {

	@Test
	public void test() {
		TipoVariedad tipo = TipoVariedad.fromString("Blanca");
		assertNotNull(tipo);
		
		assertTrue(TipoVariedad.BLANCA.equals(TipoVariedad.valueOf("Blanca")));
		assertTrue(TipoVariedad.TINTA.equals(TipoVariedad.valueOf("Tinta")));
	}

}
