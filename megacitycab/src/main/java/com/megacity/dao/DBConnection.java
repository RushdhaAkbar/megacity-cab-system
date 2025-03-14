package com.megacity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/megacity-cab";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Rushdha123";

	private static DBConnection instance;
	private Connection connection;
	 private DBConnection() {
	        connect();
	    }

	private void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBConnection getInstance() {
		if (instance == null) {
			synchronized (DBConnection.class) {
				if (instance == null) {
					instance = new DBConnection();
				}
			}
		}
		return instance;
	}

	public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) { 
                connect();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
