package com.model;

import javax.persistence.*;

@Entity
public class RoomType {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int roomTypeId;
	
	private String typeName;
	private String description;
	private int maxOccupancy;
	private int Night;
	
	
	public int getNight() {
		return Night;
	}
	public void setNight(int night) {
		Night = night;
	}
	public int getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMaxOccupancy() {
		return maxOccupancy;
	}
	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}
	
	public RoomType(String typeName, String description, int maxOccupancy, int Night) {
		super();
		this.typeName = typeName;
		this.description = description;
		this.maxOccupancy = maxOccupancy;
		this.Night = Night;
	}
	public RoomType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}