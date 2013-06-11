package com.grafenonet.openwine.cuaderno.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.grafenonet.openwine.core.domain.BaseEntity;
import com.grafenonet.openwine.cuaderno.enums.CaracterExplotacion;

@Entity
@Table(name = "explotacion")
public class Explotacion extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nombre", length = 100, nullable = false)
	@NotEmpty(message = "Campo 'nombre' no especificado.")
	@Length(max=100)	
	@Size(min = 4, max = 100, message = "El campo 'nombre' debe tener entre 4 y 100 caracteres")
	private String nombre;

	@Column(name = "observaciones", length = 2000, nullable = false)
	@NotEmpty(message = "Campo 'observaciones' no especificado.")
	@Length(max=2000)	
	@Size(min = 4, max = 2000, message = "El campo 'observaciones' debe tener entre 4 y 2000 caracteres")
	private String observaciones;
	
	@ManyToOne
	@JoinColumn(name = "id_viticultor", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'viticultor' no especificado.")
	@XmlTransient
	private Viticultor viticultor;	

	@ManyToOne
	@JoinColumn(name = "id_tecnico", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'tecnico' no especificado.")
	@XmlTransient
	private Tecnico tecnico;
	
	@Column(name = "caracter_explotacion", length=20, nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'caracter' no especificado.")
	@Enumerated(EnumType.STRING)
	private CaracterExplotacion caracter;	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Viticultor getViticultor() {
		return viticultor;
	}

	public void setViticultor(Viticultor viticultor) {
		this.viticultor = viticultor;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public CaracterExplotacion getCaracter() {
		return caracter;
	}

	public void setCaracter(CaracterExplotacion caracter) {
		this.caracter = caracter;
	}

	@Override
	public String toString() {
		return "Explotacion [id=" + getId() + ", nombre=" + nombre + ", viticultor="
				+ viticultor + ", caracter=" + caracter + "]";
	}	
	
}
