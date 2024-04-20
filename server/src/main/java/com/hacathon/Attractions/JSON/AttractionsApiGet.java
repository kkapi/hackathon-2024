package com.hacathon.Attractions.JSON;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.hacathon.Attractions.Domain.Attractions;

import java.util.List;

public class AttractionsApiGet {
    @JsonSetter("count")
    private int count;

    @JsonSetter("next")
    private String next;

    @JsonSetter("previous")
    private String previus;

    @JsonSetter("results")
    private List<Attractions> results;

    public AttractionsApiGet() {
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

    public List<Attractions> getResults() {
        return results;
    }

    public void setResults(List<Attractions> results) {
        this.results = results;
    }
}
