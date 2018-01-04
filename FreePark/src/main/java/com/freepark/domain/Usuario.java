package com.freepark.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario implements java.io.Serializable{

	private static final long serialVersionUID = -1934822372674563491L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Size(min = 5, max = 20)
	@Column(name = "login")
	private String username;

	@NotNull
	@Size(min = 5)
	@Column(name = "password")
	private String password;

	@NotNull(groups = Usuario.class)
	@Size(min = 5)
	@Transient
	private String confirmPassword;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roles_id")
	private Rol roles;

	@Column(name = "activado")
	private Boolean enabled = false;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="usuarios_vehiculos", joinColumns={@JoinColumn(name="usuarios_id", referencedColumnName="id")}, 
			inverseJoinColumns={@JoinColumn(name="vehiculos_id", referencedColumnName="id")}
	)
	private List<Vehiculo> vehiculos;

	public Usuario() {
		super();
	}

	public Usuario(String username, String password) {
		this.password = password;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Rol getRoles() {
		return roles;
	}

	public void setRoles(Rol roles) {
		this.roles = roles;
	}

	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getUsername() {
		return this.username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", roles=" + roles + ", enabled=" + enabled
				+ ", vehiculos=" + vehiculos + "]";
	}

}
