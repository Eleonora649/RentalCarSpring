package com.rentalcar.webapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole implements Serializable
{
	@Column(name="id_user")
	@OneToMany
	@JoinColumn(name="id_user")
	private List<User> users = new ArrayList<User>();
	

	@Column(name="id_role")
	@OneToMany
	@JoinColumn(name="id_role")
	private List<Role> role = new ArrayList<Role>();
}
