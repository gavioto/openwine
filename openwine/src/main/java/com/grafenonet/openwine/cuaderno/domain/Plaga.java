package com.grafenonet.openwine.cuaderno.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.grafenonet.openwine.core.domain.BaseEntity;

@Entity
@Table(name="plaga")
public class Plaga extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "nombre", length = 100, unique=true, nullable = false)
	@NotEmpty(message = "Campo 'nombre' no especificado.")
	@Length(max=100)	
	@Size(min = 4, max = 100)
	private String nombre;

	@Column(name = "descripcion", length = 2000, nullable = false)
	@NotEmpty(message = "Campo 'descripcion' no especificado.")
	@Length(max=2000)	
	@Size(min = 4, max = 2000)
	private String descripcion;	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Plaga [id=" + getId() + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}	
}
