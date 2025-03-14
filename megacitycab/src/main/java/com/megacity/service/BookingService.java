package com.megacity.service;

import com.megacity.dao.BookingDAO;
import com.megacity.model.Booking;

import java.sql.SQLException;
import java.util.List;

public class BookingService {
    private static BookingService instance;
    private BookingDAO bookingDAO;

    private BookingService() {
        bookingDAO = new BookingDAO();
    }

    public static BookingService getInstance() {
        if (instance == null) {
            synchronized (CarService.class) {
                if (instance == null) {
                    instance = new BookingService();
                }
            }
        }
        return instance;
    }

    public void createBooking(Booking booking)  {
        bookingDAO.createBooking(booking);
    }

    public List<Booking> getAllBookings() throws SQLException {
        return bookingDAO.getAllBookings();
    }

    public List<Booking> getBookingsByUser(int userID) throws SQLException {
        return bookingDAO.getBookingsByUser(userID);
    }

    public Booking getBookingById(int bookingID) throws SQLException {
        return bookingDAO.getBookingById(bookingID);
    }

    public void assignDriver(int bookingId, int driverID) throws SQLException {
        bookingDAO.assignDriver(bookingId, driverID);
    }
}
