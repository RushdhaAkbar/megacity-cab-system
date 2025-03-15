package com.megacity.model;

public class Customer extends User {
	private String address;
	private String phoneNumber;
	
	public Customer(int userID, String NIC, String name, String email, String password,String address,
			String phoneNumber) {
		super(userID, NIC, name, email, password);
		// TODO Auto-generated constructor stub
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
	}
 

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}
