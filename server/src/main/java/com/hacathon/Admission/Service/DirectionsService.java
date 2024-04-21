package com.hacathon.Admission.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hacathon.Admission.Domain.Directions;
import com.hacathon.Admission.Domain.Profession;
import com.hacathon.Admission.Domain.Vacancies;
import com.hacathon.Admission.Repos.DirectionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DirectionsService {
    @Autowired
    DirectionsRepo directionsRepo;

    @Autowired
    VacanciesService vacanciesService;

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

    public void updateProfession() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/DataCSV/subject.csv"));
        in.readLine();
        while (in.ready()) {
            String line = in.readLine();
            String[] split = line.split(",");
            String number = split[5];
            String subject = split[2];
            Optional<Vacancies> vacancies = vacanciesService.findSubject(subject);
            Optional<Directions> directions = directionsRepo.findById(number);
            if(!vacancies.isEmpty() && !directions.isEmpty()) {
                directions.get().addProfession(vacancies.get().getGroupVacancies());
                directionsRepo.save(directions.get());
            }
        }
    }

    public List<Directions> getAllDirections() {
        return directionsRepo.findAll();
    }

    public List<Directions> getWithProfession(String profession) {
        return directionsRepo.findByProfession(vacanciesService.findProfessionById(profession));
    }

    public Directions getForId(String s) {
        return directionsRepo.findById(s).get();
    }
}
