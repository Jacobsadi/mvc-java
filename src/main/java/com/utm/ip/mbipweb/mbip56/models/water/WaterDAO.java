package com.utm.ip.mbipweb.mbip56.models.water;

import java.time.LocalDate;

public class WaterDAO {
    private int waterID;
    private int userID;
    private LocalDate dateRecorded;
    private float waterUsage;

    // Default constructor
    public WaterDAO() {
        this.waterID = 0;
        this.userID = 0;
        this.dateRecorded = null;
        this.waterUsage = 0.0f;
    }

    // Parameterized constructor
    public WaterDAO(int waterID, int userID, LocalDate dateRecorded, float waterUsage) {
        this.waterID = waterID;
        this.userID = userID;
        this.dateRecorded = dateRecorded;
        this.waterUsage = waterUsage;
    }

    // Getter and Setter for waterID
    public int getWaterID() {
        return waterID;
    }

    public void setWaterID(int waterID) {
        this.waterID = waterID;
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

    // Getter and Setter for waterUsage
    public float getWaterUsage() {
        return waterUsage;
    }

    public void setWaterUsage(float waterUsage) {
        this.waterUsage = waterUsage;
    }
}
