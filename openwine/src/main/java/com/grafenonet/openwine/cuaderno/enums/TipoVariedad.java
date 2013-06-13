package com.grafenonet.openwine.cuaderno.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public enum TipoVariedad {

	BLANCA("Blanca"),
	TINTA("Tinta");
	

	
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private TipoVariedad(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static List<TipoVariedad> asList() {
		return Arrays.asList(TipoVariedad.values());
	}

}
