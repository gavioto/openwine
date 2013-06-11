package com.grafenonet.openwine.cuaderno.enums;

import java.util.Arrays;
import java.util.List;

public enum ConduccionPlantacion {
	ESPALDERA("Espaldera"),
	VASO("Vaso"),
	PARRAL("Parral");
	
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private ConduccionPlantacion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static List<ConduccionPlantacion> asList() {
		return Arrays.asList(ConduccionPlantacion.values());
	}
}
