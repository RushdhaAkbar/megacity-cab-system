package com.megacity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.megacity.model.User;
import com.megacity.dao.DBConnectionFactory;

public class UserDAO {

    public User getUserByEmail(String email) {
        String query = "SELECT * FROM User WHERE email = ?";
        User user = null;

        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setUserID(resultSet.getInt("userID")); 
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password")); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user; 
    }
}
