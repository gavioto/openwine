package com.grafenonet.openwine.cuaderno.enums;

import java.util.Arrays;
import java.util.List;

public enum CalificacionVariedad {
	
	NO_AUTORIZADA("No Autorizada"),
	AUTORIZADA("Autorizada"),
	PRINCIPAL("Principal"),
	PREFERENTE("Preferente");
	
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private CalificacionVariedad(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static List<CalificacionVariedad> asList() {
		return Arrays.asList(CalificacionVariedad.values());
	}

}
