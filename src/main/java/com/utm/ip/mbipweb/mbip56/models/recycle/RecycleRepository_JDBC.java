package com.utm.ip.mbipweb.mbip56.models.recycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.utm.ip.mbipweb.mbip56.models.water.WaterDAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
@Primary
public class RecycleRepository_JDBC implements RecycleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<RecycleDAO> getAllRecycle() {
        String sql = "SELECT * FROM Recycling";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RecycleDAO.class));
    }

    @Override
    public RecycleDAO addRecycle(final RecycleDAO recycle) {
        String sql = "INSERT INTO Recycling (UserID, DateRecorded, RecycledAmount) VALUES (?, ?, ?)";
        try {
            LocalDate dateRecorded = recycle.getDateRecorded();
            if (dateRecorded != null) {
                jdbcTemplate.update(sql, recycle.getUserID(), Date.valueOf(dateRecorded), recycle.getRecycleUsage());
                return recycle;
            } else {
                System.out.println("DateRecorded is null. Recycling data not added.");
                return null;
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RecycleDAO getRecycleById(int id) {
        String sql = "SELECT * FROM Recycling WHERE RecyclingID = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(RecycleDAO.class), id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean doesUserIdExistInRecycle(int user_id) {
        String checkSql = "SELECT COUNT(*) FROM Recycling WHERE UserID = ?";
        int count = jdbcTemplate.queryForObject(checkSql, Integer.class, user_id);
        return count > 0;
    }

    @Override
    public RecycleDAO getRecycleByUserId(int user_id) {
        String sql = "SELECT RecyclingID, UserID, DateRecorded, RecycledAmount FROM recycling WHERE UserID = ?";
    
        try {
            RecycleDAO dao = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(RecycleDAO.class), user_id);
            System.out.println(
                    "RecycleDAO FROM REPO   ****************************************************************************************************: "
                            + dao);
            return dao;
        } catch (DataAccessException e) {
            System.out.println("Exception occurred: FOR RecycleDAO RecycleDAO RecycleDAO RecycleDAO  " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    

    @Override
    public RecycleDAO updateRecycle(final RecycleDAO recycle) {
        String sql = "UPDATE Recycling SET UserID = ?, DateRecorded = ?, RecycledAmount = ? WHERE RecyclingID = ?";
        try {
            jdbcTemplate.update(sql, recycle.getUserID(), Date.valueOf(recycle.getDateRecorded()),
                    recycle.getRecycleUsage(),
                    recycle.getRecycleId());
            return recycle;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean deleteRecycle(int id) {
        String sql = "DELETE FROM Recycling WHERE RecyclingID = ?";
        try {
            return jdbcTemplate.update(sql, id) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
