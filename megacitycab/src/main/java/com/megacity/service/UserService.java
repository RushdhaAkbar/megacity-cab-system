package com.megacity.service;

import com.megacity.dao.UserDAO;
import com.megacity.model.User;

public class UserService {

    private static UserService instance;
    private UserDAO userDAO;

    
    private UserService() {
        this.userDAO = new UserDAO();
    }
   
    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    instance = new UserService(); 
                }
            }
        }
        return instance;
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
    
    public int getUserIDByEmail(String email) {
        return userDAO.getUserIDByEmail(email);
    }
}
