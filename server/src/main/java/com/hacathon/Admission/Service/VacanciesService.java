package com.hacathon.Admission.Service;

import com.hacathon.Admission.Domain.Profession;
import com.hacathon.Admission.Domain.Vacancies;
import com.hacathon.Admission.Repos.ProfessionRepo;
import com.hacathon.Admission.Repos.VacanciesRepo;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Сервис, содержит логику для класса Vacancies, используется для связи с соответствубщей БД из других частей программы
 */
@Service
public class VacanciesService {
    @Autowired
    VacanciesRepo vacanciesRepo;

    @Autowired
    ProfessionRepo professionRepo;

    public void updateData() throws IOException, CsvValidationException {
        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/DataCSV/Vacancies.csv"));
        in.readLine();
        while (in.ready()) {
            CSVReader csvReader = new CSVReader(in);
            String[] split = csvReader.readNext();
            Profession profession = new Profession();
            profession.setProfession(split[1]);
            Vacancies vacancies = new Vacancies();
            if(!split[1].equals(""))
                professionRepo.save(profession);
            if(!(split.length <= 4) && !split[1].equals("")) {
                vacancies.setGroupVacancies(profession);
                vacancies.setSubject(split[4]);
                vacanciesRepo.save(vacancies);
            }
        }
    }

    public Optional<Vacancies> findSubject(String id) {
        return vacanciesRepo.findById(id);
    }

    public Profession findProfessionById(String profession) {
        return professionRepo.findById(profession).get();
    }

    public List<Profession> findAllProfession() {
        return professionRepo.findAll();
    }
}
