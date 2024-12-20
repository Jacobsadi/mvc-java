package com.utm.ip.mbipweb.mbip56.models.recycle;

import java.sql.Timestamp;
import java.time.LocalDate;

import com.utm.ip.mbipweb.mbip56.models.electricity.ElectricityDAO;

public class Recycle {
    private int recycleID;
    private int userID;
    // private String month;
    private LocalDate dateRecorded;
    private float recycleUsage;

    // Default constructor
    public Recycle() {
    }

    // Parameterized constructor
    public Recycle(int recycleID, int userID, String month, LocalDate dateRecorded, float recycleAmount) {
        this.recycleID = recycleID;
        this.userID = userID;
        // this.month = month;
        this.dateRecorded = dateRecorded;
        this.recycleUsage = recycleAmount;
    }

    // Getters and setters for all fields
    public int getRecycleID() {
        return recycleID;
    }

    public void setRecycleID(int recycleID) {
        this.recycleID = recycleID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    // public String getMonth() {
    // return month;
    // }

    // public void setMonth(String month) {
    // this.month = month;
    // }

    public LocalDate getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public float getRecycleUsage() {
        return recycleUsage;
    }

    public void setRecycleUsage(float recycleAmount) {
        this.recycleUsage = recycleAmount;
    }

    // Add conversion methods from DAO if necessary
    // ...

    public void fromDAO(final RecycleDAO dao) {
        this.recycleID = dao.getRecycleId(); // Corrected method name
        this.userID = dao.getUserID();
        this.dateRecorded = dao.getDateRecorded();
        this.recycleUsage = dao.getRecycleUsage();
        // this.month = dao.getMonth();
    }

    public RecycleDAO toDAO() {
        RecycleDAO dao = new RecycleDAO();
        dao.setRecycleId(this.recycleID); // Corrected method name
        dao.setUserID(this.userID);
        dao.setDateRecorded(this.dateRecorded);
        // dao.setMonth(this.month);
        dao.setRecycleUsage(this.recycleUsage);
        return dao;
    }

    // // Inside your Recycle class
    // public RecycleDAO toDAO() {
    //     RecycleDAO dao = new RecycleDAO();
    //     dao.setRecycleId(this.getRecycleID());
    //     dao.setUserId(this.getUserID());
    //     dao.setDate(this.getDateRecorded());
    //     dao.setRecycleAmount(this.getRecycleAmount());
    //     return dao;
    // }

    // Constructor to create from DAO
    public Recycle(RecycleDAO dao) {
        this.fromDAO(dao);
    }

    @Override
    public String toString() {
        return "Recycle{" +
                "recycleID=" + recycleID +
                ", userID=" + userID +
                // ", month='" + month + '\'' +
                ", dateRecorded=" + dateRecorded +
                ", recycleAmount=" + recycleUsage +
                '}';
    }
}
