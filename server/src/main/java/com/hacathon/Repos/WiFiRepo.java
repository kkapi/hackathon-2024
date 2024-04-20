package com.hacathon.Repos;

import com.hacathon.Domain.WiFi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WiFiRepo extends JpaRepository<WiFi, Long> {
    List<WiFi> findAll();
}
