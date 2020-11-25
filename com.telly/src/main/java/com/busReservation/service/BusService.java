package com.busReservation.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busReservation.model.Bus;
import com.busReservation.model.BusDao;
import com.busReservation.model.Transporter;
import com.busReservation.model.TransporterDao;

@Service
public class BusService {
	
	@Autowired
	private BusDao busDao;
	@Autowired
	private TransporterDao transporterDao;
	
	public void save(Bus bus){
		busDao.save(bus);
		Transporter tr = new Transporter(bus.getTransporterid());
		transporterDao.save(tr);
	}

	public List<Bus> findByDateLeave(Date date, String destination, String transporterid){
		List<Bus> results = busDao.findByDateAndDestination(date, destination);
		
		return results;
	}
	
	public Bus findById(Long id) {
		Bus bus = busDao.findOne(id);
		return bus;
	}

}
