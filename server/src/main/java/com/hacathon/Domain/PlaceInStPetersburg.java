package com.hacathon.Domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PlaceInStPetersburg {
    @Id
    private long id;

    private String type;

    private double longitude;
    private double latitude;

    @OneToOne
    private Attractions attractions;

    @OneToOne
    private BeautifulPlace beautifulPlace;

    @OneToMany
    private List<Toilet> toilets;

    @OneToOne
    private Metro metro;

    @OneToMany
    private List<WiFi> wiFi;

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
}
