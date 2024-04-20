package com.hacathon.Admission.Repos;

import com.hacathon.Admission.Domain.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepo extends JpaRepository<Profession, String> {
}
