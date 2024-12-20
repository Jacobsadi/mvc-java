package com.utm.ip.mbipweb.mbip56.services.recycle;

import com.utm.ip.mbipweb.mbip56.models.electricity.ElectricityDAO;
import com.utm.ip.mbipweb.mbip56.models.recycle.Recycle;
import com.utm.ip.mbipweb.mbip56.models.water.Water;

import java.util.List;

public interface RecycleService {
    List<Recycle> getAllRecycle();

    Recycle addRecycle(final Recycle recycle);

    Recycle getRecycleById(String id);

    Recycle updateRecycle(final Recycle recycle);

    boolean deleteRecycle(String id);

    boolean doesUserIdExistInRecycle(int user_id);

    Recycle getRecycleByUserId(int user_id);

}
