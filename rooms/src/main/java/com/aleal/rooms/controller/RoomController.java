package com.aleal.rooms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.rooms.config.RoomsServiceConfiguration;
import com.aleal.rooms.model.PropertiesRooms;
import com.aleal.rooms.model.Room;
import com.aleal.rooms.services.IRoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class RoomController {

	private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
	
	@Autowired
	private IRoomService service;
	
	@Autowired
	private RoomsServiceConfiguration configRooms;
	
	@GetMapping("rooms")
	public List<Room> search(){
		logger.info("inicio de metodo search() rooms");
		return (List<Room>) this.service.search();	
	}
	
	@GetMapping("rooms/{id}")
	public List<Room> searchHotelById(@PathVariable long id){
		logger.info("inicio de metodo searchById() rooms");
		return (List<Room>) this.service.searchRoomByHotelId(id);
	}
	
	@GetMapping("/rooms/read/properties")
	public String getPropertiesRooms() throws JsonProcessingException {
		logger.info("inicio de metodo getPropertiesRooms() rooms");
		ObjectWriter owj =new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesRooms propRooms = new 
				PropertiesRooms(configRooms.getMsg(),
						configRooms.getBuildVersion(),
						configRooms.getMailDetails());
		
		return owj.writeValueAsString(propRooms);
	} 
}
