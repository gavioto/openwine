package com.grafenonet.openwine.maestros.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "municipio")
public class Municipio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_municipio", nullable = false)
	private Integer id;
	
	@Column(name = "codigo", length = 3, unique = true, nullable = false)
	@NotEmpty(message = "Campo 'codigo' no especificado.")
	@Length(max=3)	
	private String codigo;
	
	@Column(name = "nombre", length = 250, nullable = false)
	@NotEmpty(message = "Campo 'nombre' no especificado.")
	@Length(max=250)	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_provincia")
	@NotNull
	@NotEmpty(message = "Campo 'provincia' no especificado.")
	@XmlTransient
	private Provincia provincia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Municipio [id=" + id + ", codigo=" + codigo + ", nombre="
				+ nombre + ", provincia=" + provincia + "]";
	}
}
