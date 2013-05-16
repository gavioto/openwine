package com.grafenonet.openwine.maestros.domain;

import java.io.Serializable;
import java.util.Date;

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

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

//@Entity
//@Table(name = "Concello")
public class Concello implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_concello", nullable = false)
//	private Integer idConcello;
//	
//	@Column(name = "codigo", length = 3, unique = true, nullable = false)
//	@NotEmpty
//	@Length(max=3)	
//	private String codigo;
//	
//	@Column(name = "nombre", length = 250, nullable = false)
//	@NotEmpty
//	@Length(max=250)	
//	private String nombre;
//	
//	@JoinColumn(name = "provincia")
//	private Provincia provincia;
//
//	public Integer getIdConcello() {
//		return idConcello;
//	}
//
//	public void setIdConcello(Integer idConcello) {
//		this.idConcello = idConcello;
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
//	public Provincia getProvincia() {
//		return provincia;
//	}
//
//	public void setProvincia(Provincia provincia) {
//		this.provincia = provincia;
//	}
//
//	@Override
//	public String toString() {
//		return "Concello [idConcello=" + idConcello + ", codigo=" + codigo
//				+ ", nombre=" + nombre + ", provincia=" + provincia + "]";
//	}
	
	
}
