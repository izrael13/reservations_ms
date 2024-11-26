package com.aleal.reservations.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.reservations.config.ReservationsServiceConfiguration;
import com.aleal.reservations.model.PropertiesReservations;
import com.aleal.reservations.model.Reservation;
import com.aleal.reservations.services.IReservationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class ReservationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private IReservationService service;
	
	@Autowired
	private ReservationsServiceConfiguration configreservations;

	@GetMapping("reservations")
	public List<Reservation> search(){
		logger.info("inicio de metodo search() reservations");
		return (List<Reservation>) this.service.search();	
	}
	
	@GetMapping("/reservations/read/properties")
	public String getPropertiesReservations() throws JsonProcessingException {
		logger.info("inicio de metodo getPropertiesReservations() reservations");
		ObjectWriter owj =new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesReservations propReservations = new 
				PropertiesReservations(configreservations.getMsg(),
						configreservations.getBuildVersion(),
						configreservations.getMailDetails());
		
		return owj.writeValueAsString(propReservations);
	} 

}
