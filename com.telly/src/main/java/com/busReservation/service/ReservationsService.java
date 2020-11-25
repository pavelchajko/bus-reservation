package com.busReservation.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.busReservation.model.Red;
import com.busReservation.model.RedDao;
import com.busReservation.model.Reservations;
import com.busReservation.model.ReservationsDao;
import com.busReservation.model.Transporter;

@Service
public class ReservationsService {

	@Autowired
	ReservationsDao reservationsDao;
	
	@Autowired
	RedDao redDao;
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}


	public List<Reservations> findByEmail(String email)
	{
		return reservationsDao.findByEmail(email);
	}

	public void save(Reservations reserve) {
		reservationsDao.save(reserve);
		Red red = new Red(reserve.getRow(),reserve.getSeat());
		redDao.save(red);
	}

	public void delete(Long id) {
		reservationsDao.delete(id);

	}

	public boolean create(Reservations reserve) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(reserve);

		return jdbc.update("insert into ticket_reservations (destination_id, email,transporter_id, row, seat,kodZaSken) values (:destination_id, :email, :transporter_id, :row, :seat, :kodZaSken)", params) == 1;
	}

}
