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

import com.megacity.model.Car;
import com.megacity.model.User;
import com.megacity.service.CarService;
import com.megacity.service.UserService;


public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;
    private CarService carService;
    public LoginController() {
        super();
    }

    public void init() throws ServletException {
        userService = UserService.getInstance();
        carService = CarService.getInstance();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.equals("login")) {
            showLoginForm(request, response);
        } else if (action.equals("logout")) {
            logout(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            try {
				login(request, response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            doGet(request, response);
        }
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorMessage", "Email and Password are required!");
            request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
            return;
        }

        User user = userService.validateUser(email, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);

           
            if ("admin@gmail.com".equals(email)) {
              
            	 request.getRequestDispatcher("/WEB-INF/view/adminDashboard.jsp").forward(request, response);
            } else {
            	
            	List<Car> carList = new ArrayList<Car>();
            	carList = carService.getAllCars();
            	request.setAttribute("cars", carList);
            	request.getRequestDispatcher("/WEB-INF/view/dashboard.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Invalid email or password!");
            request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
        }
    }


    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); 
        }
        response.sendRedirect("login.jsp");
    }
}
