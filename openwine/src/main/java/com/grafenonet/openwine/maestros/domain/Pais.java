package com.grafenonet.openwine.maestros.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.grafenonet.openwine.core.domain.BaseEntity;

@Entity
@Table(name = "pais")
public class Pais extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "codigo", length = 2, unique = true, nullable = false)
	@NotEmpty(message = "web.validate.campo_obligatorio")
	@Length(max=2, message = "web.validate.tamano_maximo")
	private String codigo;
	
	@Column(name = "nombre", length = 250, unique = true, nullable = false)
	@NotEmpty(message = "web.validate.campo_obligatorio")
	@Length(max=250, message = "web.validate.tamano_maximo")
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pais", cascade = CascadeType.ALL)
	private Set<Provincia> provincias;	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(Set<Provincia> provincias) {
		this.provincias = provincias;
	}
	
	@Override
	public String toString() {
		return "Pais [id=" + getId() + ", codigo=" + codigo + ", nombre=" + nombre
				+ "]";
	}
	
	
	
}
