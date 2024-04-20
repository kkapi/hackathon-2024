package com.hacathon.Admission.Service;

import com.hacathon.Admission.Domain.Profession;
import com.hacathon.Admission.Domain.Vacancies;
import com.hacathon.Admission.Repos.ProfessionRepo;
import com.hacathon.Admission.Repos.VacanciesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class VacanciesService {
    @Autowired
    VacanciesRepo vacanciesRepo;

    @Autowired
    ProfessionRepo professionRepo;

    public void updateData() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/DataCSV/Vacancies.csv"));
        in.readLine();
        while (in.ready()) {
            String line = in.readLine();
            String[] split = line.split(",");
            Profession profession = new Profession();
            profession.setProfession(split[1]);
            Vacancies vacancies = new Vacancies();
            vacancies.setGroupVacancies(profession);
            vacancies.setSubject(split[4]);
            professionRepo.save(profession);
            vacanciesRepo.save(vacancies);
        }
    }
}
