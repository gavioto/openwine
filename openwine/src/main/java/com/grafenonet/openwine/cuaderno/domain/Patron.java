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
@Table(name="patron")
public class Patron extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;	
	
	@Column(name = "nombre", length = 100, unique=true, nullable = false)
	@NotEmpty(message = "web.validate.campo_obligatorio")
	@Length(max=100)	
	@Size(min = 4, max = 100, message="web.validate.tamano_campo")
	private String nombre;

	@Column(name = "descripcion", length = 2000, nullable = false)
	@NotEmpty(message = "web.validate.campo_obligatorio")
	@Length(max=2000)	
	@Size(min = 4, max = 2000, message="web.validate.tamano_campo")
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
		return "Patron [id=" + getId() + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}
	
}
