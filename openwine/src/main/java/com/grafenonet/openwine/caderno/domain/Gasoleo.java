package com.grafenonet.openwine.caderno.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Gasoleo")
public class Gasoleo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_gasoleo", length=32)
	private Integer id;
	
	@Column
	@NotNull
	@NotEmpty(message = "'fecha' no especificado.")
	//@Temporal(TemporalType.DATE)
	//@DateTimeFormat(iso = ISO.DATE)
	private Date fecha;

	@Column(name = "litros")
	@NotNull
	@NotEmpty(message = "'litros' no especificado.")
	private BigDecimal litros;
	
	@Column(name = "importe")
	@NotNull
	@NotEmpty(message = "'importe' no especificado.")
	private BigDecimal importe;
	
	@Column(name = "fecha_baja", nullable = true)
	private Date fechaBaja;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	@Override
	public String toString() {
		return "Gasoleo [id=" + id + ", fecha=" + fecha + ", litros=" + litros
				+ ", importe=" + importe + "]";
	}
	
	

}
