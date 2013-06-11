package com.grafenonet.openwine.cuaderno.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.grafenonet.openwine.core.domain.BaseEntity;
import com.grafenonet.openwine.cuaderno.enums.ConduccionPlantacion;
import com.grafenonet.openwine.cuaderno.enums.EstadoParcela;
import com.grafenonet.openwine.cuaderno.enums.RegimenTenencia;
import com.grafenonet.openwine.maestros.domain.Municipio;

@Entity
@Table(name = "parcela")
public class Parcela extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_explotacion", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'explotacion' no especificado.")
	@XmlTransient
	private Explotacion explotacion;	
	
	@Column(name = "nombre", length = 200, nullable = false)
	@NotEmpty(message = "Campo 'nombre' no especificado.")
	@Length(max=200)	
	@Size(min = 4, max = 200, message = "El campo 'nombre' debe tener entre 4 y 200 caracteres")
	private String nombre;
	
	@Column(name = "estado", length=20, nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'estado' no especificado.")
	@Enumerated(EnumType.STRING)
	private EstadoParcela estado;
	
	@Column(name = "regimen_tenecia", length=20, nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'regimen' no especificado.")
	@Enumerated(EnumType.STRING)
	private RegimenTenencia regimen;
	
	@ManyToOne
	@JoinColumn(name = "id_municipio", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'municipio' no especificado.")
	@XmlTransient
	private Municipio municipio;
	
	@Column(name = "lugar", length = 200, nullable = false)
	@NotNull	
	@NotEmpty(message = "Campo 'lugar' no especificado.")
	@Length(max=200)	
	@Size(min = 4, max = 200, message = "El campo 'lugar' debe tener entre 4 y 200 caracteres")
	private String lugar;
	
	
	@Column(name = "poligono", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'poligono' no especificado.")
	@Min(value = 1)
	@Max(value = 9999)
	private Integer poligono;
	
	@Column(name = "parcela", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'parcela' no especificado.")
	@Min(value = 1)
	@Max(value = 9999)
	private Integer parcela;
	
	@Column(name = "recinto", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'recinto' no especificado.")
	@Min(value = 1)
	@Max(value = 9999)
	private Integer recinto;
	
	@Column(name = "superficie_parcela")
	@NotNull
	@NotEmpty(message = "Campo 'superficie parcela' no especificado.")
	private BigDecimal superficieParcela;	

	@Column(name = "superficie_cultivo")
	@NotNull
	@NotEmpty(message = "Campo 'superficie cultivo' no especificado.")
	private BigDecimal superficieCultivo;	

	@Column(name = "superficie_ecologico")
	@NotNull
	@NotEmpty(message = "Campo 'superficie ecologico' no especificado.")
	private BigDecimal superficieEcologico;	
	
	@Column(name = "anho_plantacion", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'año plantacion' no especificado.")	
	@Min(value = 1900)
	@Max(value = 2020)
	private Integer anhoPlantacion;	
	
	@Column(name = "conduccion_plantacion", length=20, nullable = false)
	@NotNull		
	@NotEmpty(message = "Campo 'conduccion' no especificado.")
	@Enumerated(EnumType.STRING)
	private ConduccionPlantacion conduccion;
	
	@Column(name = "sistema_riego", length=20, nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'sistema riego' no especificado.")
	@Enumerated(EnumType.STRING)
	private ConduccionPlantacion sistemaRiego;	
	
	@ManyToOne
	@JoinColumn(name = "id_patron", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'patron' no especificado.")
	@XmlTransient
	private Patron patron;	
	
	@Column(name = "marco_plantacion_calle")
	@NotNull
	@NotEmpty(message = "Campo 'marco plantacion calle' no especificado.")
	private BigDecimal marcoPlantacionCalle;
	
	@Column(name = "marco_plantacion_cepa")
	@NotNull
	@NotEmpty(message = "Campo 'marco plantacion cepa' no especificado.")
	private BigDecimal marcoPlantacionCepa;	
	
	@ManyToOne
	@JoinColumn(name = "id_variedad_1", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'variedad 1' no especificado.")
	@XmlTransient
	private Variedad variedad1;
	
	@Column(name = "cantidad_variedad_1", nullable = false)
	@NotNull
	@NotEmpty(message = "Campo 'cantidad_variedad_1' no especificado.")	
	@Min(value = 0)
	@Max(value = 100000000)
	private Integer cantidadVariedad1;
	
	@ManyToOne
	@JoinColumn(name = "id_variedad_2", nullable = true)
	@XmlTransient
	private Variedad variedad2;
	
	@Column(name = "cantidad_variedad_2", nullable = true)		
	@Min(value = 0)
	@Max(value = 100000000)
	private Integer cantidadVariedad2;
	
	@ManyToOne
	@JoinColumn(name = "id_variedad_3", nullable = true)
	@XmlTransient
	private Variedad variedad3;
	
	@Column(name = "cantidad_variedad_3", nullable = true)
	@Min(value = 0)
	@Max(value = 100000000)
	private Integer cantidadVariedad3;
	
	public Explotacion getExplotacion() {
		return explotacion;
	}

	public void setExplotacion(Explotacion explotacion) {
		this.explotacion = explotacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EstadoParcela getEstado() {
		return estado;
	}

	public void setEstado(EstadoParcela estado) {
		this.estado = estado;
	}

	public RegimenTenencia getRegimen() {
		return regimen;
	}

	public void setRegimen(RegimenTenencia regimen) {
		this.regimen = regimen;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Integer getPoligono() {
		return poligono;
	}

	public void setPoligono(Integer poligono) {
		this.poligono = poligono;
	}

	public Integer getParcela() {
		return parcela;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	public Integer getRecinto() {
		return recinto;
	}

	public void setRecinto(Integer recinto) {
		this.recinto = recinto;
	}

	public BigDecimal getSuperficieParcela() {
		return superficieParcela;
	}

	public void setSuperficieParcela(BigDecimal superficieParcela) {
		this.superficieParcela = superficieParcela;
	}

	public BigDecimal getSuperficieCultivo() {
		return superficieCultivo;
	}

	public void setSuperficieCultivo(BigDecimal superficieCultivo) {
		this.superficieCultivo = superficieCultivo;
	}

	public BigDecimal getSuperficieEcologico() {
		return superficieEcologico;
	}

	public void setSuperficieEcologico(BigDecimal superficieEcologico) {
		this.superficieEcologico = superficieEcologico;
	}

	public Integer getAnhoPlantacion() {
		return anhoPlantacion;
	}

	public void setAnhoPlantacion(Integer anhoPlantacion) {
		this.anhoPlantacion = anhoPlantacion;
	}

	public ConduccionPlantacion getConduccion() {
		return conduccion;
	}

	public void setConduccion(ConduccionPlantacion conduccion) {
		this.conduccion = conduccion;
	}

	public ConduccionPlantacion getSistemaRiego() {
		return sistemaRiego;
	}

	public void setSistemaRiego(ConduccionPlantacion sistemaRiego) {
		this.sistemaRiego = sistemaRiego;
	}

	public Patron getPatron() {
		return patron;
	}

	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	public BigDecimal getMarcoPlantacionCalle() {
		return marcoPlantacionCalle;
	}

	public void setMarcoPlantacionCalle(BigDecimal marcoPlantacionCalle) {
		this.marcoPlantacionCalle = marcoPlantacionCalle;
	}

	public BigDecimal getMarcoPlantacionCepa() {
		return marcoPlantacionCepa;
	}

	public void setMarcoPlantacionCepa(BigDecimal marcoPlantacionCepa) {
		this.marcoPlantacionCepa = marcoPlantacionCepa;
	}

	public Variedad getVariedad1() {
		return variedad1;
	}

	public void setVariedad1(Variedad variedad1) {
		this.variedad1 = variedad1;
	}

	public Integer getCantidadVariedad1() {
		return cantidadVariedad1;
	}

	public void setCantidadVariedad1(Integer cantidadVariedad1) {
		this.cantidadVariedad1 = cantidadVariedad1;
	}

	public Variedad getVariedad2() {
		return variedad2;
	}

	public void setVariedad2(Variedad variedad2) {
		this.variedad2 = variedad2;
	}

	public Integer getCantidadVariedad2() {
		return cantidadVariedad2;
	}

	public void setCantidadVariedad2(Integer cantidadVariedad2) {
		this.cantidadVariedad2 = cantidadVariedad2;
	}

	public Variedad getVariedad3() {
		return variedad3;
	}

	public void setVariedad3(Variedad variedad3) {
		this.variedad3 = variedad3;
	}

	public Integer getCantidadVariedad3() {
		return cantidadVariedad3;
	}

	public void setCantidadVariedad3(Integer cantidadVariedad3) {
		this.cantidadVariedad3 = cantidadVariedad3;
	}

	@Override
	public String toString() {
		return "Parcela [id=" + getId() + ", explotacion=" + explotacion
				+ ", nombre=" + nombre + ", variedad1=" + variedad1
				+ ", cantidadVariedad1=" + cantidadVariedad1 + "]";
	}	

}
