// ElectricityService_Database.java
package com.utm.ip.mbipweb.mbip56.services.electricity;

import org.springframework.beans.factory.annotation.Autowired;
import com.utm.ip.mbipweb.mbip56.models.electricity.Electricity;
import com.utm.ip.mbipweb.mbip56.models.electricity.ElectricityDAO;
import com.utm.ip.mbipweb.mbip56.models.electricity.ElectricityRepository;
import com.utm.ip.mbipweb.mbip56.models.water.Water;
import com.utm.ip.mbipweb.mbip56.models.water.WaterDAO;

import java.util.ArrayList;
import java.util.List;

public class ElectricityService_Database implements ElectricityService {
    @Autowired
    ElectricityRepository repo;

    public List<Electricity> getAllElectricitys() {
        List<ElectricityDAO> daos = repo.getAllElectricitys();
        List<Electricity> electricities = new ArrayList<>();
        for (ElectricityDAO dao : daos) {
            electricities.add(new Electricity(dao));
        }
        return electricities;
    }

    public Electricity addElectricity(final Electricity electricity) {
        ElectricityDAO electricityDAO = new ElectricityDAO();
        electricityDAO.setDateRecorded(electricity.getDateRecorded());
        electricityDAO.setElectricityUsage(electricity.getElectricityUsage());
        electricityDAO.setUserID(electricity.getUserID());
        // Set properties of waterDAO based on Water model
        ElectricityDAO elc = repo.addElectricity(electricityDAO);
        // Check if wat is not null
        if (elc != null) {
            System.out.println("ElectricityDAO exists: " + elc);
        } else {
            System.out.println("ElectricityDAO is null");
        }
        return electricity;
    }

    public Electricity getElectricityById(String id) {
        return null;
    }

    // public Water getWaterByUserId(int user_id) {
    // WaterDAO dao = repo.getWaterByUserId(user_id);

    // Water water = new Water();
    // water.fromDAO(dao);

    // return water;
    // }


    // public Electricity getElectricityById(int id) {
    // return null;
    // }

    public boolean doesUserIdExistInElectricity(int user_id) {
        boolean isUser = repo.doesUserIdExistInElectricity(user_id);
        return isUser;
    }

    public Electricity updateElectricity(final Electricity electricity) {
        return electricity;
    }

    // public boolean deleteElectricity(int id) {
    // return false;
    // }

    public boolean deleteElectricity(String id) {
        return false;
    }
    public Electricity getElectricityByUserId(int user_id) {
        ElectricityDAO dao = repo.getElectricityByUserId(user_id);
        Electricity electricity = new Electricity();
        electricity.fromDAO(dao);
        return electricity;
    }



    public List<Electricity> getElectricityForId(int id) {
        List<ElectricityDAO> daoList = repo.getElectricityForId(id);
        List<Electricity> electricityList = new ArrayList<>();
    
        if (daoList != null && !daoList.isEmpty()) {
            for (ElectricityDAO dao : daoList) {
                Electricity electricity = new Electricity();
                electricity.fromDAO(dao);
                electricityList.add(electricity);
            }
        } else {
            System.out.println("DAO list is empty or null NULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULLNULL .");
        }
    
        return electricityList;
    }
    
}
