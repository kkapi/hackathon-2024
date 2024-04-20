package com.hacathon.Repos;

import com.hacathon.Domain.Toilet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToiletRepo extends JpaRepository<Toilet, Long> {
}
