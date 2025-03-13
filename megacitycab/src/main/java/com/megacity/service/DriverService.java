package com.megacity.service;

import java.sql.SQLException;
import java.util.List;

import com.megacity.dao.DriverDAO;
import com.megacity.model.Driver;

public class DriverService {

    private static DriverService instance;
    private DriverDAO driverDAO;

    private DriverService() {
        this.driverDAO = new DriverDAO();
    }

    public static DriverService getInstance() {
        if (instance == null) {
            synchronized (DriverService.class) {
                if (instance == null) {
                    instance = new DriverService();
                }
            }
        }
        return instance;
    }

    public void addDriver(Driver driver) {
        driverDAO.addDriver(driver);
    }

    public List<Driver> getAllDrivers() throws SQLException {
        return driverDAO.getAllDrivers();
    }

    public Driver getDriverById(int driverID) throws SQLException {
        return driverDAO.getDriverById(driverID);
    }

    public void updateDriver(Driver driver) {
        driverDAO.updateDriver(driver);
    }

    public void deleteDriver(int driverID) {
        driverDAO.deleteDriver(driverID);
    }
}
