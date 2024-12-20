package com.utm.ip.mbipweb.mbip56.models.user;

public class UserDAO {
    private int user_id;
    private String username;
    private String email; // New field for email
    private String password;
    private boolean role; // New property for user role
    private String contact; // New field for contact
    private String area; // New field for area

    // Default constructor
    public UserDAO() {
        this.user_id = 0;
        this.username = " ";
        this.email = " ";
        this.password = " ";
        this.role = false;
        this.contact = " ";
        this.area = " ";
    }

    // Parameterized constructor
    public UserDAO(int user_id, String username, String email, String password, boolean role, String contact,
            String area) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.contact = contact;
        this.area = area;
    }

    // Getter and Setter for user_id
    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for role
    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    // Getter and Setter for contact
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // Getter and Setter for area
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
