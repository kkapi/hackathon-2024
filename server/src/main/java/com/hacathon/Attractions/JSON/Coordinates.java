package com.hacathon.Attractions.JSON;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Coordinates {
    @JsonSetter("longitude")
    private double longitude;

    @JsonSetter("latitude")
    private double latitude;

    public Coordinates() {
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
