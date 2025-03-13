package com.megacity.model;

public class Driver {
	private int driverID;
	private String name;
	private String licenseNumber;
	private String availability;
	private String phoneNumber;
	
		
	public Driver(int driverID, String name, String licenseNumber, String availability, String phoneNumber) {
		this.driverID = driverID;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.availability = availability;
		this.phoneNumber = phoneNumber;
	}
	
	
	
	public Driver(String name, String licenseNumber, String availability, String phoneNumber) {
		
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.availability = availability;
		this.phoneNumber = phoneNumber;
	}



	public Driver() {
		// TODO Auto-generated constructor stub
	}



	public int getDriverID() {
		return driverID;
	}
	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
