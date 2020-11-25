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
@Table(name="transporter")
public class Transporter {
	
	
	@NotNull
	@Column(name = "transporter")
	private String transporter;
	
	@Id
	@Column(name="peronid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long peronid;
	
	public Transporter () {
		
	}
	
	public Transporter (String transporter) {
		this.transporter = transporter;
	}

	public String getTransporter() {
		return transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}

	public Long getPeronid() {
		return peronid;
	}

	public void setPeronid(Long peronid) {
		this.peronid = peronid;
	}
}
