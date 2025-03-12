package com.megacity.model;

public class Car {
	private int carID;
	private String carModel;
	private String color;
	private Boolean availability;
	private int noOfSeats;
	
	public Car(int carID, String carModel, String color, Boolean availability, int noOfSeats) {
		this.carID = carID;
		this.carModel = carModel;
		this.color = color;
		this.availability = availability;
		this.noOfSeats = noOfSeats;
	}

	public Car(String carModel, String color, Boolean availability, int noOfSeats) {
		this.carModel = carModel;
		this.color = color;
		this.availability = availability;
		this.noOfSeats = noOfSeats;
	}

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	
	
}
