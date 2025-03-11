package com.megacity.service;

import com.megacity.dao.UserDAO;
import com.megacity.model.User;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User validateUser(String email, String password) {
        
        if (email == null || password == null) {
            return null;
        }

        User user = userDAO.getUserByEmail(email);
               if (user != null && user.getPassword().equals(password)) {
            return user; 
        }

        return null;
    }
}
