package com.utm.ip.mbipweb.mbip56.models.recycle;

import java.sql.Timestamp;
import java.time.LocalDate;

public class RecycleDAO {
    private int recycleId;
    private int userID;
    // private String month;
    private LocalDate DateRecorded;
    private float recycleUsage;

    public RecycleDAO() {
    }

    public RecycleDAO(int recycleId, int userId, LocalDate date, float recycleAmount) {
        this.recycleId = recycleId;
        this.userID = userId;
        // this.month = month;
        this.DateRecorded = date;
        this.recycleUsage = recycleAmount;
    }

    

    // Getters and setters
    public int getRecycleId() {
        return recycleId;
    }

    public void setRecycleId(int recycleId) {
        this.recycleId = recycleId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userId) {
        this.userID = userId;
    }

    // public String getMonth() {
    //     return month;
    // }

    // public void setMonth(String month) {
    //     this.month = month;
    // }

    public LocalDate getDateRecorded() {
        return DateRecorded;
    }

    public void setDateRecorded(LocalDate date) {
        this.DateRecorded = date;
    }

    public float getRecycleUsage() {
        return recycleUsage;
    }

    public void setRecycleUsage(float recycleAmount) {
        this.recycleUsage = recycleAmount;
    }
}
