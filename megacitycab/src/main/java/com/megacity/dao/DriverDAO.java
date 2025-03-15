package com.megacity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.megacity.model.Driver;

public class DriverDAO {

    public void addDriver(Driver driver) {
        String query = "INSERT INTO driver (name, licenseNumber, availability, phoneNumber) VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);

            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenseNumber());
            statement.setString(3, driver.getAvailability());
            statement.setString(4, driver.getPhoneNumber());

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

    public List<Driver> getAllDrivers() throws SQLException {
        List<Driver> drivers = new ArrayList<>();
        String query = "SELECT * FROM driver";

        Connection connection = DBConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int driverID = resultSet.getInt("driverID");
            String name = resultSet.getString("name");
            String licenseNumber = resultSet.getString("licenseNumber");
            String availability = resultSet.getString("availability");
            String phoneNumber = resultSet.getString("phoneNumber");

            drivers.add(new Driver(driverID, name, licenseNumber, availability, phoneNumber));
        }

        resultSet.close();
        statement.close();
        return drivers;
    }

    public Driver getDriverById(int driverID) throws SQLException {
        Driver driver = null;
        String query = "SELECT * FROM driver WHERE driverID = ?";

        Connection connection = DBConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, driverID);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String licenseNumber = resultSet.getString("licenseNumber");
            String availability = resultSet.getString("availability");
            String phoneNumber = resultSet.getString("phoneNumber");

            driver = new Driver(driverID, name, licenseNumber, availability, phoneNumber);
        }

        resultSet.close();
        statement.close();
        return driver;
    }

    public void updateDriverAvailability(int driverID, String availability) throws SQLException {
        Connection connection = DBConnectionFactory.getConnection();
        String query = "UPDATE driver SET availability=? WHERE driverID=?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
        	statement.setString(1, availability);
        	statement.setInt(2, driverID);
        	statement.executeUpdate();
        }
    }
    public void deleteDriver(int driverID) {
        String query = "DELETE FROM driver WHERE driverID = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, driverID);
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
}
