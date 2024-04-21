package com.hacathon.Attractions.Repos;

import com.hacathon.Attractions.Domain.PlaceInStPetersburg;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Данный интерфейс используется для доступа к БД Place_in_st_petersburg
 */
public interface PlaceInStPetersburgRepo extends JpaRepository<PlaceInStPetersburg, Long> {
    @Query(value = "SELECT t " +
            "FROM PlaceInStPetersburg t " +
            "order by sqrt(((t.latitude - :latitude)*111153)*((t.latitude - :latitude)*111153) + ((t.longitude - :longitude)*62555)*((t.longitude - :longitude)*62555))")
    List<PlaceInStPetersburg> findNear(@Param("longitude") double longitude, @Param("latitude") double latitude, Pageable pageable);

    @Query(value = "SELECT t " +
            "FROM PlaceInStPetersburg t " +
            "WHERE t.category = :type " +
            "order by sqrt(((t.latitude - :latitude)*111153)*((t.latitude - :latitude)*111153) + ((t.longitude - :longitude)*62555)*((t.longitude - :longitude)*62555))")
    List<PlaceInStPetersburg> findNearByCategory(double longitude, double latitude, String type, PageRequest of);

    @Query(value = "SELECT t " +
            "FROM PlaceInStPetersburg t " +
            "WHERE t.type = :beautifulPlace " +
            "order by sqrt(((t.latitude - :latitude)*111153)*((t.latitude - :latitude)*111153) + ((t.longitude - :longitude)*62555)*((t.longitude - :longitude)*62555))")
    List<PlaceInStPetersburg> findNearByType(double longitude, double latitude, String beautifulPlace, PageRequest of);

    @Query(value = "SELECT t " +
            "FROM PlaceInStPetersburg t " +
            "WHERE sqrt(((t.latitude - :latitude)*111153)*((t.latitude - :latitude)*111153) + ((t.longitude - :longitude)*62555)*((t.longitude - :longitude)*62555)) < :radius " +
            "order by sqrt(((t.latitude - :latitude)*111153)*((t.latitude - :latitude)*111153) + ((t.longitude - :longitude)*62555)*((t.longitude - :longitude)*62555))")
    List<PlaceInStPetersburg> findNearAll(double longitude, double latitude, int radius);
}