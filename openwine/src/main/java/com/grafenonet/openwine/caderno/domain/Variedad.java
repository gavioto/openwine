package com.grafenonet.openwine.caderno.domain;

import java.io.Serializable;

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

@Entity
@Table(name="variedad")
public class Variedad implements Serializable {

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

	@Override
	public String toString() {
		return "Variedad [id=" + id + ", tipoVariedad=" + tipoVariedad
				+ ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", productividad=" + productividad + ", maduracion="
				+ maduracion + "]";
	}	
}