package com.grafenonet.openwine.domain;


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

@Entity
@Table(name = "TicketGasoil")
public class TicketGasoil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=32)
	private Integer id;
	
	@Column
	@NotNull
	//@Temporal(TemporalType.DATE)
	//@DateTimeFormat(iso = ISO.DATE)
	private Date fecha;

	@Column
	@NotNull
	private BigDecimal litros;
	
	@Column
	@NotNull
	private BigDecimal importe;
	
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
	
	

}
