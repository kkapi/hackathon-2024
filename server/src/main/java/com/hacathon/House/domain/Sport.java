package com.hacathon.House.domain;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Класс хранит информацию о спортивной площадке
 */
public class Sport {
    @JsonSetter("name")
    private String name;

    @JsonSetter("categories")
    private String categories;

    @JsonSetter("address")
    private String address;

    public Sport() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
