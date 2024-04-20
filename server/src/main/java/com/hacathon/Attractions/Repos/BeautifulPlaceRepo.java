package com.hacathon.Attractions.Repos;

import com.hacathon.Attractions.Domain.BeautifulPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeautifulPlaceRepo extends JpaRepository<BeautifulPlace, Long> {
    List<BeautifulPlace> findAll();
}
