package com.utm.ip.mbipweb.mbip56.services.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.utm.ip.mbipweb.mbip56.models.user.User;
import com.utm.ip.mbipweb.mbip56.models.user.UserDAO;
import com.utm.ip.mbipweb.mbip56.models.user.UserRepository;

public class UserService_Database implements UserService {
    @Autowired
    UserRepository repo;

    public List<User> getAllUsers() {
        List<UserDAO> daos = repo.getAllUsers();
        List<User> users = new ArrayList<>();
        for (UserDAO dao : daos) {
            users.add(new User(dao));
        }
        return users;
    }

    public User addUser(final User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.setUsername(user.getUsername());
        userDAO.setPassword(user.getPassword());
        userDAO.setArea(user.getArea());
        userDAO.setContact(user.getContact());
        userDAO.setEmail(user.getEmail());

        // Set other properties based on your registration form and User model
        repo.addUser(userDAO);
        return user;
    }
        // // Getter and Setter for email
        // public String getEmail() {
        //     return email;
        // }
    
        // public void setEmail(String email) {
        //     this.email = email;
        // }
    
        // // Getter and Setter for password
        // public String getPassword() {
        //     return password;
        // }

    public User getUserById(String id) {
        return null;
    }

    public User updateUser(final User user) {
        return user;
    }

    public boolean deleteUser(String id) {
        return false;
    }

    public User authenticateUser(String username, String password) {
        List<UserDAO> allUsers = repo.getAllUsers();

        for (UserDAO dao : allUsers) {
            if (dao.getUsername().equals(username) && dao.getPassword().equals(password)) {
                return new User(dao);
            }
        }

        return null; // Authentication failed
    }
        @Override
    public List<UserDAO> getUsersWithUsage() {

        final List<UserDAO> list = repo.getUsersWithUsage();
        

        return list;
    }
}
