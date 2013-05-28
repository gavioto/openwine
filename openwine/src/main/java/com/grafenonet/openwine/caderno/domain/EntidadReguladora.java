package com.grafenonet.openwine.caderno.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.grafenonet.openwine.caderno.enums.ClasificacionEntidadReguladora;
import com.grafenonet.openwine.domain.IGenericDomain;
import com.grafenonet.openwine.maestros.domain.Municipio;

@Entity
@Table(name="entidad_reguladora")
public class EntidadReguladora implements Serializable, IGenericDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_entidad_reguladora", nullable = false)
	private Integer id;
	
	@Column(name = "nombre", length = 100, nullable = false)
	@NotEmpty(message = "Campo 'nombre' no especificado.")
	@Length(max=100)	
	@Size(min = 4, max = 100, message = "El campo 'nombre' debe tener entre 4 y 100 caracteres")
	private String nombre;

	@Column(name = "descripcion", length = 2000, nullable = false)
	@NotEmpty(message = "Campo 'descripcion' no especificado.")
	@Length(max=2000)	
	@Size(min = 4, max = 2000, message = "El campo 'descripción' debe tener entre 4 y 2000 caracteres")
	private String descripcion;	
	
	@Column(name = "clasificacion", length=40, nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'clasificacion' no especificado.")
	@Enumerated(EnumType.STRING)
	private ClasificacionEntidadReguladora clasificacion;
	
	@Column(name = "anho_designacion", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'año designación' no especificado.")	
	@Min(value = 1900)
	@Max(value = 2020)
	private Integer anhoDesignacion;
	
	@Column(name = "nif", length = 12, nullable = false)
	@NotEmpty(message = "Campo 'nif' no especificado.")
	@Length(max=12)	
	@Size(min = 9, max = 12, message = "El campo 'numero teléfono' debe tener entre 9 y 12 caracteres")	
	private String nif;

	@Column(name = "codigo_postal", length = 5, nullable = false)
	@NotEmpty(message = "Campo 'codigo postal' no especificado.")
	@Length(max=5, message = "El campo 'codigo postal' excede del tamaño máximo")	
	@Size(min = 5, max = 5)	
	private String codigoPostal;
	
	@ManyToOne
	@JoinColumn(name = "id_municipio", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'municipio' no especificado.")
	@XmlTransient
	private Municipio municipio;
	
	@Column(name = "numero_telefono", length = 15, nullable = true)
	@Length(max=15, message = "El campo 'numero teléfono' excede del tamaño máximo")	
	@Size(max = 15)	
	private String numeroTelefono;
	
	@Column(name = "numero_fax", length = 15, nullable = true)
	@Length(max=15, message = "El campo 'numero fax' excede del tamaño máximo")	
	@Size(max = 15)	
	private String numeroFax;
	
	@Column(name = "numero_movil", length = 15, nullable = true)
	@Length(max=15, message = "El campo 'numero móvil' excede del tamaño máximo")	
	@Size(max = 15)	
	private String numeroMovil;
	
	@Column(name = "email", length = 200, nullable = true)
	@Length(max=200, message = "El campo 'email' excede del tamaño máximo")	
	@Size(max = 200)	
	private String email;
	
	@Column(name = "web", length = 200, nullable = true)
	@Length(max=200, message = "El campo 'web' excede del tamaño máximo")	
	@Size(max = 200)	
	private String web;	
	
	@Column(name = "fecha_alta", nullable = false)
	private Date fechaAlta;
	
	@Column(name = "fecha_modificacion", nullable = true)
	private Date fechaModificacion;
	
	@Column(name = "fecha_baja", nullable = true)
	private Date fechaBaja;
	
	@Column(name = "usuario_alta", length=20, nullable = false)
	@NotEmpty(message = "Campo 'usuario_alta' no especificado.")
	@Length(max = 20)
	private String usuarioAlta;
	
	@Column(name = "usuario_modificacion", length=20, nullable = true)
	@Length(max = 20)
	private String usuarioModificacion;
	
	@Column(name = "usuario_baja", length=20, nullable = true)
	@Length(max = 20)
	private String usuarioBaja;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public ClasificacionEntidadReguladora getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(ClasificacionEntidadReguladora clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Integer getAnhoDesignacion() {
		return anhoDesignacion;
	}

	public void setAnhoDesignacion(Integer anhoDesignacion) {
		this.anhoDesignacion = anhoDesignacion;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getNumeroMovil() {
		return numeroMovil;
	}

	public void setNumeroMovil(String numeroMovil) {
		this.numeroMovil = numeroMovil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getUsuarioAlta() {
		return usuarioAlta;
	}

	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getUsuarioBaja() {
		return usuarioBaja;
	}

	public void setUsuarioBaja(String usuarioBaja) {
		this.usuarioBaja = usuarioBaja;
	}

	@Override
	public String toString() {
		return "EntidadReguladora [id=" + id + ", nombre=" + nombre
				+ ", clasificacion=" + clasificacion + ", anhoDesignacion="
				+ anhoDesignacion + ", nif=" + nif + "]";
	}
	
	
}
