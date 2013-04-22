package com.grafenonet.openwine.maestros.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;

	@Column(name = "username", length=20, unique=true, nullable = false)
	@NotEmpty(message = "'username' no especificado.")
	@Length(min = 4, max = 20)
	private String username;
	
	@Column(name = "password", length=20, nullable = false)
	@NotEmpty(message = "'password' no especificado.")
	@Length(min = 4, max = 20)
	private String password;
		
	@Column(name = "email", length=200, unique=true, nullable = false)
	@Length(max = 200)
	@NotEmpty(message = "'email' no especificado.")
	private String email;
	
	@Column(name = "nombre", length=200, nullable = false)
	@Length(max = 200)
	@NotEmpty(message = "'nombre' no especificado.")
	private String nombre;
	
	@Column(name = "apellidos", length=200, nullable = false)
	@Length(max = 200)
	@NotEmpty(message = "'apellidos' no especificado.")
	private String apellidos;
	
	@Column(name = "fecha_nacimiento", nullable = true)
	private Date fechaNacimiento;
	
	@Column(name = "numero_telefono", length=15, nullable = true)
	@Length(max = 15)
	private String numeroTelefono;
	
	@Column(name = "numero_movil", length=15, nullable = true)
	@Length(max = 15)
	private String numeroMovil;
	
	
	@Column(name = "fechaAlta", nullable = false)
	private Date fechaAlta;
	
	@Column(name = "fechaModificacion", nullable = true)
	private Date fechaModificacion;
	
	@Column(name = "fechaBaja", nullable = true)
	private Date fechaBaja;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public String getNumeroTelefono() {
		return numeroTelefono;
	}



	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}



	public String getNumeroMovil() {
		return numeroMovil;
	}



	public void setNumeroMovil(String numeroMovil) {
		this.numeroMovil = numeroMovil;
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



	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", email="
				+ email + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ "]";
	}

	
	public String getNombreApellidos() {
		return this.nombre + " " + this.apellidos;
	}
	
	public String getApellidosNombre() {
		return this.apellidos + ", " + this.nombre;
	}

}
