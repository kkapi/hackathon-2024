package com.hacathon.Domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;

import java.util.List;


/**
 * Класс для хранения информации о красивых местах
 * @author Nair Irgalin
 */
@Entity
public class BeautifulPlace {
        @Id
        @JsonSetter("id")
        private long id;

        @JsonSetter("title")
        private String title;

        @JsonSetter("description")
        @Column(columnDefinition = "TEXT")
        private String description;

        @JsonSetter("coordinates")
        @Transient
        private double[] coordinates;

        @JsonSetter("area")
        private String area;

        @JsonSetter("address")
        private String address;

        @JsonSetter("keywords")
        private String keywords;

        @JsonSetter("categories")
        @Transient
        private List<String> categories;

        @JsonSetter("link_to_photos")
        @Transient
        private List<String> linkToPhotos;

        @JsonSetter("site")
        private String site;

        @JsonSetter("data_source")
        @Column(columnDefinition = "TEXT")
        private String dataSource;

        @JsonSetter("district")
        private String district;

        public BeautifulPlace() {
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double[] getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(double[] coordinates) {
            this.coordinates = coordinates;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public List<String> getCategories() {
            return categories;
        }

        public void setCategories(List<String> categories) {
            this.categories = categories;
        }

        public List<String> getLinkToPhotos() {
            return linkToPhotos;
        }

        public void setLinkToPhotos(List<String> linkToPhotos) {
            this.linkToPhotos = linkToPhotos;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getDataSource() {
            return dataSource;
        }

        public void setDataSource(String dataSource) {
            this.dataSource = dataSource;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }
}
