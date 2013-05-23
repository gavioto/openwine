package com.grafenonet.openwine.caderno.enums;

public enum ProductividadVariedad {
	
	ALTA("Alta"),
	MEDIA("Media"),
	BAJA("Baja");

	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private ProductividadVariedad(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
