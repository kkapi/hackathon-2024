package com.hacathon.Attractions.JSON;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.hacathon.Attractions.Domain.BeautifulPlace;

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
