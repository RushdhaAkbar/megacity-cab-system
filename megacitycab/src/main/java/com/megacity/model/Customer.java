package com.megacity.model;

public class Customer extends User {
	private String address;
	private String phoneNumber;
	
	public Customer(int userID, String NIC, String name, String email, String password,String address,
			String phoneNumber) {
		super(userID, NIC, name, email, password);
		// TODO Auto-generated constructor stub
		this.address=address;
		this.phoneNumber=phoneNumber;
	}
	

}
