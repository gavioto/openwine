package com.grafenonet.openwine.caderno.enums;

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
	
}
