package com.utm.ip.mbipweb.mbip56.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.utm.ip.mbipweb.mbip56.services.user.UserService;
import com.utm.ip.mbipweb.mbip56.models.user.User;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.addUser(user);
    }



}
