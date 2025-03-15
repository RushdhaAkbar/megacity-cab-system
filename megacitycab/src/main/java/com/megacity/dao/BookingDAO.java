package com.megacity.dao;


import com.megacity.model.Booking;
import com.megacity.service.DriverService;
import com.megacity.model.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private DriverService driverService;
    public BookingDAO() {
        this.driverService = DriverService.getInstance();
    }
	public void createBooking(Booking booking) {
	    String query = "INSERT INTO booking (userID, carID, pickup, destination, fare, status, driverID) VALUES (?, ?, ?, ?, ?, ?, NULL)";
	    Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        connection = DBConnectionFactory.getConnection();
	        statement = connection.prepareStatement(query);

	        statement.setInt(1, booking.getUserID());
	        statement.setInt(2, booking.getCarID());
	        statement.setString(3, booking.getPickup());
	        statement.setString(4, booking.getDestination());
	        statement.setDouble(5, booking.getFare());
	        statement.setString(6, "Pending");

	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) statement.close();
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


    public List<Booking> getAllBookings() throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking";

        try (Connection conn = DBConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                bookings.add(mapResultSetToBooking(rs));
            }
        }
        return bookings;
    }

    public List<Booking> getBookingsByUser(int userID) throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking WHERE userID = ?";

        try (Connection conn = DBConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                bookings.add(mapResultSetToBooking(rs));
            }
        }
        return bookings;
    }

    public Booking getBookingById(int bookingID) throws SQLException {
    	String query = "SELECT * FROM booking WHERE bookingID = ?";
        try (Connection conn = DBConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, bookingID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToBooking(rs);
            }
        }
        return null;
    }

    public void assignDriver(int bookingID, int driverID) throws SQLException {
        Driver driver = driverService.getDriverById(driverID);

        if (driver != null && "Available".equalsIgnoreCase(driver.getAvailability())) {
            Connection conn = DBConnectionFactory.getConnection();
            String query = "UPDATE booking SET driverID = ?, status = 'Assigned' WHERE bookingID = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, driverID);
                pstmt.setInt(2, bookingID);
                pstmt.executeUpdate();
            }

            
            driverService.updateDriverAvailability(driverID, "Not Available"); 
        } else {
            throw new SQLException("Driver is not available or does not exist.");
        }
    }



    private Booking mapResultSetToBooking(ResultSet rs) throws SQLException {
    	 int driverID = rs.getObject("driverID") != null ? rs.getInt("driverID") : -1;
        return new Booking(
        		rs.getInt("bookingID"),
                rs.getInt("userID"),
                rs.getInt("carID"),
                rs.getString("pickup"),
                rs.getString("destination"),
                rs.getDouble("fare"),
                rs.getString("status"),
                driverID
        );
    }
}
