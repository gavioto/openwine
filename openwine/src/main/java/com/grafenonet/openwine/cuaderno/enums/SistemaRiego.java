package com.grafenonet.openwine.cuaderno.enums;

import java.util.Arrays;
import java.util.List;

public enum SistemaRiego {
	
	SECANO("Secano"),
	SUPERFICIE("Superficie"),
	GOTEO("Goteo"),
	MICROASPERSION("Microaspersión"),
	ASPERSION("Aspersión"),
	INFUSION("Infusión"),
	HODROPONICO("Hodropónico");

	private String descripcion;

	private SistemaRiego(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static List<SistemaRiego> asList() {
		return Arrays.asList(SistemaRiego.values());
	}
	
}
