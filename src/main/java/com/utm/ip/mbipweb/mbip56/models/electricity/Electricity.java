package com.utm.ip.mbipweb.mbip56.models.electricity;

import java.time.LocalDate;

public class Electricity {
    private int electricityID;
    private int userID;  // Corrected to match the type in User class
    private LocalDate dateRecorded;
    private float electricityUsage;

    // Default constructor
    public Electricity() {
    }

    // Parameterized constructor
    public Electricity(int electricityID, int userID, LocalDate dateRecorded, float electricityUsage) {
        this.electricityID = electricityID;
        this.userID = userID;
        this.dateRecorded = dateRecorded;
        this.electricityUsage = electricityUsage;
    }

    // Getters and setters for all fields
    public int getElectricityID() {
        return electricityID;
    }

    public void setElectricityID(int electricityID) {
        this.electricityID = electricityID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public LocalDate getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public float getElectricityUsage() {
        return electricityUsage;
    }

    public void setElectricityUsage(float electricityUsage) {
        this.electricityUsage = electricityUsage;
    }
    
    public void fromDAO(final ElectricityDAO dao) {
        this.electricityID = dao.getElectricityID();
        this.userID = dao.getUserID();
        this.dateRecorded = dao.getDateRecorded();
        this.electricityUsage = dao.getElectricityUsage();

    }

    public ElectricityDAO toDAO() {
        ElectricityDAO dao = new ElectricityDAO();
        dao.setElectricityID(this.electricityID);
        dao.setUserID(this.userID);
        dao.setDateRecorded(this.dateRecorded);
        dao.setElectricityUsage(this.electricityUsage);
        return dao;
    }
    public Electricity(ElectricityDAO dao) {
        this.fromDAO(dao);
    }

    @Override
    public String toString() {
        return "Electricity{" +
                "electricityID=" + electricityID +
                ", userID='" + userID + '\'' +
                ", dateRecorded='" + dateRecorded + '\'' +
                ", electricityUsage=" + electricityUsage +
                '}';
    }
}
