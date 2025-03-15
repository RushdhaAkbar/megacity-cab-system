package com.megacity.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.megacity.model.Customer;
import com.megacity.service.CustomerService;




/**
 * Servlet implementation class CustomerContoller
 */

public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private CustomerService customerService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
        
    }
    public void init() throws ServletException {
        customerService = CustomerService.getInstance();
    }

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        if (action == null || action.equals("list")) {
            listCustomers(request, response);
        } else if (action.equals("add")) {
            showAddForm(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");
	        if (action != null && action.equals("add")) {
	            addCustomer(request, response);
	        } else {
	            doGet(request, response);
	        }
	}

	private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        try {
            customerList = customerService.getAllCustomers();
            request.setAttribute("customers", customerList);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("WEB-INF/view/listCustomers.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/addCustomer.jsp").forward(request, response);
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String nic = request.getParameter("nic");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");

        int userID = 0;
        Customer customer = new Customer(userID, nic, name, email, password, address, phoneNumber);
        customerService.addCustomer(customer);
                 response.sendRedirect("customers?action=list");
    }

}
