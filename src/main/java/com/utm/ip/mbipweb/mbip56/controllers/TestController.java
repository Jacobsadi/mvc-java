package com.utm.ip.mbipweb.mbip56.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utm.ip.mbipweb.mbip56.models.admin.Admin;
import com.utm.ip.mbipweb.mbip56.models.admin.AdminDAO;
import com.utm.ip.mbipweb.mbip56.models.admin.AdminRepository;


@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/checkDatabaseConnection")
    @ResponseBody
    public String checkDatabaseConnection() {
        try {
            // Query to retrieve data from the database
            String sql = "SELECT * FROM admin_table LIMIT 1"; // Replace with your actual table name
            List<AdminDAO> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AdminDAO.class));
    
            if (!result.isEmpty()) {
                // Assuming AdminDAO has appropriate getters for the columns
                AdminDAO firstRow = result.get(0);
                
                // Use the toString method to get a string representation of the object
                return "Database connection is successful! First row data: " + firstRow.toString();
            } else {
                return "No data retrieved from the database.";
            }
        } catch (Exception e) {
            return "Error connecting to the database: " + e.getMessage();
        }
    }
    



}