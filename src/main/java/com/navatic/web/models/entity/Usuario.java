package com.navatic.web.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -5049438969745017571L;

	// ATRIBUTOS ENTITY
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
	@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1)
	private Integer id;
	private String username;
	private String password;
	private String name;
	@Column(name = "surname_1")
	private String surnameOne;
	@Column(name = "surname_2")
	private String surnameTwo;
	private String email;
	@Column(name = "date_created_user")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreatedUser;
	@Column(name = "date_updated_user")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdatedUser;
	
	
	// RELACION CON ROLES
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_rol", joinColumns = {
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)},
	        inverseJoinColumns = {@JoinColumn(name = "id_rol", referencedColumnName = "id", nullable = false)})
	private List<Rol> roles = new ArrayList<>();
	
	// CONSTRUCTORES
	public Usuario() {
	}

	public Usuario(Integer id, String username, String password, String name, String surnameOne, String surnameTwo,
			String email, Date dateCreatedUser, Date dateUpdatedUser) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surnameOne = surnameOne;
		this.surnameTwo = surnameTwo;
		this.email = email;
		this.dateCreatedUser = dateCreatedUser;
		this.dateUpdatedUser = dateUpdatedUser;
	}
	
	@PrePersist
	public void prePersist() {
		dateCreatedUser = new Date();
		dateUpdatedUser = new Date();
	}
	
	// METODOS GET / SET
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnameOne() {
		return surnameOne;
	}

	public void setSurnameOne(String surnameOne) {
		this.surnameOne = surnameOne;
	}

	public String getSurnameTwo() {
		return surnameTwo;
	}

	public void setSurnameTwo(String surnameTwo) {
		this.surnameTwo = surnameTwo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateCreatedUser() {
		return dateCreatedUser;
	}

	public void setDateCreatedUser(Date dateCreatedUser) {
		this.dateCreatedUser = dateCreatedUser;
	}

	public Date getDateUpdatedUser() {
		return dateUpdatedUser;
	}

	public void setDateUpdatedUser(Date dateUpdatedUser) {
		this.dateUpdatedUser = dateUpdatedUser;
	}


	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

}
