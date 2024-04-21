package com.hacathon.Attractions.JSON;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Данный класс необходим для преобразования данных из JSON
 */
public class Coordinates {
    @JsonSetter("longitude")
    private double longitude;

    @JsonSetter("latitude")
    private double latitude;

    @JsonSetter("name")
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
