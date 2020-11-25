package com.busReservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket_reservations")
public class Reservations {
	
	public Reservations() {}
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "destination_id")
	private Long destination_id;
	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "transporter_id")
	private String transporter_id;
	
	@Column(name = "red")
	private String red;
	
	@Column(name = "seat")
	private String seat;
	
	@Column(name = "kodZaSken")

	private String kodZaSken;

	


	public Reservations(Long destination_id, String email, String transporter_id, String red, String seat, String kodZaSken ) {
		this.destination_id = destination_id;
		this.email = email;
		this.transporter_id = transporter_id;
		this.red = red;
		this.seat = seat;
		this.kodZaSken = kodZaSken;
		
	}

	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDestination_Id() {
		return destination_id;
	}

	public void setDestination_Id(Long destination_id) {
		this.destination_id = destination_id;
	}

	public String getTransporter_Id() {
		return transporter_id;
	}

	public void setTransporter_Id(String transporter_id) {
		this.transporter_id = transporter_id;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRow() {
		return red;
	}




	public void setRow(String red) {
		this.red = red;
	}




	public String getSeat() {
		return seat;
	}




	public void setSeat(String seat) {
		this.seat = seat;
	}




	public String getKodZaSken() {
		return kodZaSken;
	}




	public void setKodZaSken(String kodZaSken) {
		this.kodZaSken = kodZaSken;
	}
	
	
	


	
	
	
	



}