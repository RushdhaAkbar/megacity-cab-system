package com.megacity.model;

public class User {
	private int userID;
	private String NIC;
	private String name;
	private String email;
	private String password;
	
	public User(int userID,String NIC,String name,String email,String password) {
		this.email=email;
		this.userID=userID;
		this.NIC=NIC;
		this.name=name;
		this.password=password;
		
	}
}
