package com.utm.ip.mbipweb.mbip56.models.admin;

public class AdminDAO {
    private String id;
    private String username;
    private String password;
    // Add other fields as needed

    // Default constructor
    public AdminDAO() {
        this.username = " ";
        this.password = " ";
    }

    // Parameterized constructor
    public AdminDAO(String username, String password) {
        this.username = username;
        this.password = password;
        // Initialize other fields as needed
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }
    public String getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Add other getters and setters for additional fields

    @Override
    public String toString() {
        return "AdminDAO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                // Add other fields to the toString representation
                '}';
    }
}

