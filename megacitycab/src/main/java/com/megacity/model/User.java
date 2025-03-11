package com.megacity.model;

public class User {
	private int userID;
	private String NIC;
	private String name;
	private String email;
	private String password;
	
	public User(int userID,String NIC,String name,String email,String password) {
		this.email=email;
		this.setUserID(userID);
		this.NIC=NIC;
		this.name=name;
		this.password=password;
		
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
