package com.grafenonet.openwine.maestros.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@Table(name = "Pais")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pais", nullable = false)
	private Integer idPais;
	
	@Column(name = "codigo", length = 2, unique = true, nullable = false)
	@NotEmpty
	@Length(max=2)
	private String codigo;
	
	@Column(name = "nombre", length = 2, unique = true, nullable = false)
	@NotEmpty
	@Length(max=250)
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
	private List<Provincia> provincias;

	@Column(name = "fechaAlta", nullable = false)
	private Date fechaAlta;
	
	@Column(name = "usuarioAlta", nullable = false)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
	private Usuario usuarioAlta;	

	@Column(name = "fechaAlta", nullable = true)
	private Date fechaModificacion;
	
	@Column(name = "usuarioAlta", nullable = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
	private Usuario usuarioModificacion;	
	
	@Column(name = "fechaBaja", nullable = true)
	private Date fechaBaja;
	
	@Column(name = "usuarioBaja", nullable = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
	private Usuario usuarioBaja;

	public Integer getId() {
		return idPais;
	}

	public void setId(Integer id) {
		this.idPais = id;
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

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
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
		return "Pais [id=" + idPais + ", codigo=" + codigo + ", nombre=" + nombre
				+ "]";
	}
	
	
	
}
