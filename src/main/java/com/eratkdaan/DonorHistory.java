package com.eratkdaan;

public class DonorHistory {
	
	String referenceId;
	String dcity;
	String ddate;
	String quantity;
	String organisationName;
	
	
	public DonorHistory(String referenceId, String dcity, String ddate, String quantity, String organisationName) {

		this.referenceId = referenceId;
		this.dcity = dcity;
		this.ddate = ddate;
		this.quantity = quantity;
		this.organisationName = organisationName;
	}
	
	
	public DonorHistory(String referenceId) {
		this.referenceId=referenceId;
		// TODO Auto-generated constructor stub
	}


	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getDcity() {
		return dcity;
	}
	public void setDcity(String dcity) {
		this.dcity = dcity;
	}
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getOrganisationName() {
		return organisationName;
	}
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}
	

}
