package com.eratkdaan;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Stock {
	
	String donorName;	
	String b_Group;
	String currDate;
	String city;
	String phone;
	String quantity;
	String age;
	
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
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getCurrDate() {
		return currDate;
	}

	public Stock(String b_Group,String currDate, String city, String phone, String quantity) {
		
		this.b_Group = b_Group;
		this.city = city;
		this.phone = phone;
		this.quantity = quantity;
		this.currDate=currDate;
	}
	public Stock(String city) {
		this.city = city;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setCurrDate(String currDate) {
		this.currDate = currDate;
	}
	public Stock(String donorname, String bgroup, String age, String quantity, String donorcity, String currDate) {
		this.donorName = donorname;
		this.b_Group = bgroup;
		this.age=age;
		this.quantity = quantity;
		this.city = donorcity;
		this.currDate=currDate;
		
	}
	
	

}
