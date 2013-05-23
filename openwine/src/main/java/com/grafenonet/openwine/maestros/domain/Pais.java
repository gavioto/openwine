package com.grafenonet.openwine.maestros.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "pais")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pais", nullable = false)
	private Integer id;
	
	@Column(name = "codigo", length = 2, unique = true, nullable = false)
	@NotEmpty(message = "Campo 'codigo' no especificado.")
	@Length(max=2)
	private String codigo;
	
	@Column(name = "nombre", length = 2, unique = true, nullable = false)
	@NotEmpty(message = "Campo 'nombre' no especificado.")
	@Length(max=250)
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pais", cascade = CascadeType.ALL)
	private Set<Provincia> provincias;

	public Integer getIdPais() {
		return id;
	}

	public void setIdPais(Integer id) {
		this.id = id;
	}

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
		return "Pais [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre
				+ "]";
	}
	
	
	
}
