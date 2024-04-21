package com.hacathon.Transfer.Domain;


/**
 * Класс хранит информацию о направлении и предмете этого направления
 */
public class Subject {
    private String numberPlan;
    private String subject;

    public Subject() {
    }

    public String getNumberPlan() {
        return numberPlan;
    }

    public void setNumberPlan(String numberPlan) {
        this.numberPlan = numberPlan;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
