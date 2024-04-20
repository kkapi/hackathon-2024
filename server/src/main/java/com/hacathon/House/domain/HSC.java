package com.hacathon.House.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HSC {
    @Id
    private String address;
    private int price;
    private double lon;
    private double lat;

    public HSC() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
