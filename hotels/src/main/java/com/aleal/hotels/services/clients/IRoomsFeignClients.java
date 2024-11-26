package com.aleal.hotels.services.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aleal.hotels.model.Room;

@FeignClient("rooms") //nombre que se registra en eureka el ms que se va a consumir
public interface IRoomsFeignClients {
	
	@RequestMapping(method = RequestMethod.GET, value = "rooms/{id}", consumes = "application/json")
	public List<Room> searchHotelById(@PathVariable long id);
}
