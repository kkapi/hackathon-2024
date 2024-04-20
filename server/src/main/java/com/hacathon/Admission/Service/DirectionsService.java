package com.hacathon.Admission.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hacathon.Admission.Domain.Directions;
import com.hacathon.Admission.Repos.DirectionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class DirectionsService {
    @Autowired
    DirectionsRepo directionsRepo;

    public void updateDate() throws IOException {
        String json = new String(Files.readAllBytes(Paths.get("src/main/resources/DataJSON/Directions.json")));
        String[] split = json.substring(1, json.length()-1).split("},");
        for(String s : split) {
            s = s + "}";
            ObjectMapper objectMapper = new ObjectMapper();
            Directions directions = objectMapper.readValue(s, Directions.class);
            directions.setNumber(directions.getDirection().split(" ")[0]);
            directionsRepo.save(directions);
        }
    }

}
