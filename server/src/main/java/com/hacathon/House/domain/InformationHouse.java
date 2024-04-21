package com.hacathon.House.domain;

import com.hacathon.Attractions.Domain.PlaceInStPetersburg;

import java.util.List;

/**
 * Класс хранит подготовленную для отправки информацию по оценке жилья
 */
public class InformationHouse {
    private int price;
    private boolean haveWiFi;
    private List<PlaceInStPetersburg> beautifulPlace;
    private List<Sport> sport;
    private String address;
    private double[] coordinate;

    public InformationHouse() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isHaveWiFi() {
        return haveWiFi;
    }

    public void setHaveWiFi(boolean haveWiFi) {
        this.haveWiFi = haveWiFi;
    }

    public List<PlaceInStPetersburg> getBeautifulPlace() {
        return beautifulPlace;
    }

    public void setBeautifulPlace(List<PlaceInStPetersburg> beautifulPlace) {
        this.beautifulPlace = beautifulPlace;
    }

    public List<Sport> getSport() {
        return sport;
    }

    public void setSport(List<Sport> sport) {
        this.sport = sport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double[] getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(double[] coordinate) {
        this.coordinate = coordinate;
    }
}
