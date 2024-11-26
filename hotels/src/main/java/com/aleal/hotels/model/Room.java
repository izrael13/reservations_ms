package com.aleal.hotels.model;

public class Room {
	private long roomId;
	private long hotelId;
	private String roomName;
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
