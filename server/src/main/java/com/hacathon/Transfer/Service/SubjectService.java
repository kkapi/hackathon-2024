package com.hacathon.Transfer.Service;

import com.hacathon.Admission.Domain.Directions;
import com.hacathon.Admission.Service.DirectionsService;
import com.hacathon.Transfer.Domain.Subject;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Данный сервис содержит логику для обработки информации об классах subject
 */
@Service
public class SubjectService {

    @Autowired
    private DirectionsService directionsService;

    public List<Directions> findDirections(String profession, String plan) throws CsvValidationException, IOException {
        Map<String, Integer> map = new HashMap<>();
        Set<String> oldSet = new HashSet<>();
        List<Subject> old = findByPlan(plan);
        for(Subject subject : old) {
            oldSet.add(subject.getSubject());
        }
        List<Subject> subjects = findByProfession(profession);
        List<String> allPlan = new ArrayList<>();
        for(Subject subject : subjects) {
            if(oldSet.contains(subject.getSubject())) {
                if(!map.containsKey(subject.getNumberPlan())) {
                    allPlan.add(subject.getNumberPlan());
                }
                map.put(subject.getNumberPlan(), map.getOrDefault(subject.getNumberPlan(), 0) + 1);
            }
        }

        allPlan.sort((String a, String b) -> {
            return map.get(b) - map.get(a);
        });

        if(!allPlan.isEmpty() && allPlan.get(0).equals(plan)) {
            allPlan.remove(0);
        }

        List<Directions> directions = new ArrayList<>();

        Directions d = directionsService.getForId(plan);
        d.setCountMatches(old.size());
        directions.add(d);

        for(String s : allPlan) {
            d = directionsService.getForId(s);
            d.setCountMatches(map.get(s));
            directions.add(d);
        }

        return directions;
    }

    public List<Subject> findByPlan(String plan) throws IOException, CsvValidationException {
        List<Subject> subjects = new ArrayList<>();
        Set<String> checkSubject = new HashSet<>();
        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/DataCSV/subject.csv"));
        in.readLine();
        while (in.ready()) {
            CSVReader csvReader = new CSVReader(in);
            String[] split = csvReader.readNext();
            if(plan.equals(split[5]) && !checkSubject.contains(split[2])) {
                Subject sub = new Subject();
                sub.setNumberPlan(split[5]);
                sub.setSubject(split[2]);
                subjects.add(sub);
                checkSubject.add(sub.getSubject());
            }
        }
        return subjects;
    }

    public List<Subject> findByProfession(String profession) throws IOException, CsvValidationException {
        List<Subject> subjects = new ArrayList<>();
        Map<String, Set<String>> checkMap = new HashMap<>();
        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/DataCSV/subject.csv"));
        in.readLine();
        Map<String, Set<String>> map = new HashMap<>();
        for(Directions directions : directionsService.getAllDirections()){
            map.put(directions.getNumber(), new HashSet<>(directions.listString()));
        }
        while (in.ready()) {
            CSVReader csvReader = new CSVReader(in);
            String[] split = csvReader.readNext();
            if(map.containsKey(split[5]) && map.get(split[5]).contains(profession) && !map.getOrDefault(split[5], new HashSet<>()).contains(split[2])) {
                Subject sub = new Subject();
                sub.setNumberPlan(split[5]);
                sub.setSubject(split[2]);
                subjects.add(sub);
                Set<String> set = map.getOrDefault(split[5], new HashSet<>());
                set.add(split[2]);
                map.put(split[5], set);
            }
        }
        return subjects;
    }

    public List<String> getPlans() throws IOException, CsvValidationException {
        Set<String> plans = new HashSet<>();
        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/DataCSV/subject.csv"));
        in.readLine();
        while (in.ready()) {
            CSVReader csvReader = new CSVReader(in);
            String[] split = csvReader.readNext();
            plans.add(split[5]);
        }
        return plans.stream().toList();
    }
}
