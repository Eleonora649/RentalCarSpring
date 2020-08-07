package com.rentalcar.webapp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="booking")
public class Booking implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_booking")
	private int idBooking;

	@Temporal(TemporalType.DATE)
	@Column(name="start_booking")
	private Date startBooking;
	
	@Temporal(TemporalType.DATE)
	@Column(name="end_of_booking")
	private Date endOfBooking;

	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	@ManyToOne
	@JoinColumn(name="id_car")
	private Car car;

	public Booking() {
		super();
	}

	public int getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}

	public Date getStartBooking() {
		return startBooking;
	}

	public void setStartBooking(Date startBooking) {
		this.startBooking = startBooking;
	}

	public Date getEndOfBooking() {
		return endOfBooking;
	}

	public void setEndOfBooking(Date endOfBooking) {
		this.endOfBooking = endOfBooking;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
