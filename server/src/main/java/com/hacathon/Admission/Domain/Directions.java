package com.hacathon.Admission.Domain;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Map;

@Entity
public class Directions {
    @Id
    private String number;

    @JsonSetter("Направление")
    private String direction;

    @JsonSetter("Конкурсн. группа")
    private String contestGroup;

    @JsonSetter("КЦП_Б")
    private int placeBudget;
    @JsonSetter("КЦП_К")
    private int placeContract;

    @JsonSetter("Цена")
    private int price;

    @JsonSetter("Предмет 1")
    private String subjectOne;
    @JsonSetter("Предмет 2")
    private String subjectTwo;
    @JsonSetter("Предмет 3")
    private String subjectThree;

    @JsonSetter("Мин. балл 1")
    private int minPointOne;
    @JsonSetter("Мин. балл 2")
    private int minPointTwo;
    @JsonSetter("Мин. балл 3")
    private int minPointThree;

    @JsonSetter("Балл")
    private int pointPreviousYear;
    @JsonSetter("Конкурс_Б")
    private int contestBudget;
    @JsonSetter("Конкурс_К")
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

    public String getGroup() {
        return contestGroup;
    }

    public void setGroup(String group) {
        this.contestGroup = group;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContestGroup() {
        return contestGroup;
    }

    public void setContestGroup(String contestGroup) {
        this.contestGroup = contestGroup;
    }


}
