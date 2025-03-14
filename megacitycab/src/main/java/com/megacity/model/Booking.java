package com.megacity.model;

public class Booking {
    private int bookingID;
    private int userID;
    private int carID;
    private String pickup;
    private String destination;
    private double fare;
    private String status;
    private int driverID; 

    public Booking(int bookingID,int userID, int carID, String pickup, String destination, double fare, String status, int driverID) {
        this.bookingID=bookingID;
    	this.userID = userID;
        this.carID = carID;
        this.pickup=pickup;
        this.destination = destination;
        this.fare = fare;
        this.status = status;
        this.driverID = driverID;
    }

	



	
	public Booking() {
		// TODO Auto-generated constructor stub
	}






	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}



}
