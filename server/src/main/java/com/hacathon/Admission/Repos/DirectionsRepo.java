package com.hacathon.Admission.Repos;

import com.hacathon.Admission.Domain.Directions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectionsRepo extends JpaRepository<Directions, String> {
}
