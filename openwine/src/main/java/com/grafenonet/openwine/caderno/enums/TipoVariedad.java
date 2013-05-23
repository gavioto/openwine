package com.grafenonet.openwine.caderno.enums;

public enum TipoVariedad {
	BLANCA("Blanca"),
	TINTA("Tinta");
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private TipoVariedad(String description) {
		this.description = description;
	}

}
