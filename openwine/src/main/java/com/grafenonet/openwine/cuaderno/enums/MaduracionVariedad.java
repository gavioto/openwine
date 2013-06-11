package com.grafenonet.openwine.cuaderno.enums;

import java.util.Arrays;
import java.util.List;

public enum MaduracionVariedad {
	
	TEMPRANA("Temprana"),
	MEDIA("Media"),
	TARDIA("Tardía");
	
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private MaduracionVariedad(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static List<MaduracionVariedad> asList() {
		return Arrays.asList(MaduracionVariedad.values());
	}

}
