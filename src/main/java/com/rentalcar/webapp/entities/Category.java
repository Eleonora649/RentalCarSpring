package com.rentalcar.webapp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_category")
	private int idCategory;

	@Column(name="name")
	private String name;

	@OneToMany(mappedBy="category")
	private List<Car> cars;

	public Category() {
		super();
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	
}
