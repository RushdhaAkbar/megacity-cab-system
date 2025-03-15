package com.megacity.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.megacity.model.Booking;
import com.megacity.model.Car;
import com.megacity.model.Driver;
import com.megacity.model.User;
import com.megacity.service.BookingService;
import com.megacity.service.CarService;
import com.megacity.service.DriverService;
import com.megacity.service.UserService;

public class BookingController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookingService bookingService;
    private CarService carService;
    private DriverService driverService;
    
    public BookingController() {
        super();
    }

    @Override
    public void init() throws ServletException {
        bookingService = BookingService.getInstance();
        carService = CarService.getInstance();
        driverService = DriverService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            listBookings(request, response);
        } else if (action.equals("view")) {
            showBookingDetails(request, response);
        } else if (action.equals("assignDriver")) {
            assignDriver(request, response);
        } else if (action.equals("create")) { 
            showBookingForm(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("create")) {
            try {
				createBooking(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if (action != null && action.equals("assignDriver")) {
            assignDriver(request, response);
        }
    }

    
    
    private void redirectToCreateBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int carID = Integer.parseInt(request.getParameter("carID"));
        String pickup = request.getParameter("pickup");
        String destination = request.getParameter("destination");
        double fare = Double.parseDouble(request.getParameter("fare"));

        Booking booking = new Booking();

        try {
            bookingService.createBooking(booking);
            response.sendRedirect("booking?action=list");
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        }
    }

    
    private void listBookings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
        	List<Booking> bookingList = new ArrayList<Booking>();
            if ("admin@gmail.com".equals(user.getEmail())) {
            	bookingList = bookingService.getAllBookings();
                
               
            	List<Driver> driverList = new ArrayList<>();
            	driverList= driverService.getAllDrivers();
                request.setAttribute("bookings", bookingList);
                request.setAttribute("drivers", driverList);
                request.getRequestDispatcher("WEB-INF/view/adminBookings.jsp").forward(request, response);
            } else {
            	bookingList = bookingService.getBookingsByUser(user.getUserID());
                request.setAttribute("bookings", bookingList);
                request.getRequestDispatcher("WEB-INF/view/userBookings.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
        }
    }


    
    private void showBookingDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookingID = Integer.parseInt(request.getParameter("bookingID"));

        try {
            Booking booking = bookingService.getBookingById(bookingID);
            request.setAttribute("booking", booking);
            request.getRequestDispatcher("/WEB-INF/view/bookingDetail.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        }
    }

   
    private void createBooking(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }

       
        int userID = UserService.getInstance().getUserIDByEmail(loggedInUser.getEmail());
        
        int carID = Integer.parseInt(request.getParameter("carID"));
        String pickup = request.getParameter("pickup");
        String destination = request.getParameter("destination");
        double fare = Double.parseDouble(request.getParameter("fare"));

        Booking booking = new Booking();
        booking.setUserID(userID);
        booking.setCarID(carID);
        booking.setPickup(pickup);
        booking.setDestination(destination);
        booking.setFare(fare);

        try {
            bookingService.createBooking(booking);  
            response.sendRedirect("booking?action=list");  
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        }
    }



   
    private void assignDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null || !"admin@gmail.com".equals(user.getEmail())) { 
            response.sendRedirect("error.jsp");
            return;
        }

        try {
            int bookingID = Integer.parseInt(request.getParameter("bookingID"));
            int driverID = Integer.parseInt(request.getParameter("driverID"));

           
            bookingService.assignDriver(bookingID, driverID);

           
            DriverService.getInstance().updateDriverAvailability(driverID, "Unavailable");

            response.sendRedirect("booking?action=list");
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid driver or booking ID.");
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        }
    }


    private void showBookingForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

       
        String carID = request.getParameter("carID");
        if (carID != null) {
            request.setAttribute("carID", carID);
        }

        request.getRequestDispatcher("WEB-INF/view/createBooking.jsp").forward(request, response);
    }
}
