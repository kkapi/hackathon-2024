package com.hacathon.Attractions.Domain;

import jakarta.persistence.*;

/**
 * Данный класс хранит информацию о туалетах
 */
@Entity
public class Toilet {
    @Id
    private String address;

    private double lon;
    private double lat;

    public Toilet() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
