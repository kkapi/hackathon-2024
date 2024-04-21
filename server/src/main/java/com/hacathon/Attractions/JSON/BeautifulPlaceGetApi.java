package com.hacathon.Attractions.JSON;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * Данный класс необходим для преобразования данных из JSON
 */
public class BeautifulPlaceGetApi {
    @JsonSetter("count")
    private int count;

    @JsonSetter("page")
    private int page;

    @JsonSetter("size")
    private int size;

    @JsonSetter("data")
    private List<Place> data;

    public BeautifulPlaceGetApi() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Place> getData() {
        return data;
    }

    public void setData(List<Place> data) {
        this.data = data;
    }
}
