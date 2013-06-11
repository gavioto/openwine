package com.grafenonet.openwine.cuaderno.enums;

import java.util.Arrays;
import java.util.List;

public enum EstadoParcela {
	
	PRODUCCION("Producción"),
	ABANDONADO("Abandonado"),
	DERECHOS("Derechos");
	
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private EstadoParcela(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static List<EstadoParcela> asList() {
		return Arrays.asList(EstadoParcela.values());
	}
	
}
