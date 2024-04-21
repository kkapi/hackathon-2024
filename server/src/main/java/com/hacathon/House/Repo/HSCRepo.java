package com.hacathon.House.Repo;

import com.hacathon.Attractions.Domain.WiFi;
import com.hacathon.House.domain.HSC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Интерфейс для связи с БД ЖКХ
 */
public interface HSCRepo extends JpaRepository<HSC, String> {
    @Query(value = "SELECT t " +
            "FROM HSC t " +
            "WHERE sqrt(((t.lat - :latitude)*111153)*((t.lat - :latitude)*111153) + ((t.lon - :longitude)*62555)*((t.lon - :longitude)*62555)) < :radius " +
            "order by sqrt(((t.lat - :latitude)*111153)*((t.lat - :latitude)*111153) + ((t.lon - :longitude)*62555)*((t.lon - :longitude)*62555))")
    List<HSC> findPrice(@Param("longitude") double longitude, @Param("latitude") double latitude, @Param("radius") double radius);
}
