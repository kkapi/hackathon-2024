package com.hacathon.Admission.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Данный класс содержит информацию о профессии
 */
@Entity
public class Profession {
    @Id
    private String profession;

    public Profession() {
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
