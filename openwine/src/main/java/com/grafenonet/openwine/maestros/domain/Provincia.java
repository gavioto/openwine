package com.grafenonet.openwine.maestros.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.grafenonet.openwine.core.domain.BaseEntity;
import com.grafenonet.openwine.core.domain.IGenericDomain;

@Entity
@Table(name = "provincia")
public class Provincia extends BaseEntity implements Serializable, IGenericDomain {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_provincia", nullable = false)
	private Integer id;
	
	@Column(name = "codigo", length = 2, unique = true, nullable = false)
	@NotEmpty(message = "Campo 'codigo' no especificado.")
	@Length(max=2)	
	private String codigo;
	
	@Column(name = "nombre", length = 2, nullable = false)
	@NotEmpty(message = "Campo 'nombre' no especificado.")
	@Length(max=250)	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_pais")
	@NotNull
	@NotEmpty(message = "Campo 'pais' no especificado.")
	@XmlTransient
	private Pais pais;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
	@XmlTransient
	private Set<Municipio> municipios;	
	
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	public Set<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(Set<Municipio> municipios) {
		this.municipios = municipios;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", codigo=" + codigo + ", nombre="
				+ nombre + ", pais=" + pais + "]";
	}	
}
