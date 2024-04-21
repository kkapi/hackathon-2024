package com.hacathon.Admission.Repos;

import com.hacathon.Admission.Domain.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Класс используется для доступа к БД Vacancies
 */
public interface VacanciesRepo extends JpaRepository<Vacancies, String> {
    Optional<Vacancies> findById(String id);
}
