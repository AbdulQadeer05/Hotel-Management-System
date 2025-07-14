package com.model;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	@ManyToOne
	@JoinColumn(name = "reservationId")
	private RoomBooking roomBoking;
	private LocalDate PaymentDate;
	private String amount;
	private String paymentMethod;
	private String paymentStatus;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public RoomBooking getRoomBoking() {
		return roomBoking;
	}
	public void setRoomBoking(RoomBooking roomBoking) {
		this.roomBoking = roomBoking;
	}
	public LocalDate getPaymentDate() {
		return PaymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		PaymentDate = paymentDate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	public Payment(RoomBooking roomBoking, LocalDate paymentDate, String amount, String paymentMethod, String paymentStatus) {
	    this.roomBoking = roomBoking;
	    this.PaymentDate = paymentDate;
	    this.amount = amount;
	    this.paymentMethod = paymentMethod;
	    this.paymentStatus = paymentStatus;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
