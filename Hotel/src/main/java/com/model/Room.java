package com.model;


import javax.persistence.*;



@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;
	
	@ManyToOne
	@JoinColumn(name = "hotelId")
	private Hotel hotelId;

	@ManyToOne
	@JoinColumn(name = "roomTypeId")
	private RoomType roomTypeId;

	private String roomNo;
	private String floor;
	private String status;
	private int ratePerNight;
	private String description;
	
	public RoomType getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(RoomType roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public Hotel getHotelId() {
		return hotelId;
	}
	public void setHotelId(Hotel hotelId) {
		this.hotelId = hotelId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public int getRatePerNight() {
		return ratePerNight;
	}
	public void setRatePerNight(int ratePerNight) {
		this.ratePerNight = ratePerNight;
	}
	
	
	
}