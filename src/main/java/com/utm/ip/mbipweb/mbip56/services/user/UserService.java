package com.utm.ip.mbipweb.mbip56.services.user;
import java.util.*;
import com.utm.ip.mbipweb.mbip56.models.user.User;
import com.utm.ip.mbipweb.mbip56.models.user.UserDAO;


public interface UserService {
    List<User> getAllUsers();
    User addUser(final User User);
    User getUserById(String id);
    User updateUser(final User user);
    public boolean deleteUser(String id); 
    User authenticateUser(String username, String password);
    List<UserDAO> getUsersWithUsage();
}
