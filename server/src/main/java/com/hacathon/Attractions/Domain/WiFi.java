package com.hacathon.Attractions.Domain;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class WiFi {
    @Id
    @JsonSetter("number")
    private long number;

    @JsonSetter("address")
    private String address;

    @JsonSetter("district")
    private String district;

    @JsonSetter("coverage")
    private int coverage;

    @JsonSetter("status")
    private String status;

    @JsonSetter("coordinates")
    @Transient
    private double[] coordinates;

    private double lon;
    private double lat;

    @ManyToOne
    private PlaceInStPetersburg place_id;

    public void inArray(){
        this.coordinates = new double[2];
        coordinates[0] = lon;
        coordinates[1] = lat;
    }

    public void outArray(){
        lon = coordinates[0];
        lat = coordinates[1];
    }

    public WiFi() {
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getCoverage() {
        return coverage;
    }

    public void setCoverage(int coverage) {
        this.coverage = coverage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double[] getCoordinates() {
        if(coordinates == null)
            inArray();
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
        outArray();
    }
}
