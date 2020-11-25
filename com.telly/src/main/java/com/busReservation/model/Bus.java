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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="relacija")
public class Bus {
	

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	
	@NotNull
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="transporterid")
	private String transporterid;
	
	
	
	public Bus() {
		
	}


	public Bus(Date date, String destination, String transporterid) {
		this.date = date;
		this.destination = destination;
		this.transporterid = transporterid;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getTransporterid() {
		return transporterid;
	}


	public void setTransporterid(String transporterid) {
		this.transporterid = transporterid;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	
	
}