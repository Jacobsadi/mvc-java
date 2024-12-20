package com.utm.ip.mbipweb.mbip56.models.water;

import java.time.LocalDate;

import com.utm.ip.mbipweb.mbip56.models.electricity.ElectricityDAO;
import com.utm.ip.mbipweb.mbip56.models.recycle.RecycleDAO;

public class Water {
    private int waterID;
    private int userID;  // Corrected to match the type in User class
    private LocalDate dateRecorded;
    private float waterUsage;

    // Default constructor
    public Water() {
    }

    // Parameterized constructor
    public Water(int waterID, int userID, LocalDate dateRecorded, float waterUsage) {
        this.waterID = waterID;
        this.userID = userID;
        this.dateRecorded = dateRecorded;
        this.waterUsage = waterUsage;
    }

    // Getters and setters for all fields
    public int getWaterID() {
        return waterID;
    }

    public void setWaterID(int waterID) {
        this.waterID = waterID;
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

    public float getWaterUsage() {
        return waterUsage;
    }

    public void setWaterUsage(float waterUsage) {
        this.waterUsage = waterUsage;
    }
    public void fromDAO(final WaterDAO dao) {
        this.waterID = dao.getWaterID();
        this.userID = dao.getUserID();
        this.dateRecorded = dao.getDateRecorded();
        this.waterUsage = dao.getWaterUsage();
    }
    //     public void fromDAO(final ElectricityDAO dao) {
    //     this.electricityID = dao.getElectricityID();
    //     this.userID = dao.getUserID();
    //     this.dateRecorded = dao.getDateRecorded();
    //     this.electricityUsage = dao.getElectricityUsage();

    // }

    public WaterDAO toDAO() {
        WaterDAO dao = new WaterDAO();
        dao.setWaterID(this.waterID);
        dao.setUserID(this.userID);
        dao.setDateRecorded(this.dateRecorded);
        dao.setWaterUsage(this.waterUsage);
        return dao;
    }
    public Water(WaterDAO dao) {
        this.fromDAO(dao);
    }

    @Override
    public String toString() {
        return "Water{" +
                "waterID=" + waterID +
                ", userID='" + userID + '\'' +
                ", dateRecorded='" + dateRecorded + '\'' +
                ", waterUsage=" + waterUsage +
                '}';
    }
}
