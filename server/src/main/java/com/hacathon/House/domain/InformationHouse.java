package com.hacathon.House.domain;

import com.hacathon.Attractions.Domain.PlaceInStPetersburg;

import java.util.List;

public class InformationHouse {
    private int price;
    private boolean haveWiFi;
    private List<PlaceInStPetersburg> beautifulPlace;
    private List<Sport> sport;

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
}
