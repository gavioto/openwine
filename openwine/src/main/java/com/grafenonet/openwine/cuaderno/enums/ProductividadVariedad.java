package com.grafenonet.openwine.cuaderno.enums;

import java.util.Arrays;
import java.util.List;

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
	
	public static List<ProductividadVariedad> asList() {
		return Arrays.asList(ProductividadVariedad.values());
	}
	
}
