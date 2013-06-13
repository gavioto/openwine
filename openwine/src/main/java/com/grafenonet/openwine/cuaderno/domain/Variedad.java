package com.grafenonet.openwine.cuaderno.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.grafenonet.openwine.core.domain.BaseEntity;
import com.grafenonet.openwine.cuaderno.enums.CalificacionVariedad;
import com.grafenonet.openwine.cuaderno.enums.MaduracionVariedad;
import com.grafenonet.openwine.cuaderno.enums.ProductividadVariedad;
import com.grafenonet.openwine.cuaderno.enums.TipoVariedad;

@Entity
@Table(name="variedad")
public class Variedad extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "tipo_variedad", length=20, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoVariedad tipo;
	
	@Column(name = "nombre", length = 100, unique=true, nullable = false)
	@NotEmpty(message = "web.validate.campo_obligatorio")
	@Length(max=100)	
	@Size(min = 4, max = 100, message="web.validate.tamano_campo")
	private String nombre;

	@Column(name = "descripcion", length = 2000, nullable = false)
	@NotEmpty(message = "web.validate.campo_obligatorio")
	@Length(max=2000)	
	@Size(min = 4, max = 2000, message="web.validate.tamano_campo")
	private String descripcion;	
	
	@Column(name = "calificacion", length=20, nullable = false)
	@Enumerated(EnumType.STRING)
	private CalificacionVariedad calificacion;
	
	@Column(name = "productividad", length=40, nullable = false)
	@Enumerated(EnumType.STRING)
	private ProductividadVariedad productividad;	
	
	@Column(name = "maduracion", length=40, nullable = false)
	@Enumerated(EnumType.STRING)
	private MaduracionVariedad maduracion;

	public TipoVariedad getTipo() {
		return tipo;
	}

	public void setTipo(TipoVariedad tipo) {
		this.tipo = tipo;
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
	
	public CalificacionVariedad getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(CalificacionVariedad calificacion) {
		this.calificacion = calificacion;
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
		return "Variedad [id=" + getId() + ", tipoVariedad=" + tipo + ", nombre=" + nombre
				+ ", calificacion=" + calificacion + ", productividad="
				+ productividad + ", maduracion=" + maduracion + "]";
	}
	
}
