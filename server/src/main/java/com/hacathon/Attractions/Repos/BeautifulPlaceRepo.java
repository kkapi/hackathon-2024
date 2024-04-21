package com.hacathon.Attractions.Repos;

import com.hacathon.Attractions.Domain.BeautifulPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Данный интерфейс используется для доступа к БД BeautifulPlace
 */
public interface BeautifulPlaceRepo extends JpaRepository<BeautifulPlace, Long> {
    List<BeautifulPlace> findAll();
}
