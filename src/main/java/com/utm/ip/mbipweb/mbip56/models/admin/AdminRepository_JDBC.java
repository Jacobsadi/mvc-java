package com.utm.ip.mbipweb.mbip56.models.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository_JDBC implements AdminRepository {
    @Autowired
    private  JdbcTemplate jdbcTemplate;

    public AdminRepository_JDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AdminDAO> getAllAdmin() {
        String sql = "SELECT * FROM admin_table"; // Replace with your actual table name
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AdminDAO.class));
    }

    @Override
    public AdminDAO addAdmin(final AdminDAO admin) {
        String sql = "INSERT INTO admin_table(username, password) VALUES (?, ?)"; // Replace with your actual table and columns
        jdbcTemplate.update(sql, admin.getUsername(), admin.getPassword());
        return admin;
    }

    @Override
    public AdminDAO getAdminById(String id) {
        String sql = "SELECT * FROM admin_table WHERE id = ?"; // Replace with your actual table and primary key
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(AdminDAO.class), id);
    }

    @Override
    public AdminDAO updateAdmin(final AdminDAO admin) {
        String sql = "UPDATE admin_table SET username = ?, password = ? WHERE id = ?"; // Replace with your actual table and primary key
        jdbcTemplate.update(sql, admin.getUsername(), admin.getPassword(), admin.getId());
        return admin;
    }

    @Override
    public boolean deleteAdmin(String id) {
        String sql = "DELETE FROM admin_table WHERE id = ?"; // Replace with your actual table and primary key
        return jdbcTemplate.update(sql, id) > 0;
    }
}
