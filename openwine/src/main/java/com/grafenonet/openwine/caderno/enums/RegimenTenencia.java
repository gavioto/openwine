package com.grafenonet.openwine.caderno.enums;

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
	
}
