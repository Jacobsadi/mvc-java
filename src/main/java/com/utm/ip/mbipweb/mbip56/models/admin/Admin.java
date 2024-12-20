package com.utm.ip.mbipweb.mbip56.models.admin;

public class Admin {
    private String username;
    private String password;
    private String role;

    // Add other fields as needed

    // Default constructor
    public Admin() {
    }

    // Parameterized constructor
    public Admin(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        // Initialize other fields as needed
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Add other getters and setters for additional fields

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                // Add other fields to the toString representation
                '}';
    }
}
