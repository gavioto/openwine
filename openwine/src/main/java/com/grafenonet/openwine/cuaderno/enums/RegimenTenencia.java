package com.grafenonet.openwine.cuaderno.enums;

import java.util.Arrays;
import java.util.List;

public enum RegimenTenencia {

	PROPIEDAD("Propiedad"),
	ARRENDAMIENTO("Arrendamiento"),
	OTROS("Otros");
	
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private RegimenTenencia(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static List<RegimenTenencia> asList() {
		return Arrays.asList(RegimenTenencia.values());
	}
	
}
