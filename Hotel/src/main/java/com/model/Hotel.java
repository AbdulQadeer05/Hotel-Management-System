package com.model;
import javax.persistence.*;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int hotelId;
	private String hotelName;
	private String phoneNo;
	private String fullAddress;
	private String city;
	private String state;
	private String country;
	private String email;
	private int rating;
	private String Description;
	
	
	
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Hotel(String hotelName, String phoneNo, String fullAddress, String city, String state, String country,
			String email, int rating, String description) {
		super();
		this.hotelName = hotelName;
		this.phoneNo = phoneNo;
		this.fullAddress = fullAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.email = email;
		this.rating = rating;
		Description = description;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
