package com.grafenonet.openwine.maestros.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_provincia", nullable = false)
	private Integer idProvincia;
	
	@Column(name = "codigo", length = 2, unique = true, nullable = false)
	@NotEmpty
	@Length(max=2)	
	private String codigo;
	
	@Column(name = "nombre", length = 2, nullable = false)
	@NotEmpty
	@Length(max=250)	
	private String nombre;
	
	@JoinColumn(name = "id_pais")
	private Pais pais;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_concello", cascade = CascadeType.ALL)
	private List<Concello> concellos;

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

	public Integer getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Concello> getConcellos() {
		return concellos;
	}

	public void setConcellos(List<Concello> concellos) {
		this.concellos = concellos;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Usuario getUsuarioAlta() {
		return usuarioAlta;
	}

	public void setUsuarioAlta(Usuario usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Usuario getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(Usuario usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Usuario getUsuarioBaja() {
		return usuarioBaja;
	}

	public void setUsuarioBaja(Usuario usuarioBaja) {
		this.usuarioBaja = usuarioBaja;
	}

	@Override
	public String toString() {
		return "Provincia [idProvincia=" + idProvincia + ", codigo=" + codigo
				+ ", nombre=" + nombre + ", pais=" + pais + "]";
	}	
	
	
}
