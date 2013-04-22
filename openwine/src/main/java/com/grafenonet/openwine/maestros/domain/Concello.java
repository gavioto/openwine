package com.grafenonet.openwine.maestros.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Concello implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_concello", nullable = false)
	private Integer idConcello;
	
	@Column(name = "codigo", length = 2, unique = true, nullable = false)
	@NotEmpty
	@Length(max=2)	
	private String codigo;
	
	@Column(name = "nombre", length = 2, nullable = false)
	@NotEmpty
	@Length(max=250)	
	private String nombre;
	
	@JoinColumn(name = "id_provincia")
	private Provincia provincia;

	@Column(name = "fecha_alta", nullable = false)
	private Date fechaAlta;
	
	@Column(name = "usuario_alta", nullable = false)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
	private Usuario usuarioAlta;	

	@Column(name = "fecha_modificacion", nullable = true)
	private Date fechaModificacion;
	
	@Column(name = "usuario_modificacion", nullable = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
	private Usuario usuarioModificacion;	
	
	@Column(name = "fecha_baja", nullable = true)
	private Date fechaBaja;
	
	@Column(name = "usuario_baja", nullable = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
	private Usuario usuarioBaja;

	public Integer getIdConcello() {
		return idConcello;
	}

	public void setIdConcello(Integer idConcello) {
		this.idConcello = idConcello;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Usuario getUsuarioAlta() {
		return usuarioAlta;
	}

	public void setUsuarioAlta(Usuario usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	public Usuario getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(Usuario usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Usuario getUsuarioBaja() {
		return usuarioBaja;
	}

	public void setUsuarioBaja(Usuario usuarioBaja) {
		this.usuarioBaja = usuarioBaja;
	}

	@Override
	public String toString() {
		return "Concello [idConcello=" + idConcello + ", codigo=" + codigo
				+ ", nombre=" + nombre + ", provincia=" + provincia + "]";
	}
	
	
}
