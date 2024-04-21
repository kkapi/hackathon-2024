package com.hacathon.Attractions.Repos;

import com.hacathon.Attractions.Domain.Metro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Данный интерфейс используется для доступа к БД Metro
 */
public interface MetroRepo extends JpaRepository<Metro, String> {

    @Query(value = "SELECT t " +
            "FROM Metro t " +
            "order by sqrt(((t.lat - :latitude)*62555)*((t.lat - :latitude)*62555) + ((t.lon - :longitude)*111153)*((t.lon - :longitude)*111153))")
    List<Metro> findNear(@Param("longitude") double longitude, @Param("latitude") double latitude);
}
