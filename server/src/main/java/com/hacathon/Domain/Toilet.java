package com.hacathon.Domain;

import jakarta.persistence.*;

@Entity
public class Toilet {
    @Id
    private String address;

    @Transient
    private double[] coordinates;

    public Toilet() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }
}
