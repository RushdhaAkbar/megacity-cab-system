package com.megacity.service;

import com.megacity.model.Booking;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private List<Booking> bookings = new ArrayList<>();

    public Booking createBooking(Booking booking) {
        bookings.add(booking);
        return booking; 
    }
}
