package com.hacathon.Attractions.JSON;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.hacathon.Attractions.Domain.BeautifulPlace;

/**
 * Данный класс необходим для преобразования данных из JSON
 */
public class Place {
    @JsonSetter("place")
    private BeautifulPlace place;

    public Place() {
    }

    public BeautifulPlace getPlace() {
        return place;
    }

    public void setPlace(BeautifulPlace place) {
        this.place = place;
    }
}
