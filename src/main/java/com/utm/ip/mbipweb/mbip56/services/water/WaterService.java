package com.utm.ip.mbipweb.mbip56.services.water;
import com.utm.ip.mbipweb.mbip56.models.water.Water;
import com.utm.ip.mbipweb.mbip56.models.water.WaterDAO;

import java.util.List;

public interface WaterService {
    List<Water> getAllWaters();
    Water addWater(final Water water);
    Water getWaterById(String id);
    Water getWaterByUserId(int user_id);
    Water updateWater(final Water water);
    boolean deleteWater(String id);
    boolean doesUserIdExistInWater(int user_id);
    List<Water> getWaterForUserId(int user_id);
}

