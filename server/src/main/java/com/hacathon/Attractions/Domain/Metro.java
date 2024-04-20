package com.hacathon.Attractions.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Metro {
    @Id
    private String name;

    private double lon;
    private double lat;

    public Metro() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
