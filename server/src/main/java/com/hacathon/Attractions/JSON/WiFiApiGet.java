package com.hacathon.Attractions.JSON;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.hacathon.Attractions.Domain.WiFi;

import java.util.List;

/**
 * Данный класс необходим для преобразования данных из JSON
 */
public class WiFiApiGet {
    @JsonSetter("count")
    private int count;

    @JsonSetter("next")
    private String next;

    @JsonSetter("previous")
    private String previus;

    @JsonSetter("results")
    private List<WiFi> results;

    public WiFiApiGet() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevius() {
        return previus;
    }

    public void setPrevius(String previus) {
        this.previus = previus;
    }

    public List<WiFi> getResults() {
        return results;
    }

    public void setResults(List<WiFi> results) {
        this.results = results;
    }
}
