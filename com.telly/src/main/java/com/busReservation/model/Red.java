package com.busReservation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="red")
public class Red {

	@Id
	@Column(name="red")
	private String red;
	
	@Column(name="sediste")
	private String sediste;
	
	public Red() {
		
	}
	
	public Red(String red, String sediste) {
		this.red = red;
		this.sediste = sediste;
	}

	public String getRed() {
		return red;
	}

	public void setRed(String red) {
		this.red = red;
	}

	public String getSediste() {
		return sediste;
	}

	public void setSediste(String sediste) {
		this.sediste = sediste;
	}


}
