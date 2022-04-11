package com.eratkdaan;

public class PersonRegister {
	
	String fname;
	String lname;
	String password;
	String gender;
	String email;
	String phone;
	String bgroup;
	String city;
	String dob;
	
	
	public PersonRegister(String fname, String lname, String password, String gender, String email, String phone,
			String bgroup, String city, String dob) {
	
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.bgroup = bgroup;
		this.city = city;
		this.dob=dob;
	}
	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public PersonRegister(String email, String password) {
		this.email=email;
		this.password=password;
	}
	
	
	public PersonRegister(String fname) {
		this.fname= fname;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBgroup() {
		return bgroup;
	}
	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
