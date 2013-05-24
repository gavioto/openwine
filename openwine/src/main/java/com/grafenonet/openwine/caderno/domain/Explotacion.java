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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.grafenonet.openwine.caderno.enums.CaracterExplotacion;

@Entity
@Table(name = "explotacion")
public class Explotacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_explotacion")
	private Integer id;
	
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
		return "Explotacion [id=" + id + ", nombre=" + nombre + ", viticultor="
				+ viticultor + ", caracter=" + caracter + "]";
	}	
	
}
