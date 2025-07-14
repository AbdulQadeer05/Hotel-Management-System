package com.model;
import java.time.LocalDate;

import javax.persistence.*;

import com.model.Guest;
import com.model.Room;

@Entity
public class RoomBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationId;
	
	@ManyToOne
	@JoinColumn(name = "guestId")
	private Guest guest;
	
	@ManyToOne
	@JoinColumn(name = "roomId")
	private Room room;
	private LocalDate issue_date;
	private LocalDate return_date;
	private int number_of_guest;
	private String special_request;
	
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public LocalDate getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(LocalDate issue_date) {
		this.issue_date = issue_date;
	}
	public LocalDate getReturn_date() {
		return return_date;
	}
	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}
	public int getNumber_of_guest() {
		return number_of_guest;
	}
	public void setNumber_of_guest(int number_of_guest) {
		this.number_of_guest = number_of_guest;
	}
	public String getSpecial_request() {
		return special_request;
	}
	public void setSpecial_request(String special_request) {
		this.special_request = special_request;
	}
	

	public RoomBooking(Guest guest, Room room, LocalDate issue_date, LocalDate return_date,
			int number_of_guest, String special_request) {
		
		this.guest = guest;
		this.room = room;
		this.issue_date = issue_date;
		this.return_date = return_date;
		this.number_of_guest = number_of_guest;
		this.special_request = special_request;
	}
	public RoomBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
