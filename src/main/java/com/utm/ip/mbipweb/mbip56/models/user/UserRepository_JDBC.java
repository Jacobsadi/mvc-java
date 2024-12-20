package com.utm.ip.mbipweb.mbip56.models.user;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
@Primary // Add this annotation
public class UserRepository_JDBC implements UserRepository {

    @Override
    public UserDAO authenticateUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{username, password}, new BeanPropertyRowMapper<>(UserDAO.class));
        } catch (Exception e) {
            // Log the exception and handle it properly
            return null;
        }
    }
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UserDAO> getAllUsers() {
        String sql = "SELECT * FROM users";
        final List<UserDAO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDAO>(UserDAO.class));
        return list;
    } 

    @Override
    public UserDAO addUser(final UserDAO user) {
        String sql = "INSERT INTO users (username, password, email, contact, area) VALUES (?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),user.getEmail(),  user.getContact(), user.getArea());
            return user;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public UserDAO getUserById(String id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserDAO.class), id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public UserDAO updateUser(final UserDAO user) {
        String sql = "UPDATE users SET username = ?, email = ?, password = ?, contact = ?, area = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getContact(), user.getArea(), user.getUserId());
            return user;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean deleteUser(String id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try {
            return jdbcTemplate.update(sql, id) > 0;
        } catch (DataAccessException e) {
            return false;
        }
    }
    @Override
    public List<UserDAO> getUsersWithUsage() {
        String sql = "SELECT " +
                     "    u.user_id, " +
                     "    u.username, " +
                     "    w.DateRecorded AS WaterDateRecorded, " +
                     "    w.WaterUsage, " +
                     "    e.EnergyConsumption, " +
                     "    r.RecycleUsage " +
                     "FROM " +
                     "    users u " +
                     "LEFT JOIN " +
                     "    water w ON u.user_id = w.UserID " +
                     "LEFT JOIN " +
                     "    energy e ON u.user_id = e.UserID " +
                     "LEFT JOIN " +
                     "    electricity r ON u.user_id = r.UserID";
        final List<UserDAO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDAO>(UserDAO.class));

        return list;
    }
}
