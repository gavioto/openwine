package com.grafenonet.openwine.cuaderno.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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

import org.hibernate.validator.constraints.NotEmpty;

import com.grafenonet.openwine.core.domain.BaseEntity;
import com.grafenonet.openwine.core.domain.IGenericDomain;

@Entity
@Table(name = "gasoleo")
public class Gasoleo extends BaseEntity implements Serializable, IGenericDomain {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_gasoleo", length=32)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_explotacion", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'explotacion' no especificado.")
	@XmlTransient
	private Explotacion explotacion;	
	
	@Column(name = "fecha", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'fecha' no especificado.")
	private Date fecha;

	@Column(name = "litros", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'litros' no especificado.")
	private BigDecimal litros;
	
	@Column(name = "importe", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'importe' no especificado.")
	private BigDecimal importe;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Explotacion getExplotacion() {
		return explotacion;
	}

	public void setExplotacion(Explotacion explotacion) {
		this.explotacion = explotacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getLitros() {
		return litros;
	}

	public void setLitros(BigDecimal litros) {
		this.litros = litros;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "Gasoleo [id=" + id + ", explotacion=" + explotacion
				+ ", fecha=" + fecha + ", litros=" + litros + "]";
	}
		
	
}
