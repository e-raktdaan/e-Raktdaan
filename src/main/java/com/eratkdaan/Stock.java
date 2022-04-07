package com.eratkdaan;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Stock {
	
	String b_Group;
	String expiry;
	String city;
	String phone;
	int quantity;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getB_Group() {
		return b_Group;
	}
	public void setB_Group(String b_Group) {
		this.b_Group = b_Group;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public Stock(String b_Group, String expiry, String city, String phone, int quantity) {
		
		this.b_Group = b_Group;
		this.expiry = expiry;
		this.city = city;
		this.phone = phone;
		this.quantity = quantity;
	}
	public Stock(String city) {
		this.city = city;
	}
	
	

}
