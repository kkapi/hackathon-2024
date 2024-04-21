package com.hacathon.Admission.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * Данный класс содержит данные о предметах подготовки и связанных с ними профессиях
 */
@Entity
public class Vacancies {
    @Id
    private String subject;

    @OneToOne
    private Profession groupVacancies;

    public Vacancies() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Profession getGroupVacancies() {
        return groupVacancies;
    }

    public void setGroupVacancies(Profession groupVacancies) {
        this.groupVacancies = groupVacancies;
    }
}
