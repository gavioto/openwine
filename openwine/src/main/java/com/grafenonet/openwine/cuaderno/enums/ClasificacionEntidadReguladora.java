package com.grafenonet.openwine.cuaderno.enums;

import java.util.Arrays;
import java.util.List;

public enum ClasificacionEntidadReguladora {
	
	DENOMINACION_ORIGEN("Denominación de Origen"),
	VINO_TIERRA("Vino de la Tierra"),
	VINO_MESA("Vino de Mesa");
	
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private ClasificacionEntidadReguladora(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static List<ClasificacionEntidadReguladora> asList() {
		return Arrays.asList(ClasificacionEntidadReguladora.values());
	}

}