package com.hacathon.Attractions.Repos;

import com.hacathon.Attractions.Domain.Attractions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Данный интерфейс используется для доступа к БД Attractions
 */
public interface AttractionsRepo extends JpaRepository<Attractions, Long> {
    List<Attractions> findAll();
}
