package com.grafenonet.openwine.caderno.enums;

public enum TipoAbono {
	
	ORGANICO("Orgánico"),
	INORGANICO("Inorgánico");
	
	private String descripcion;
	
	public String getIdTipoAbono() {
		return descripcion;
	}

	public void setIdTipoAbono(String descripcion) {
		this.descripcion = descripcion;
	}

	private TipoAbono(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
