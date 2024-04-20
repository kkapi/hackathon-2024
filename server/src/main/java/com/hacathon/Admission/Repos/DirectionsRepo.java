package com.hacathon.Admission.Repos;

import com.hacathon.Admission.Domain.Directions;
import com.hacathon.Admission.Domain.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DirectionsRepo extends JpaRepository<Directions, String> {
    Optional<Directions> findById(String id);
    List<Directions> findByProfession(Profession profession);
}
