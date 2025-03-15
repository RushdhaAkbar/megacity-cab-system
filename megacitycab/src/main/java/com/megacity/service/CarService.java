package com.megacity.service;

import java.sql.SQLException;
import java.util.List;

import com.megacity.dao.CarDAO;
import com.megacity.model.Car;

public class CarService {

    private static CarService instance;
    private CarDAO carDAO;

    private CarService() {
        this.carDAO = new CarDAO();
    }

    public static CarService getInstance() {
        if (instance == null) {
            synchronized (CarService.class) {
                if (instance == null) {
                    instance = new CarService();
                }
            }
        }
        return instance;
    }

    public void addCar(Car car) {
        carDAO.addCar(car);
    }

    public List<Car> getAllCars() throws SQLException {
        return carDAO.getAllCars();
    }

    public Car getCarById(int carID) throws SQLException {
        return carDAO.getCarById(carID);
    }

    public void updateCar(Car car) {
        carDAO.updateCar(car);
    }

    public void deleteCar(int carID) {
        carDAO.deleteCar(carID);
    }
}
