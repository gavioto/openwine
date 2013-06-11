package com.grafenonet.openwine.maestros.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.grafenonet.openwine.core.domain.BaseEntity;

@Entity
@Table(name = "rol")
public class Rol extends BaseEntity implements Serializable, Comparable<Rol> {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nombre", length=20, unique=true, nullable = false)
	@NotEmpty(message = "Campo 'role' no especificado.")
	@Length(min = 2, max = 20)	
	private String nombre;
		

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Rol [id=" + getId() + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public int compareTo(Rol o) {
		if (this.nombre.compareTo(o.getNombre()) != 0) {
			return this.nombre.compareTo(o.getNombre());
		}
		if (this.getId() == null) {
			return -1;
		}
		if (o.getId() == null) {
			return -1;
		}
		return this.getId().compareTo(o.getId());
	}
	
	
		
}
