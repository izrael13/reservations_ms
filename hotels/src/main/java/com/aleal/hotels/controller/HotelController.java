package com.aleal.hotels.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.hotels.config.HotelsServiceConfiguration;
import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.model.HotelRooms;
import com.aleal.hotels.model.PropertiesHotels;
import com.aleal.hotels.services.IHotelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class HotelController {
	
	private static final Logger logger = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	private IHotelService service;
	
	@Autowired
	private HotelsServiceConfiguration configHotels;
	
	
	@GetMapping("hotels")
	public List<Hotel> search(){
		logger.info("inicio de metodo search() hotels");
		return (List<Hotel>) this.service.search();	
	}
	
	@GetMapping("hotels/{hotelId}")
	///@CircuitBreaker(name = "searchHotelByIdSupportCB", fallbackMethod = "searchHotelByIdAlternative")
	@Retry(name = "searchHotelByIdRetry", fallbackMethod = "searchHotelByIdAlternative")
	public HotelRooms searchHotelById(@PathVariable long hotelId){
		logger.info("inicio de metodo searchById() hotels");
		return this.service.searchHotelById(hotelId);	
	}
	
	public HotelRooms searchHotelByIdAlternative(@PathVariable long hotelId, Throwable thr){
		logger.info("inicio de metodo searchHotelByIdAlternative() hotels");
		return service.searchHotelByIdAlternative(hotelId);
	}
	
	@GetMapping("/hotels/read/properties")
	public String getPropertiesHotels() throws JsonProcessingException {
		logger.info("inicio de metodo getPropertiesHotels() hotels");
		ObjectWriter owj =new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesHotels propHotel = new 
				PropertiesHotels(configHotels.getMsg(),
						configHotels.getBuildVersion(),
						configHotels.getMailDetails());
		
		return owj.writeValueAsString(propHotel);
	} 

}
