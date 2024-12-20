package com.utm.ip.mbipweb.mbip56.models.user;

import com.utm.ip.mbipweb.mbip56.models.water.Water;
import com.utm.ip.mbipweb.mbip56.models.electricity.Electricity;
import com.utm.ip.mbipweb.mbip56.models.recycle.Recycle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private int user_id;
    private String username;
    private String email; // Added email field
    private String password;
    private boolean role;
    private String contact; // New field for contact number
    private String area; // New field for area
    private Water water;
    private Electricity electricity;
    private Recycle recycle;

    private List<Water> waterList; // Changed Water to List<Water>
    private List<Electricity> electricityList; // Changed Electricity to List<Electricity>
    private List<Recycle> recycleList; // Changed Recycle to List<Recycle>

    // Default constructor
    public User() {
        waterList = new ArrayList<>(); // Initialize waterList
        electricityList = new ArrayList<>(); // Initialize electricityList
        recycleList = new ArrayList<>(); // Initialize recycleList
    }
    public User( String username, String email, String password, String contact, String area) {
        
        this.username = username;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.area = area;
    }
    // Parameterized constructor
    public User(int user_id, String username, String email, String password, boolean role, String contact,
            String area) {
        this.user_id = user_id;
        this.username = username;
        this.email = email; // Set email
        this.password = password;
        this.role = role;
        this.contact = contact;
        this.area = area;
        waterList = new ArrayList<>(); // Initialize waterList
        electricityList = new ArrayList<>(); // Initialize electricityList
        recycleList = new ArrayList<>(); // Initialize recycleList
    }

    // Getters and setters for all fields
    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Water getWater() {
        return water;
    }

    public Electricity getElectricity() {
        return electricity;
    }

    public void setUserWaterUsage(Water water) {
        this.water = water;
    }

    public void setUserElectricity(Electricity electricity) {
        this.electricity = electricity;
    }

    public float getRecycleUsage() {
        return recycle.getRecycleUsage();
    }

    public float getUserElectricityUsage() {
        return electricity.getElectricityUsage();
    }

    public Recycle getRecycle() {
        return recycle;
    }

    public void setUserRecycle(Recycle recycle) {
        this.recycle = recycle;
    }

      // Getter for waterList
      public List<Water> getWaterList() {
        return waterList;
    }

    // Setter for waterList
    public void setWaterList(List<Water> waterList) {

        this.waterList = waterList;
    }

    // Add a single water object to waterList
    public void addWater(Water water) {
        this.waterList.add(water);
    }

    // Getter for electricityList
    public List<Electricity> getElectricityList() {
        // System.out.println("Content of electricityListelectricityListelectricityListelectricityList:");
        // for (Electricity electricity : electricityList) {
        //     System.out.println("Electricity Usage: " + electricity.getElectricityUsage());
        //     // Print other properties as needed
        // }
        return electricityList;

    }

    // Setter for electricityList
    public void setElectricityList(List<Electricity> electricityList) {


            this.electricityList = electricityList;

    }
    

    // Add a single electricity object to electricityList
    public void addElectricity(Electricity electricity) {
        this.electricityList.add(electricity);
    }

    // Getter for recycleList
    public List<Recycle> getRecycleList() {
        return recycleList;
    }

    // Setter for recycleList
    public void setRecycleList(List<Recycle> recycleList) {
        this.recycleList = recycleList;
    }

    // Add a single recycle object to recycleList
    public void addRecycle(Recycle recycle) {
        this.recycleList.add(recycle);
    }

    // Additional method to initialize from UserDAO
    public void fromDAO(final UserDAO dao) {
        this.user_id = dao.getUserId();
        this.username = dao.getUsername();
        this.email = dao.getEmail(); // Make sure to include this line
        this.password = dao.getPassword();
        this.role = dao.isRole();
        this.contact = dao.getContact();
        this.area = dao.getArea();
    }

    public UserDAO toDAO() {
        UserDAO dao = new UserDAO();
        dao.setUserId(this.user_id);
        dao.setUsername(this.username);
        dao.setPassword(this.password);
        dao.setEmail(this.email);
        dao.setArea(this.area);
        dao.setContact(this.contact);
        dao.setRole(this.role);
        return dao;
    }

    // Constructor that accepts UserDAO
    public User(final UserDAO dao) {
        this.fromDAO(dao);
    }
    public void printWaterList() {
        System.out.println("Water List:");
        for (Water water : waterList) {

            System.out.println("DateRecorded: " + water.getDateRecorded());
            System.out.println("WaterUsage: " + water.getWaterUsage());
        }
    }
    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' + // Include email in toString
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", contact='" + contact + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
