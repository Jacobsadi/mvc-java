// ElectricityRepository_JDBC.java
package com.utm.ip.mbipweb.mbip56.models.electricity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.utm.ip.mbipweb.mbip56.models.water.WaterDAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Repository
@Primary
public class ElectricityRepository_JDBC implements ElectricityRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ElectricityDAO> getAllElectricitys() {
        String sql = "SELECT * FROM Electricity";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ElectricityDAO.class));
    }

    @Override
    public ElectricityDAO addElectricity(final ElectricityDAO electricity) {
        String sql = "INSERT INTO Electricity (UserID, DateRecorded, ElectricityUsage) VALUES (?, ?, ?)";
        try {
            LocalDate dateRecorded = electricity.getDateRecorded();
            System.out.println(dateRecorded);
            if (dateRecorded != null) {
                jdbcTemplate.update(sql, electricity.getUserID(), Date.valueOf(dateRecorded),
                        electricity.getElectricityUsage());
                return electricity;
            } else {
                // Handle the case where dateRecorded is null
                // You can throw an exception or log an error
                System.out.println("DateRecorded is null. Electricity data not added.");
                return null;
            }
        } catch (DataAccessException e) {
            // Log the exception and handle it properly
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ElectricityDAO getElectricityById(int id) {
        String sql = "SELECT * FROM Water WHERE ElectricityID = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ElectricityDAO.class), id);
        } catch (Exception e) {
            // Log the exception and handle it properly

            return null;
        }
    }

    @Override
    public ElectricityDAO getElectricityByUserId(int user_id) {
        // String sql = "SELECT WaterID, UserID, DateRecorded, WaterUsage FROM Water
        // WHERE UserID = ?";
        String sql = "SELECT ElectricityID, UserID, DateRecorded, ElectricityUsage FROM electricity WHERE UserID = ?";

        try {
            ElectricityDAO dao = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ElectricityDAO.class),
                    user_id);
            System.out.println(
                    "ElectricyDAO  FROM REPO   ****************************************************************************************************: "
                            + dao.getElectricityID());
            return dao;
        } catch (DataAccessException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

    @Override
public List<ElectricityDAO> getElectricityForId(int id) {
    String sql = "SELECT ElectricityID, UserID, DateRecorded, ElectricityUsage FROM Electricity WHERE UserID = ?";
    String sqll = "SELECT* FROM Electricity WHERE UserID = ?";

    try {
        List<ElectricityDAO> electricityDAOList = jdbcTemplate.query(sqll, new BeanPropertyRowMapper<>(ElectricityDAO.class), id);

        return electricityDAOList;
    } catch (DataAccessException e) {
        System.out.println("Exception occurred: " + e.getMessage());
        e.printStackTrace();
        return Collections.emptyList(); // Return an empty list if an exception occurs
    }
}




    public boolean doesUserIdExistInElectricity(int user_id) {
        String checkSql = "SELECT COUNT(*) FROM Electricity WHERE UserID = ?";
        int count = jdbcTemplate.queryForObject(checkSql, Integer.class, user_id);
        return count > 0;
    }

    @Override
    public ElectricityDAO updateElectricity(final ElectricityDAO electricity) {
        String sql = "UPDATE Water SET UserID = ?, DateRecorded = ?, WaterUsage = ? WHERE WaterID = ?";
        try {
            jdbcTemplate.update(sql, electricity.getUserID(), electricity.getDateRecorded(),
                    electricity.getElectricityUsage(),
                    electricity.getElectricityID());
            return electricity;
        } catch (Exception e) {
            // Log the exception and handle it properly
            return null;
        }
    }

    @Override
    public boolean deleteElectricity(int id) {
        String sql = "DELETE FROM Electricty WHERE ElectricityID = ?";
        try {
            return jdbcTemplate.update(sql, id) > 0;
        } catch (Exception e) {
            // Log the exception and handle it properly
            return false;
        }
    }
}
