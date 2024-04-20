package com.hacathon.Repos;

import com.hacathon.Domain.PlaceInStPetersburg;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaceInStPetersburgRepo extends JpaRepository<PlaceInStPetersburg, Long> {
    @Query(value = "SELECT t " +
            "FROM PlaceInStPetersburg t " +
            "order by sqrt(((t.latitude - :latitude)*111153)*((t.latitude - :latitude)*111153) + ((t.longitude - :longitude)*62555)*((t.longitude - :longitude)*62555))")
    List<PlaceInStPetersburg> findNear(@Param("longitude") double longitude, @Param("latitude") double latitude, Pageable pageable);
}