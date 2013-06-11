package com.grafenonet.openwine.maestros.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.grafenonet.openwine.core.domain.BaseEntity;
import com.grafenonet.openwine.core.domain.IGenericDomain;

@Entity
@Table(name = "usuario")
public class Usuario extends BaseEntity implements UserDetails, Serializable, IGenericDomain {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;

	@Column(name = "username", length=20, unique=true, nullable = false)
	@NotEmpty(message = "Campo 'username' no especificado.")
	@Length(min = 4, max = 20)
	private String username;
	
	@Column(name = "password", length=20, nullable = false)
	@NotEmpty(message = "Campo 'password' no especificado.")
	@Length(min = 4, max = 20)
	private String password;
		
	@Column(name = "email", length=200, unique=true, nullable = false)
	@Length(max = 200)
	@NotEmpty(message = "Campo 'email' no especificado.")
	private String email;
	
	@Column(name = "nombre", length=200, nullable = false)
	@Length(max = 200)
	@NotEmpty(message = "Campo 'nombre' no especificado.")
	private String nombre;
	
	@Column(name = "apellidos", length=200, nullable = false)
	@Length(max = 200)
	@NotEmpty(message = "Campo 'apellidos' no especificado.")
	private String apellidos;
	
	@Column(name = "fecha_nacimiento", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	
	@Column(name = "numero_telefono", length=15, nullable = true)
	@Length(max = 15)
	private String numeroTelefono;
	
	@Column(name = "numero_movil", length=15, nullable = true)
	@Length(max = 15)
	private String numeroMovil;
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	@NotNull
	@NotEmpty(message = "Campo 'rol' no especificado.")
	@XmlTransient
	private Rol rol;	
	
//	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
//	@JoinTable(name="usuario_rol",
//		joinColumns = {@JoinColumn(name="id_usuario")},
//		inverseJoinColumns = {@JoinColumn(name="id_rol")}
//	)
//	private List<Rol> roles = new ArrayList<Rol>();
	
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
	
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}	

//	public List<Rol> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Rol> roles) {
//		this.roles = roles;
//	}

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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		return getFechaBaja() == null;
	}

}
