package com.utm.ip.mbipweb.mbip56.models.recycle;

import org.springframework.stereotype.Repository;
import com.utm.ip.mbipweb.mbip56.models.recycle.RecycleDAO;

import java.util.List;

public interface RecycleRepository {
    List<RecycleDAO> getAllRecycle();

    RecycleDAO addRecycle(final RecycleDAO recycle);

    RecycleDAO getRecycleById(int id);

    RecycleDAO updateRecycle(final RecycleDAO recycle);

    boolean deleteRecycle(int id);

    boolean doesUserIdExistInRecycle(int user_id);

    RecycleDAO getRecycleByUserId(int user_id);
}
