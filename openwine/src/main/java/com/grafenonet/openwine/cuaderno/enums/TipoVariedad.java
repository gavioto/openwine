package com.grafenonet.openwine.cuaderno.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TipoVariedad {
	BLANCA("Blanca"),
	TINTA("Tinta");
	
	TipoVariedad() {		
	}
	
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
	
	private static Map< String, TipoVariedad > stringToEnum = new HashMap< String, TipoVariedad >();
	
    static {
        for (TipoVariedad tipo : TipoVariedad.values()) {
        	TipoVariedad.stringToEnum.put( tipo.toString(), tipo );
        }
    }
    
    public static TipoVariedad fromString(String value) {
        return TipoVariedad.stringToEnum.get(value);
    }
    
    @Override
    public String toString() {
    	return this.descripcion;
    }

}
