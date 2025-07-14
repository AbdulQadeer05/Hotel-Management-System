package com.model;
import javax.persistence.*;

@Entity
public class Servicess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;

    private String name;
    private String description;
    private String price;
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Servicess(String name, String description, String price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Servicess() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
