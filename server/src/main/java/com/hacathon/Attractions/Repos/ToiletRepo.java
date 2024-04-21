package com.hacathon.Attractions.Repos;

import com.hacathon.Attractions.Domain.Toilet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Данный интерфейс используется для доступа к БД Toilet
 */
public interface ToiletRepo extends JpaRepository<Toilet, String> {
    @Query(value = "SELECT t " +
            "FROM Toilet t " +
            "order by sqrt(((t.lat - :latitude)*111153)*((t.lat - :latitude)*111153) + ((t.lon - :longitude)*62555)*((t.lon - :longitude)*62555))")
    List<Toilet> findNear(@Param("longitude") double longitude, @Param("latitude") double latitude);
}
