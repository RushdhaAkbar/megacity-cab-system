package com.megacity.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.megacity.model.Customer;


public class CustomerDAO {

	    public void addCustomer(Customer customer) {
	        String userQuery = "INSERT INTO User (NIC, name, email, password) VALUES (?, ?, ?, ?)";
	        String customerQuery = "INSERT INTO Customer (userID, address, phoneNumber) VALUES (?, ?, ?)";
	        Connection connection = null;
	        PreparedStatement userStmt = null;
	        PreparedStatement customerStmt = null;

	        try {
	            connection = DBConnectionFactory.getConnection();
	            connection.setAutoCommit(false);

	           
	            userStmt = connection.prepareStatement(userQuery, Statement.RETURN_GENERATED_KEYS);
	            userStmt.setString(1, customer.getNIC());
	            userStmt.setString(2, customer.getName());
	            userStmt.setString(3, customer.getEmail());
	            userStmt.setString(4, customer.getPassword());
	            userStmt.executeUpdate();

	            
	            ResultSet rs = userStmt.getGeneratedKeys();
	            int userID = 0;
	            if (rs.next()) {
	                userID = rs.getInt(1);
	            }

	            customerStmt = connection.prepareStatement(customerQuery);
	            customerStmt.setInt(1, userID);
	            customerStmt.setString(2, customer.getAddress());
	            customerStmt.setString(3, customer.getPhoneNumber());
	            customerStmt.executeUpdate();
	            connection.commit(); 
	        } catch (SQLException e) {
	            try {
	                if (connection != null) {
	                    connection.rollback(); 
	                }
	            } catch (SQLException rollbackEx) {
	                rollbackEx.printStackTrace();
	            }
	            e.printStackTrace();
	        } finally {
	            try {
	                if (userStmt != null) userStmt.close();
	                if (customerStmt != null) customerStmt.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	   
	    public List<Customer> getAllCustomers() throws SQLException {
	        List<Customer> customers = new ArrayList<>();
	        String query = "SELECT U.userID, U.NIC, U.name, U.email, C.address, C.phoneNumber FROM User U JOIN Customer C ON U.userID = C.userID";

	        Connection connection = DBConnectionFactory.getConnection();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(query);

	        while (resultSet.next()) {
	            int userID = resultSet.getInt("userID");
	            String NIC = resultSet.getString("NIC");
	            String name = resultSet.getString("name");
	            String email = resultSet.getString("email");
	            String address = resultSet.getString("address");
	            String phoneNumber = resultSet.getString("phoneNumber");

	            customers.add(new Customer(userID, NIC, name, email, "", address, phoneNumber)); 
	        }

	        resultSet.close();
	        statement.close();
	        return customers;
	    }
	}


