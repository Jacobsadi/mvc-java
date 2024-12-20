package com.utm.ip.mbipweb.mbip56.models.user;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository {
    List<UserDAO> getAllUsers();
    UserDAO addUser(final UserDAO User);
    UserDAO getUserById(String id);
    UserDAO updateUser(final UserDAO user);
    public boolean deleteUser(String id); 
    UserDAO authenticateUser(String username, String password);
    public List<UserDAO> getUsersWithUsage();

}
