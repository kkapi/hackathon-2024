package com.hacathon.Domain;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Attractions {
    @Id
    @JsonSetter("oid")
    private long oid;

    @JsonSetter("obj_type")
    private String objType;

    @JsonSetter("name")
    private String name;

    @JsonSetter("short_name")
    private String shortName;

    @JsonSetter("name_en")
    private String nameEn;

    @JsonSetter("type")
    private String type;

    @JsonSetter("address_manual")
    private String addressManual;

    @JsonSetter("phone")
    private String phone;

    @JsonSetter("www")
    private String www;

    @JsonSetter("email")
    private String email;

    @JsonSetter("description")
    @Column(columnDefinition = "TEXT")
    private String description;

    
}
