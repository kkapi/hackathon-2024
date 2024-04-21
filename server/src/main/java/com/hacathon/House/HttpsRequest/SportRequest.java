package com.hacathon.House.HttpsRequest;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.hacathon.House.domain.Sport;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class SportRequest {
    public List<Sport> sportHttp(double longitude, double latitude, int radius) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "https://egs.gate.petersburg.ru/egs/sportgrounds/?location_latitude=" + longitude +"&location_longitude=" + latitude + "&location_radius=" + radius;
        int count = 0;
        List<Sport> sports = new ArrayList<>();
        for(int page = 1; page <= count/10 + 1; page++) {
            //headers.set("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJhU1RaZm42bHpTdURYcUttRkg1SzN5UDFhT0FxUkhTNm9OendMUExaTXhFIn0.eyJleHAiOjE3Nzg0OTcwMTgsImlhdCI6MTY4MzgwMjYxOCwianRpIjoiNTk4NGYzNjItYTJjZi00N2QzLWJmMTUtZTNkNTYxMWEwNDEwIiwiaXNzIjoiaHR0cHM6Ly9rYy5wZXRlcnNidXJnLnJ1L3JlYWxtcy9lZ3MtYXBpIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjM0YjlkNTAxLTk3NDEtNGRkNy1iNjQwLTkzZmFhN2NlNDE2NCIsInR5cCI6IkJlYXJlciIsImF6cCI6ImFkbWluLXJlc3QtY2xpZW50Iiwic2Vzc2lvbl9zdGF0ZSI6ImFlNmNmYjZhLTJjNDQtNGYwMi1hMjJlLWRkNzQyNmE2NzQ5OCIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiLyoiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtZWdzLWFwaSIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJhZTZjZmI2YS0yYzQ0LTRmMDItYTIyZS1kZDc0MjZhNjc0OTgiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiLQvdCw0LjRgCDQuNGA0LPQsNC70LjQvSIsInByZWZlcnJlZF91c2VybmFtZSI6ImZhM2NhMGVmYzA3MGI0YTIwMjI3OTdiNDNhZTAwOWRjIiwiZ2l2ZW5fbmFtZSI6ItC90LDQuNGAIiwiZmFtaWx5X25hbWUiOiLQuNGA0LPQsNC70LjQvSJ9.XIUSrh25jsPDQncKarWzTCeYKOarzbDArnIyp2fMGiicbhDvE8ABwHDOjrNBeeVqXTsoKeqrDRuL5Cly4N5diDpNfXrAMqYSZi3BLMGBqxsUWczEtsda2e-K52VXtLQhXkOCPBQVgisGzDwc01JbmNo03fAN5V4LDVGQIwM5Nlr-MgG5SBcE02WcGQ5FezaiQRmrcqtQaQo4FCntKl0iBRePtEOv__IHuBZcG-oMqER4v7fvvXKTZQvIZ0Dp-Ujk14mZNLkJ0H9pW0WK73avG0nouS2u4AybSWGUNw4hUx09uiO9vqxwAp6VzDtBtZxTF-QKzu8AhuNWhuMneMtGcg");
            HttpEntity entity = new HttpEntity(headers);
            ResponseEntity<SportApiGet> response = restTemplate.exchange(url + "&page=" + page, HttpMethod.GET, entity, SportApiGet.class);
            SportApiGet sportApiGet = response.getBody();
            for (PlaceSport s : sportApiGet.getData()) {
                sports.add(s.getPlace());
            }
            count = sportApiGet.count;
        }
        return sports;
    }

    private static class SportApiGet {
        @JsonSetter("count")
        private int count;

        @JsonSetter("data")
        private List<PlaceSport> data;

        public SportApiGet() {
        }

        public List<PlaceSport> getData() {
            return data;
        }

        public void setData(List<PlaceSport> data) {
            this.data = data;
        }
    }

    private static class PlaceSport {
        @JsonSetter("place")
        private Sport place;

        public PlaceSport() {
        }

        public Sport getPlace() {
            return place;
        }

        public void setPlace(Sport place) {
            this.place = place;
        }
    }
}
