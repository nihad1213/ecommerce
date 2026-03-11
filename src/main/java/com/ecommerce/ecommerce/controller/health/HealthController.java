package com.ecommerce.ecommerce.controller.health;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/health")
@RequiredArgsConstructor
public class HealthController {

    private final DataSource dataSource;

    @GetMapping
    public String dbHealth() {
        try (Connection connection = dataSource.getConnection()) {
            if (connection.isValid(1)) {
                return "CONNECTED";
            } else {
                return "NOT CONNECTED";
            }
        } catch (Exception e) {
            return "Database connection failed: " + e.getMessage();
        }
    }
}