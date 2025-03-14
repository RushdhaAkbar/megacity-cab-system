package com.megacity.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.megacity.model.Driver;
import com.megacity.service.DriverService;




public class DriverController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DriverService driverService;

    public DriverController() {
        super();
    }

    @Override
    public void init() throws ServletException {
        driverService = DriverService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            listDrivers(request, response);
        } else if (action.equals("add")) {
            showAddForm(request, response);
        } else if (action.equals("view")) {
            showDriverDetails(request, response);
        } else if (action.equals("delete")) {
            deleteDriver(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("add")) {
            addDriver(request, response);
        } else if (action != null && action.equals("update")) {
            updateDriver(request, response);
        }
    }

    private void listDrivers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Driver> driverList = new ArrayList<>();
        try {
            driverList = driverService.getAllDrivers();
            if (driverList.isEmpty()) {
                System.out.println("No drivers found.");
            } else {
                System.out.println(driverList.size() + " drivers found.");
            }
            request.setAttribute("drivers", driverList);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("WEB-INF/view/listDrivers.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/addDriver.jsp").forward(request, response);
    }

    private void addDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String licenseNumber = request.getParameter("licenseNumber");
        String availability = request.getParameter("availability");
        String phoneNumber = request.getParameter("phoneNumber");

        Driver driver = new Driver();
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        driver.setAvailability(availability);
        driver.setPhoneNumber(phoneNumber);

        try {
            driverService.addDriver(driver);
            response.sendRedirect("driver?action=list");
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        }
    }

    private void showDriverDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int driverID = Integer.parseInt(request.getParameter("driverID"));
        try {
            Driver driver = driverService.getDriverById(driverID);
            request.setAttribute("driver", driver);
            request.getRequestDispatcher("/WEB-INF/view/driverDetail.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        }
    }

    private void updateDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int driverID = Integer.parseInt(request.getParameter("driverID"));
//        String name = request.getParameter("name");
//        String licenseNumber = request.getParameter("licenseNumber");
//        String availability = request.getParameter("availability");
//        String phoneNumber = request.getParameter("phoneNumber");
//
//        Driver driver = new Driver();
//        driver.setDriverID(driverID);
//        driver.setName(name);
//        driver.setLicenseNumber(licenseNumber);
//        driver.setAvailability(availability);
//        driver.setPhoneNumber(phoneNumber);
//
//        try {
//            driverService.updateDriver(driver);
//            response.sendRedirect("driver?action=view&driverID=" + driverID);
//        } catch (Exception e) {
//            request.setAttribute("errorMessage", e.getMessage());
//            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
//        }
    }

    private void deleteDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int driverID = Integer.parseInt(request.getParameter("driverID"));

        try {
            driverService.deleteDriver(driverID);
            response.sendRedirect("driver?action=list");
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
        }
    }
}
