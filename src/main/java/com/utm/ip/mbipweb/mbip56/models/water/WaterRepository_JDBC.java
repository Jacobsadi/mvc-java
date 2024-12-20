package com.utm.ip.mbipweb.mbip56.models.water;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.utm.ip.mbipweb.mbip56.models.electricity.ElectricityDAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Repository
@Primary
public class WaterRepository_JDBC implements WaterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<WaterDAO> getAllWaters() {
        String sql = "SELECT * FROM Water";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WaterDAO.class));
    }

    @Override
    public WaterDAO addWater(final WaterDAO water) {
        String sql = "INSERT INTO Water (UserID, DateRecorded, WaterUsage) VALUES (?, ?, ?)";
        try {
            LocalDate dateRecorded = water.getDateRecorded();
            System.out.println(dateRecorded);
            if (dateRecorded != null) {
                jdbcTemplate.update(sql, water.getUserID(), Date.valueOf(dateRecorded), water.getWaterUsage());
                return water;
            } else {
                // Handle the case where dateRecorded is null
                // You can throw an exception or log an error
                System.out.println("DateRecorded is null. Water data not added.");
                return null;
            }
        } catch (DataAccessException e) {
            // Log the exception and handle it properly
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public WaterDAO getWaterById(int id) {
        String sql = "SELECT * FROM Water WHERE WaterID = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(WaterDAO.class), id);
        } catch (Exception e) {
            // Log the exception and handle it properly

            return null;
        }
    }

    // *********************************************************************************
    // */
    // *********************************************************************************
    // */
    @Override
    public WaterDAO getWaterByUserId(int user_id) {
        String sql = "SELECT WaterID, UserID, DateRecorded, WaterUsage FROM Water WHERE UserID = ?";

        try {
            WaterDAO dao = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(WaterDAO.class), user_id);
            System.out.println(
                    "WaterDAO FROM REPO   ****************************************************************************************************: "
                            + dao);
            return dao;
        } catch (DataAccessException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

    // ***************************************** */
    // ***************************************** */
    @Override
    public List<WaterDAO> getWaterForUserId(int user_id) {
        String sql = "SELECT WaterID, UserID, DateRecorded, WaterUsage FROM Water WHERE UserID = ?";
        try {
            List<WaterDAO> daoList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WaterDAO.class), user_id);

            return daoList;
        } catch (DataAccessException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList(); // Return an empty list if an exception occurs
        }
    }


    public boolean doesUserIdExistInWater(int user_id) {
        String checkSql = "SELECT COUNT(*) FROM Water WHERE UserID = ?";
        int count = jdbcTemplate.queryForObject(checkSql, Integer.class, user_id);
        return count > 0;
    }

    // *********************************************************************************
    // */
    // *********************************************************************************
    // */

    @Override
    public WaterDAO updateWater(final WaterDAO water) {
        String sql = "UPDATE Water SET UserID = ?, DateRecorded = ?, WaterUsage = ? WHERE WaterID = ?";
        try {
            jdbcTemplate.update(sql, water.getUserID(), water.getDateRecorded(), water.getWaterUsage(),
                    water.getWaterID());
            return water;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteWater(int id) {
        String sql = "DELETE FROM Water WHERE WaterID = ?";
        try {
            return jdbcTemplate.update(sql, id) > 0;
        } catch (Exception e) {
            // Log the exception and handle it properly
            return false;
        }
    }
}
