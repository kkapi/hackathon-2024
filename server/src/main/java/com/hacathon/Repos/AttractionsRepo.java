package com.hacathon.Repos;

import com.hacathon.Domain.Attractions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttractionsRepo extends JpaRepository<Attractions, Long> {
    List<Attractions> findAll();
}
