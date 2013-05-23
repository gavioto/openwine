package com.grafenonet.openwine.caderno.enums;

public enum CaracterExplotacion {
	
	EMPRESARIAL("Empresarial"),
	FAMILIAR("Familiar");
	
	private String descripcion;

	private CaracterExplotacion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
