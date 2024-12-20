package com.utm.ip.mbipweb.mbip56.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.utm.ip.mbipweb.mbip56.models.electricity.ElectricityRepository;
import com.utm.ip.mbipweb.mbip56.models.electricity.ElectricityRepository_JDBC;
import com.utm.ip.mbipweb.mbip56.models.user.User;
import com.utm.ip.mbipweb.mbip56.services.electricity.ElectricityService;
import com.utm.ip.mbipweb.mbip56.services.electricity.ElectricityService_Database;
import com.utm.ip.mbipweb.mbip56.services.recycle.RecycleService;
import com.utm.ip.mbipweb.mbip56.services.user.UserService;
import com.utm.ip.mbipweb.mbip56.services.water.WaterService;
import com.utm.ip.mbipweb.mbip56.models.user.UserRepository;
import com.utm.ip.mbipweb.mbip56.models.water.WaterRepository;
import com.utm.ip.mbipweb.mbip56.models.recycle.RecycleRepository;

import com.utm.ip.mbipweb.mbip56.models.user.UserRepository_JDBC;
import com.utm.ip.mbipweb.mbip56.models.water.WaterRepository_JDBC;
import com.utm.ip.mbipweb.mbip56.models.recycle.RecycleRepository_JDBC;
import com.utm.ip.mbipweb.mbip56.services.user.UserService_Database;
import com.utm.ip.mbipweb.mbip56.services.water.WaterService_Database;
import com.utm.ip.mbipweb.mbip56.services.recycle.RecycleService_Database;

@Configuration
public class AppConfig {
    // Load all services required by the app

    @Bean
    UserService userService() {
        // return new ProductService_Memory();
        return new UserService_Database();
    }

    // Repositories
    @Bean
    UserRepository usertRepository() {
        return new UserRepository_JDBC();
    }

    @Bean
    WaterService waterService() {
        // return new ProductService_Memory();
        return new WaterService_Database();
    }

    @Bean
    WaterRepository watertRepository() {
        return new WaterRepository_JDBC();
    }

    @Bean
    ElectricityService ElectricityService() {
        // return new ProductService_Memory();
        return new ElectricityService_Database();
    }

    @Bean
    ElectricityRepository ElectricityRepository() {
        return new ElectricityRepository_JDBC();
    }

    @Bean
    RecycleService recycleService() {
        // return new ProductService_Memory();
        return new RecycleService_Database();
    }

    @Bean
    RecycleRepository RecycleRepository() {
        return new RecycleRepository_JDBC();
    }
}
