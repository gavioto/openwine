package com.grafenonet.openwine.cuaderno.enums;

import java.util.Arrays;
import java.util.List;

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
	
	public static List<TipoAbono> asList() {
		return Arrays.asList(TipoAbono.values());
	}
	
}
