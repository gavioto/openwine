package com.grafenonet.openwine.caderno.enums;

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

}
