package com.grafenonet.openwine.cuaderno.enums;

import java.util.Arrays;
import java.util.List;

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
	
	public static List<CaracterExplotacion> asList() {
		return Arrays.asList(CaracterExplotacion.values());
	}
}
