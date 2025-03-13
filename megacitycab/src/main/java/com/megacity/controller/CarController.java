package com.megacity.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.megacity.model.Car;
import com.megacity.service.CarService;


public class CarController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CarService carService;

    public CarController() {
        super();
    }

    @Override
    public void init() throws ServletException {
        carService = CarService.getInstance(); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            listCars(request, response);  
        } else if (action.equals("add")) {
            showAddForm(request, response);  
        } else if (action.equals("view")) {
            showCarDetails(request, response);  
        } else if (action.equals("delete")) {
            deleteCar(request, response); 
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("add")) {
            addCar(request, response);  
        } else if (action != null && action.equals("update")) {
            updateCar(request, response);  
        }
    }

   
    private void listCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> carList = new ArrayList<Car>();
        try {
            carList = carService.getAllCars();
            if (carList.isEmpty()) {
                System.out.println("No cars found.");
            } else {
                System.out.println(carList.size() + " cars found.");
            }
            request.setAttribute("cars", carList);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("WEB-INF/view/listCars.jsp").forward(request, response);
    }


   
    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/addCar.jsp").forward(request, response);
    }


    private void addCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carModel = request.getParameter("carModel");
        String color = request.getParameter("color");
        String availability = request.getParameter("availability");
        int noOfSeats = Integer.parseInt(request.getParameter("noOfSeats"));

        Car car = new Car();
        car.setCarModel(carModel);
        car.setColor(color);
        car.setAvailability(availability);
        car.setNoOfSeats(noOfSeats);

        try {
            carService.addCar(car);  
            response.sendRedirect("car?action=list");  
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        }
    }

   
    private void showCarDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carID = Integer.parseInt(request.getParameter("carID"));
        try {
            Car car = carService.getCarById(carID);
            request.setAttribute("car", car);
            request.getRequestDispatcher("/WEB-INF/view/carDetail.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        }
    }

    
    private void updateCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carID = Integer.parseInt(request.getParameter("carID"));
        String carModel = request.getParameter("carModel");
        String color = request.getParameter("color");
        String availability = request.getParameter("availability");
        int noOfSeats = Integer.parseInt(request.getParameter("noOfSeats"));

        Car car = new Car();
        car.setCarID(carID);
        car.setCarModel(carModel);
        car.setColor(color);
        car.setAvailability(availability);
        car.setNoOfSeats(noOfSeats);

        try {
            carService.updateCar(car);  
            response.sendRedirect("car?action=view&carID=" + carID);  
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        }
    }

   
    private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carID = Integer.parseInt(request.getParameter("carID"));

        try {
            carService.deleteCar(carID);  
            response.sendRedirect("car?action=list");  
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        }
    }
}
