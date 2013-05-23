package com.grafenonet.openwine.caderno.enums;

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
	
}
