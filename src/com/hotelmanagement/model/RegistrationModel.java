package com.hotelmanagement.model;

//POJO Class - Plain Old java object
//Beans
public class RegistrationModel {
	private String resturentName;
	private String ownerName;
	private String ownerEmail;
	private String phoneNo;
	private String username;
	private String password;

	public String getResturentName() {
		return resturentName;
	}

	public void setResturentName(String resturentName) {
		this.resturentName = resturentName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
