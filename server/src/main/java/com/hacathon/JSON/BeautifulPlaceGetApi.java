package com.hacathon.JSON;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.hacathon.Domain.BeautifulPlace;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс необходимый для полученния данных с API красивые места
 * @author Nair Irgalin
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
