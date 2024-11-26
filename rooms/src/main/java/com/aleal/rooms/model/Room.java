package com.aleal.rooms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="room_id")
	private long roomId;
	
	@Column(name="hotel_id")
	private long hotelId;
	
	@Column(name="room_name")
	private String roomName;
	
	@Column(name="room_available")
	private String roomAvailable;

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomAvailable() {
		return roomAvailable;
	}

	public void setRoomAvailable(String roomAvailable) {
		this.roomAvailable = roomAvailable;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", hotelId=" + hotelId + ", roomName=" + roomName + ", roomAvailable="
				+ roomAvailable + "]";
	}
	
	

}




