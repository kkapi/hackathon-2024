package com.hacathon.Attractions.Domain;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Attractions {
    @Id
    @JsonSetter("oid")
    private long oid;

    @JsonSetter("obj_type")
    private String objType;

    @JsonSetter("name")
    @Column(length=1000)
    private String name;

    @JsonSetter("short_name")
    private String shortName;

    @JsonSetter("name_en")
    @Column(columnDefinition = "TEXT")
    private String nameEn;

    @JsonSetter("type")
    private String type;

    @JsonSetter("address_manual")
    @Column(columnDefinition = "TEXT")
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

    @JsonSetter("description_en")
    @Column(columnDefinition = "TEXT")
    private String descriptionEn;

    @JsonSetter("obj_history")
    @Column(columnDefinition = "TEXT")
    private String objHistory;

    @JsonSetter("obj_history_en")
    @Column(columnDefinition = "TEXT")
    private String objHistoryEn;

    @JsonSetter("obj_hints")
    @Column(columnDefinition = "TEXT")
    private String obj_hints;

    @JsonSetter("work_time")
    @Column(columnDefinition = "TEXT")
    private String workTime;

    @JsonSetter("work_time_en")
    @Column(columnDefinition = "TEXT")
    private String workTimeEn;

    @JsonSetter("coord")
    @Transient
    private double[] coord;

    private double lon;
    private double lat;

    public void inArray(){
        this.coord = new double[2];
        coord[0] = lat;
        coord[1] = lon;
    }

    public void outArray(){
        lat = coord[0];
        lon = coord[1];
    }

    public Attractions() {
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddressManual() {
        return addressManual;
    }

    public void setAddressManual(String addressManual) {
        this.addressManual = addressManual;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getObjHistory() {
        return objHistory;
    }

    public void setObjHistory(String objHistory) {
        this.objHistory = objHistory;
    }

    public String getObjHistoryEn() {
        return objHistoryEn;
    }

    public void setObjHistoryEn(String objHistoryEn) {
        this.objHistoryEn = objHistoryEn;
    }

    public String getObj_hints() {
        return obj_hints;
    }

    public void setObj_hints(String obj_hints) {
        this.obj_hints = obj_hints;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getWorkTimeEn() {
        return workTimeEn;
    }

    public void setWorkTimeEn(String workTimeEn) {
        this.workTimeEn = workTimeEn;
    }

    public double[] getCoord() {
        if(coord == null)
            inArray();
        return coord;
    }

    public void setCoord(double[] coord) {
        this.coord = coord;
        outArray();
    }
}
