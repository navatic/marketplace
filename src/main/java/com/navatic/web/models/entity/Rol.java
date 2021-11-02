package com.navatic.web.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "rol")
public class Rol implements Serializable {

	private static final long serialVersionUID = 3489432604289496556L;

	// ATRIBUTOS ENTITY
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String rol;
	@Column(name = "date_created_rol")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreatedRol;
	@Column(name = "date_updated_rol")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdatedRol;
	
	// RELACION CON ROLES
	//@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private List<Usuario> usuarios = new ArrayList<>();
	
	// CONSTRUCTORES
	public Rol() {
	}

	public Rol(Integer id, String rol, Date dateCreatedRol, Date dateUpdatedRol) {
		this.id = id;
		this.rol = rol;
		this.dateCreatedRol = dateCreatedRol;
		this.dateUpdatedRol = dateUpdatedRol;
	}

	// METODOS GET / SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Date getDateCreatedRol() {
		return dateCreatedRol;
	}

	public void setDateCreatedRol(Date dateCreatedRol) {
		this.dateCreatedRol = dateCreatedRol;
	}

	public Date getDateUpdatedRol() {
		return dateUpdatedRol;
	}

	public void setDateUpdatedRol(Date dateUpdatedRol) {
		this.dateUpdatedRol = dateUpdatedRol;
	}
	

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


}
