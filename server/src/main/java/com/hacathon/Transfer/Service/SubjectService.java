package com.hacathon.Transfer.Service;

import com.hacathon.Admission.Domain.Directions;
import com.hacathon.Admission.Domain.Profession;
import com.hacathon.Admission.Domain.Vacancies;
import com.hacathon.Transfer.Domain.Subject;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    public List<Directions> findDirections(String profession, String plan) {
        
    }

    public List<Subject> findAllSubject() throws IOException, CsvValidationException {
        List<Subject> subjects = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/DataCSV/subject.csv"));
        in.readLine();
        while (in.ready()) {
            CSVReader csvReader = new CSVReader(in);
            String[] split = csvReader.readNext();
            Subject subject = new Subject();
            subject.setNumberPlan(split[5]);
            subject.setSubject(split[2]);
            subjects.add(subject);
        }
        return subjects;
    }

    public List<Subject> findBySubject(String subject) throws IOException, CsvValidationException {
        List<Subject> subjects = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/DataCSV/subject.csv"));
        in.readLine();
        while (in.ready()) {
            CSVReader csvReader = new CSVReader(in);
            String[] split = csvReader.readNext();
            if(subject == split[2]) {
                Subject sub = new Subject();
                sub.setNumberPlan(split[5]);
                sub.setSubject(split[2]);
                subjects.add(sub);
            }
        }
        return subjects;
    }

    public List<Subject> findByPlan(String plan) throws IOException, CsvValidationException {
        List<Subject> subjects = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/DataCSV/subject.csv"));
        in.readLine();
        while (in.ready()) {
            CSVReader csvReader = new CSVReader(in);
            String[] split = csvReader.readNext();
            if(plan == split[5]) {
                Subject sub = new Subject();
                sub.setNumberPlan(split[5]);
                sub.setSubject(split[2]);
                subjects.add(sub);
            }
        }
        return subjects;
    }
}
