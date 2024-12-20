package com.utm.ip.mbipweb.mbip56.services.water;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.utm.ip.mbipweb.mbip56.models.water.Water;
import com.utm.ip.mbipweb.mbip56.models.water.WaterDAO;
import com.utm.ip.mbipweb.mbip56.models.water.WaterRepository;

public class WaterService_Database implements WaterService {
    @Autowired
    WaterRepository repo;

    public List<Water> getAllWaters() {
        List<WaterDAO> daos = repo.getAllWaters();
        List<Water> waters = new ArrayList<>();
        for (WaterDAO dao : daos) {
            waters.add(new Water(dao));
        }
        return waters;
    }

    public Water addWater(final Water water) {
        WaterDAO waterDAO = new WaterDAO();
        waterDAO.setDateRecorded(water.getDateRecorded());
        waterDAO.setWaterUsage(water.getWaterUsage());
        waterDAO.setUserID(water.getUserID());
        // Set properties of waterDAO based on Water model
        WaterDAO wat = repo.addWater(waterDAO);
        // Check if wat is not null
        if (wat != null) {
            // wat exists, perform additional logic if needed
            System.out.println("WaterDAO exists: " + wat);
        } else {
            // wat is null, handle accordingly
            System.out.println("WaterDAO is null");
        }
        return water;
    }

    public Water getWaterById(String id) {
        return null;
    }

    public Water getWaterByUserId(int user_id) {
        WaterDAO dao = repo.getWaterByUserId(user_id);
 
        Water water = new Water();
        water.fromDAO(dao);

        return water;
    }
    public List<Water> getWaterForUserId(int user_id) {
        List<WaterDAO> daoList = repo.getWaterForUserId(user_id);
        List<Water> waterList = new ArrayList<>();
    
        for (WaterDAO dao : daoList) {
            Water water = new Water();
            water.fromDAO(dao);
            waterList.add(water);
        }
    
        return waterList;
    }
    
    public boolean doesUserIdExistInWater(int user_id) {
        boolean isUser = repo.doesUserIdExistInWater(user_id);
        return isUser;
    }


    public Water updateWater(final Water water) {
        return water;
    }

    public boolean deleteWater(String id) {
        return false;
    }
}
