package com.grafenonet.openwine.caderno.enums;

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

}