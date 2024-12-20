package com.utm.ip.mbipweb.mbip56.models.electricity;
import java.time.LocalDate;

public class ElectricityDAO {
    private int electricityID;
    private int userID;
    private LocalDate dateRecorded;
    private float electricityUsage;

    // Default constructor
    public ElectricityDAO() {
        this.electricityID = 0;
        this.userID = 0;
        this.dateRecorded = null;
        this.electricityUsage = 0.0f;
    }

    // Parameterized constructor
    public ElectricityDAO(int electricityID, int userID, LocalDate dateRecorded, float electricityUsage) {
        this.electricityID = electricityID;
        this.userID = userID;
        this.dateRecorded = dateRecorded;
        this.electricityUsage = electricityUsage;
    }

    // Getter and Setter for electricityID
    public int getElectricityID() {
        return electricityID;
    }

    public void setElectricityID(int electricityID) {
        this.electricityID = electricityID;
    }

    // Getter and Setter for userID
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    // Getter and Setter for dateRecorded
    public LocalDate getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    // Getter and Setter for electricityConsumption
    public float getElectricityUsage() {
        return electricityUsage;
    }

    public void setElectricityUsage(float electricityUsage) {
        this.electricityUsage = electricityUsage;
    }
}
