package com.grafenonet.openwine.caderno.enums;

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

}
