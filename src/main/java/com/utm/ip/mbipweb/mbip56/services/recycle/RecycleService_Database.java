package com.utm.ip.mbipweb.mbip56.services.recycle;

import com.utm.ip.mbipweb.mbip56.models.electricity.Electricity;
import com.utm.ip.mbipweb.mbip56.models.electricity.ElectricityDAO;
import com.utm.ip.mbipweb.mbip56.models.recycle.Recycle;
import com.utm.ip.mbipweb.mbip56.models.recycle.RecycleDAO;
import com.utm.ip.mbipweb.mbip56.models.recycle.RecycleRepository;
import com.utm.ip.mbipweb.mbip56.models.water.Water;
import com.utm.ip.mbipweb.mbip56.models.water.WaterDAO;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RecycleService_Database implements RecycleService {
    @Autowired
    RecycleRepository repo;

    public List<Recycle> getAllRecycle() {
        List<RecycleDAO> daos = repo.getAllRecycle();
        List<Recycle> Recycle = new ArrayList<>();
        for (RecycleDAO dao : daos) {
            Recycle.add(new Recycle(dao));
        }
        return Recycle;
    }

    public Recycle addRecycle(final Recycle Recycle) {
        RecycleDAO RecycleDAO = new RecycleDAO();
        RecycleDAO.setDateRecorded(Recycle.getDateRecorded());
        RecycleDAO.setRecycleUsage(Recycle.getRecycleUsage());
        RecycleDAO.setUserID(Recycle.getUserID());
        // Set properties of RecycleDAO based on Recycle model
        RecycleDAO Rec = repo.addRecycle(RecycleDAO);
        // Check if wat is not null
        if (Rec != null) {
            System.out.println("RecycleDAO exists: " + Rec);
        } else {
            // wat is null, handle accordingly
            System.out.println("RecycleDAO is null");
        }
        return Recycle;
    }

    public Recycle getRecycleById(String id) {
        return null;
    }

    public boolean doesUserIdExistInRecycle(int user_id) {
        boolean isUser = repo.doesUserIdExistInRecycle(user_id);
        return isUser;
    }

    public Recycle getRecycleByUserId(int user_id) {
        RecycleDAO dao = repo.getRecycleByUserId(user_id);

        Recycle recycle = new Recycle();
        recycle.fromDAO(dao);

        return recycle;
    }

    public Recycle updateRecycle(final Recycle recycle) {
        return recycle;
    }

    public boolean deleteRecycle(String id) {
        return false;
    }





}
