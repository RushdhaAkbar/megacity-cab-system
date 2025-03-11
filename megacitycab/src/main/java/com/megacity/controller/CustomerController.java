package com.megacity.controller;

import java.io.IOException;
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
@WebServlet("/customers")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private CustomerService customerService = new CustomerService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
        this.customerService = new CustomerService(); 
    }

	public CustomerController(CustomerService customerService) {
		// TODO Auto-generated constructor stub
		this.customerService = new CustomerService(); 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public String registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerService.registerCustomer(customer);
	}

}
