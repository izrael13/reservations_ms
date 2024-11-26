package com.aleal.hotels.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aleal.hotels.dao.IHotelDao;
import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.model.HotelRooms;
import com.aleal.hotels.model.Room;
import com.aleal.hotels.services.clients.IRoomsFeignClients;

@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	private IHotelDao hotelDao;

	@Autowired
	private RestTemplate clientRest;
	
	@Autowired
	private IRoomsFeignClients feignClients;
	
	@Override
	public List<Hotel> search() {
		return (List<Hotel>) hotelDao.findAll();
	}

	/*@Override //con RestTemplate
	public HotelRooms searchHotelById(long hotelId) {
		HotelRooms res = new HotelRooms();
		Optional<Hotel> hotel = hotelDao.findById(hotelId);
		
		Map<String,Long> pathVariables =new HashMap<String, Long>();
		pathVariables.put("id", hotelId);
		
		List<Room> rooms =Arrays.asList(
				clientRest.getForObject("http://localhost:8081/rooms/{id}", 
				Room[].class, 
				pathVariables)
				);
		res.setHotelId(hotel.get().getHotelId());
		res.setHotelName(hotel.get().getHotelName());
		res.setHotelAddress(hotel.get().getHotelAddress());
		res.setRooms(rooms);
		
		return res;
	} */
	
	
	@Override //con Feign
	public HotelRooms searchHotelById(long hotelId) {
		HotelRooms res = new HotelRooms();
		Optional<Hotel> hotel = hotelDao.findById(hotelId);
		
		Map<String,Long> pathVariables =new HashMap<String, Long>();
		pathVariables.put("id", hotelId);
		
		List<Room> rooms = feignClients.searchHotelById(hotelId);
		
		res.setHotelId(hotel.get().getHotelId());
		res.setHotelName(hotel.get().getHotelName());
		res.setHotelAddress(hotel.get().getHotelAddress());
		res.setRooms(rooms);
		
		return res;
	}

	@Override
	public HotelRooms searchHotelByIdAlternative(long hotelId) {
		HotelRooms res = new HotelRooms();
		Optional<Hotel> hotel = hotelDao.findById(hotelId);
		
		res.setHotelId(hotel.get().getHotelId());
		res.setHotelName(hotel.get().getHotelName());
		res.setHotelAddress(hotel.get().getHotelAddress());
		
		return res;
	}
}
