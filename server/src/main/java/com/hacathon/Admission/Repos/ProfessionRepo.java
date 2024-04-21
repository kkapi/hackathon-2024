package com.hacathon.Admission.Repos;

import com.hacathon.Admission.Domain.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Класс используется для доступа к БД Profession
 */
public interface ProfessionRepo extends JpaRepository<Profession, String> {
}
