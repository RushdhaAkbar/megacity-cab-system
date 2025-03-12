package com.megacity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.megacity.model.Car;

public class CarDAO {

    
    public void addCar(Car car) {
        String query = "INSERT INTO Car (carModel, color, availability, noOfSeats) VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, car.getCarModel());
            statement.setString(2, car.getColor());
            statement.setBoolean(3, car.getAvailability()); 
            statement.setInt(4, car.getNoOfSeats());
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

    
    public List<Car> getAllCars() throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM car";

        Connection connection = DBConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        
        while (resultSet.next()) {
            int carID = resultSet.getInt("carID");
            String carModel = resultSet.getString("carModel");
            String color = resultSet.getString("color");
            boolean availability = resultSet.getBoolean("availability");
            int noOfSeats = resultSet.getInt("noOfSeats");

            cars.add(new Car(carID, carModel, color, availability, noOfSeats));
        }

        resultSet.close();
        statement.close();
        return cars;
    }

    
    public Car getCarById(int carID) throws SQLException {
        Car car = null;
        String query = "SELECT * FROM car WHERE carID = ?";

        Connection connection = DBConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, carID);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String carModel = resultSet.getString("carModel");
            String color = resultSet.getString("color");
            boolean availability = resultSet.getBoolean("availability");
            int noOfSeats = resultSet.getInt("noOfSeats");

            car = new Car(carID, carModel, color, availability, noOfSeats);
        }

        resultSet.close();
        statement.close();
        return car;
    }

   
    public void updateCar(Car car) {
        String query = "UPDATE Car SET carModel = ?, color = ?, availability = ?, noOfSeats = ? WHERE carID = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, car.getCarModel());
            statement.setString(2, car.getColor());
            statement.setBoolean(3, car.getAvailability()); 
            statement.setInt(4, car.getNoOfSeats());
            statement.setInt(5, car.getCarID());
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

   
    public void deleteCar(int carID) {
        String query = "DELETE FROM Car WHERE carID = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, carID);
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
