package com.busReservation.controllers;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.busReservation.model.Bus;
import com.busReservation.model.Reservations;
import com.busReservation.service.BusService;
import com.busReservation.service.ReservationsService;

@Controller
public class BusController {

	@Autowired
	ReservationsService reservationsService;

	@Autowired
	BusService busService;
	

	@RequestMapping(value="/createtrip", method=RequestMethod.GET)
	ModelAndView addStatus(ModelAndView modelAndView){

		modelAndView.setViewName("app.createtrip");


		Bus bus = new Bus();


		modelAndView.getModel().put("bus", bus);

		return modelAndView;
	}

	@RequestMapping(value="/createtrip", method=RequestMethod.POST)
	ModelAndView addStatus(ModelAndView modelAndView, @Valid Bus bus, BindingResult result){

		modelAndView.setViewName("app.createtrip");

		if(!result.hasErrors()){
			busService.save(bus);
			modelAndView.getModel().put("bus", new Bus());
		}



		return modelAndView;
	}
	
	@RequestMapping(value="/results", method=RequestMethod.GET)
	ModelAndView addSearch(ModelAndView modelAndView){

		modelAndView.setViewName("app.results");

		Bus bus = new Bus();

		modelAndView.getModel().put("bus", bus);

		return modelAndView;
	}

	@RequestMapping(value="/results", method=RequestMethod.POST)
	ModelAndView results(ModelAndView modelAndView, @Valid @ModelAttribute ("bus")Bus bus, BindingResult result){

		modelAndView.setViewName("app.results");

		
		if(!result.hasErrors()){
			List<Bus> results = busService.findByDateLeave(bus.getDate(), bus.getDestination(), bus.getTransporterid());
			modelAndView.getModel().put("results", results);

		}




		return modelAndView;
	}

	@RequestMapping(value="/book", method=RequestMethod.POST)
	ModelAndView results(ModelAndView modelAndView, Bus bus, BindingResult result, Principal principal, @RequestBody String postPayload){
		
		String[] parts = postPayload.split("&");
		String[] rows = parts[2].split("=");
		String[] seats = parts[3].split("=");
		String row = rows[1];
		String seat = seats[1];
		if(!result.hasErrors()){
			String kodZaSken = UUID.randomUUID().toString();
			Reservations reservation = new Reservations(bus.getId(), principal.getName(), bus.getTransporterid(),row,seat, kodZaSken);
			reservationsService.save(reservation);
			modelAndView.setViewName("redirect:/myreservations");
		}

		return modelAndView;
	}


}
