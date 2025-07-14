package com.model;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Housekeeping {
 
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int housekeepingId;
	    @ManyToOne
	    @JoinColumn(name = "roomId")
	    private Room room;
	    @ManyToOne
	    @JoinColumn(name = "staffId")
	    private Staff staff;
	    private LocalDate dateCleaned;
	    private String status;
	    private String notes;
	    
	    
		public int getHousekeepingId() {
			return housekeepingId;
		}
		public void setHousekeepingId(int housekeepingId) {
			this.housekeepingId = housekeepingId;
		}
		public Room getRoom() {
			return room;
		}
		public void setRoom(Room room) {
			this.room = room;
		}
		public Staff getStaff() {
			return staff;
		}
		public void setStaff(Staff staff) {
			this.staff = staff;
		}
		public LocalDate getDateCleaned() {
			return dateCleaned;
		}
		public void setDateCleaned(LocalDate dateCleaned) {
			this.dateCleaned = dateCleaned;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		
		public Housekeeping() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Housekeeping(Room room, Staff staff, LocalDate dateCleaned, String status, String notes) {
			super();
			this.room = room;
			this.staff = staff;
			this.dateCleaned = dateCleaned;
			this.status = status;
			this.notes = notes;
		}
		
}
