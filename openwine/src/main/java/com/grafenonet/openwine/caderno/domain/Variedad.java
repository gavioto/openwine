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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.grafenonet.openwine.caderno.enums.MaduracionVariedad;
import com.grafenonet.openwine.caderno.enums.ProductividadVariedad;
import com.grafenonet.openwine.caderno.enums.TipoVariedad;
import com.grafenonet.openwine.domain.IGenericDomain;

@Entity
@Table(name="variedad")
public class Variedad implements Serializable, IGenericDomain {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_variedad", nullable = false)
	private Integer id;	
	
	@Column(name = "tipo_variedad", length=20, nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'tipo variedad' no especificado.")
	@Enumerated(EnumType.STRING)
	private TipoVariedad tipoVariedad;
	
	@Column(name = "nombre", length = 100, nullable = false)
	@NotEmpty(message = "Campo 'nombre' no especificado.")
	@Length(max=100)	
	@Size(min = 4, max = 100)
	private String nombre;

	@Column(name = "descripcion", length = 2000, nullable = false)
	@NotEmpty(message = "Campo 'descripcion' no especificado.")
	@Length(max=2000)	
	@Size(min = 4, max = 2000)
	private String descripcion;	
	
	@Column(name = "productividad", length=40, nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'productividad' no especificado.")
	@Enumerated(EnumType.STRING)
	private ProductividadVariedad productividad;	
	
	@Column(name = "maduracion", length=40, nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'maduracion' no especificado.")
	@Enumerated(EnumType.STRING)
	private MaduracionVariedad maduracion;
	
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

	public TipoVariedad getTipoVariedad() {
		return tipoVariedad;
	}

	public void setTipoVariedad(TipoVariedad tipoVariedad) {
		this.tipoVariedad = tipoVariedad;
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

	public ProductividadVariedad getProductividad() {
		return productividad;
	}

	public void setProductividad(ProductividadVariedad productividad) {
		this.productividad = productividad;
	}

	public MaduracionVariedad getMaduracion() {
		return maduracion;
	}

	public void setMaduracion(MaduracionVariedad maduracion) {
		this.maduracion = maduracion;
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
		return "Variedad [id=" + id + ", tipoVariedad=" + tipoVariedad
				+ ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", productividad=" + productividad + ", maduracion="
				+ maduracion + "]";
	}	
}
