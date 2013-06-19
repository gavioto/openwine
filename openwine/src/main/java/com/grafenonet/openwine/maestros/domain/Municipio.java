package com.grafenonet.openwine.maestros.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.grafenonet.openwine.core.domain.BaseEntity;

@Entity
@Table(name = "municipio")
public class Municipio extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "codigo", length = 3, unique = true, nullable = false)
	@NotEmpty(message = "web.validate.campo_obligatorio")
	@Length(max=3, message = "web.validate.tamano_maximo")	
	private String codigo;
	
	@Column(name = "nombre", length = 250, nullable = false)
	@NotEmpty(message = "web.validate.campo_obligatorio")
	@Length(max=250, message = "web.validate.tamano_maximo")	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_provincia")
	@NotNull
	@NotEmpty(message = "Campo 'provincia' no especificado.")
	@XmlTransient
	private Provincia provincia;

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
		return "Municipio [id=" + getId() + ", codigo=" + codigo + ", nombre="
				+ nombre + ", provincia=" + provincia + "]";
	}
}
