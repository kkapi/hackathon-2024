package com.hacathon.Admission.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Directions {
    @Id
    private String direction;

    private int placeBudget;
    private int placeContract;

    private int price;

    private String subjectOne;
    private String subjectTwo;
    private String subjectThree;

    private int minPointOne;
    private int minPointTwo;
    private int minPointThree;

    private int pointPreviousYear;
    private int contestBudget;
    private int contestContract;

    public Directions() {
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getPlaceBudget() {
        return placeBudget;
    }

    public void setPlaceBudget(int placeBudget) {
        this.placeBudget = placeBudget;
    }

    public int getPlaceContract() {
        return placeContract;
    }

    public void setPlaceContract(int placeContract) {
        this.placeContract = placeContract;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSubjectOne() {
        return subjectOne;
    }

    public void setSubjectOne(String subjectOne) {
        this.subjectOne = subjectOne;
    }

    public String getSubjectTwo() {
        return subjectTwo;
    }

    public void setSubjectTwo(String subjectTwo) {
        this.subjectTwo = subjectTwo;
    }

    public String getSubjectThree() {
        return subjectThree;
    }

    public void setSubjectThree(String subjectThree) {
        this.subjectThree = subjectThree;
    }

    public int getMinPointOne() {
        return minPointOne;
    }

    public void setMinPointOne(int minPointOne) {
        this.minPointOne = minPointOne;
    }

    public int getMinPointTwo() {
        return minPointTwo;
    }

    public void setMinPointTwo(int minPointTwo) {
        this.minPointTwo = minPointTwo;
    }

    public int getMinPointThree() {
        return minPointThree;
    }

    public void setMinPointThree(int minPointThree) {
        this.minPointThree = minPointThree;
    }

    public int getPointPreviousYear() {
        return pointPreviousYear;
    }

    public void setPointPreviousYear(int pointPreviousYear) {
        this.pointPreviousYear = pointPreviousYear;
    }

    public int getContestBudget() {
        return contestBudget;
    }

    public void setContestBudget(int contestBudget) {
        this.contestBudget = contestBudget;
    }

    public int getContestContract() {
        return contestContract;
    }

    public void setContestContract(int contestContract) {
        this.contestContract = contestContract;
    }
}
