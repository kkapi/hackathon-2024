package com.hacathon.Attractions.Domain;

import jakarta.persistence.*;

import java.util.List;

/**
 * Класс хранит обработанную и подготовленную к отправке информацию о интересных метсах питера
 */
@Entity
public class PlaceInStPetersburg {
    @Id
    private long id;

    private String type;
    private String category;

    private double longitude;
    private double latitude;

    @OneToOne
    private Attractions attractions;

    @OneToOne
    private BeautifulPlace beautifulPlace;

    @OneToOne
    private Toilet toilets;

    @OneToOne
    private Metro metro;

    @ManyToMany
    private List<WiFi> wiFi;

    private int countWiFi = 0;

    public PlaceInStPetersburg() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Attractions getAttractions() {
        return attractions;
    }

    public void setAttractions(Attractions attractions) {
        this.attractions = attractions;
    }

    public BeautifulPlace getBeautifulPlace() {
        return beautifulPlace;
    }

    public void setBeautifulPlace(BeautifulPlace beautifulPlace) {
        this.beautifulPlace = beautifulPlace;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Metro getMetro() {
        return metro;
    }

    public void setMetro(Metro metro) {
        this.metro = metro;
    }

    public List<WiFi> getWiFi() {
        return wiFi;
    }

    public void setWiFi(List<WiFi> wiFi) {
        this.wiFi = wiFi;
        if(!wiFi.isEmpty()) {
            this.countWiFi = wiFi.size();
        }
    }

    public Toilet getToilets() {
        return toilets;
    }

    public void setToilets(Toilet toilets) {
        this.toilets = toilets;
    }

    public int getCountWiFi() {
        return countWiFi;
    }

    public void setCountWiFi(int countWiFi) {
        this.countWiFi = countWiFi;
    }
}
