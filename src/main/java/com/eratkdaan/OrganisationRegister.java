package com.eratkdaan;

public class OrganisationRegister {
	
	String o_name;
	String o_type;
	String ownedBy;
	String password;
	String email;
	String phone;
	String alternatePhone;
	String city;
	
	
	public OrganisationRegister(String o_name, String o_type, String ownedBy, String password, String email,
			String phone, String alternatePhone, String city) {
		
		this.o_name = o_name;
		this.o_type = o_type;
		this.ownedBy = ownedBy;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.alternatePhone = alternatePhone;
		this.city = city;
	}


	public String getO_name() {
		return o_name;
	}


	public void setO_name(String o_name) {
		this.o_name = o_name;
	}


	public String getO_type() {
		return o_type;
	}


	public void setO_type(String o_type) {
		this.o_type = o_type;
	}


	public String getOwnedBy() {
		return ownedBy;
	}


	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public String getAlternatePhone() {
		return alternatePhone;
	}


	public void setAlternatePhone(String alternatePhone) {
		this.alternatePhone = alternatePhone;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	

}


