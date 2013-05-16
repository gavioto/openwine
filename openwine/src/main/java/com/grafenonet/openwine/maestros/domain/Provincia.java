package com.grafenonet.openwine.maestros.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

//@Entity
//@Table(name = "Provincia")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_provincia", nullable = false)
//	private Integer idProvincia;
//	
//	@Column(name = "codigo", length = 2, unique = true, nullable = false)
//	@NotEmpty
//	@Length(max=2)	
//	private String codigo;
//	
//	@Column(name = "nombre", length = 2, nullable = false)
//	@NotEmpty
//	@Length(max=250)	
//	private String nombre;
//	
//	@JoinColumn(name = "pais")
//	@NotNull
//	private Pais pais;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "provincia", cascade = CascadeType.ALL)
//	private Set<Concello> concellos;
//
//	public Integer getIdProvincia() {
//		return idProvincia;
//	}
//
//	public void setIdProvincia(Integer idProvincia) {
//		this.idProvincia = idProvincia;
//	}
//
//	public String getCodigo() {
//		return codigo;
//	}
//
//	public void setCodigo(String codigo) {
//		this.codigo = codigo;
//	}
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public Pais getPais() {
//		return pais;
//	}
//
//	public void setPais(Pais pais) {
//		this.pais = pais;
//	}

//	public Set<Concello> getConcellos() {
//		return concellos;
//	}
//
//	public void setConcellos(Set<Concello> concellos) {
//		this.concellos = concellos;
//	}

//	@Override
//	public String toString() {
//		return "Provincia [idProvincia=" + idProvincia + ", codigo=" + codigo
//				+ ", nombre=" + nombre + ", pais=" + pais + "]";
//	}	
	
	
}
