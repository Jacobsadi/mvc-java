package com.utm.ip.mbipweb.mbip56.models.water;

import org.springframework.stereotype.Repository;

import com.utm.ip.mbipweb.mbip56.models.electricity.ElectricityDAO;

// import com.utm.ip.mbipweb.mbip56.models.water.WaterDAO;

import java.util.List;

@Repository
public interface WaterRepository {
    List<WaterDAO> getAllWaters();
    WaterDAO addWater(final WaterDAO water);
    WaterDAO getWaterById(int id);
    WaterDAO getWaterByUserId(int id);
    WaterDAO updateWater(final WaterDAO water);
    boolean deleteWater(int id);
    boolean doesUserIdExistInWater(int user_id);
    List<WaterDAO> getWaterForUserId(int user_id);
}
