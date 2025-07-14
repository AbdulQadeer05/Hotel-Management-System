package com.model;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;
	@ManyToOne
	@JoinColumn(name = "hotelId")
	private Hotel hotel;
	private String firstName;
	private String lastName;
	private String cnic;
	private String phone;
	private String position;
	private LocalDate hireDate;
	private String salary;
	private String shift;
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public Staff(Hotel hotel, String firstName, String lastName, String cnic, String phone, String position,
			LocalDate hireDate, String salary, String shift) {
		this.hotel = hotel;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cnic = cnic;
		this.phone = phone;
		this.position = position;
		this.hireDate = hireDate;
		this.salary = salary;
		this.shift = shift;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}


}
