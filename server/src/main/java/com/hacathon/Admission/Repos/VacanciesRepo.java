package com.hacathon.Admission.Repos;

import com.hacathon.Admission.Domain.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacanciesRepo extends JpaRepository<Vacancies, String> {
}
