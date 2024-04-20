package com.hacathon.House.Service;

import com.hacathon.Admission.Domain.Profession;
import com.hacathon.Admission.Domain.Vacancies;
import com.hacathon.Attractions.HttpsRequests.ApiGeocoder;
import com.hacathon.House.Repo.HSCRepo;
import com.hacathon.House.domain.HSC;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class HSCService {
    @Autowired
    private HSCRepo hscRepo;

    public void update() throws IOException, CsvValidationException {
        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/DataCSV/Payment.csv"));
        in.readLine();
        while (in.ready()) {
            CSVReader csvReader = new CSVReader(in);
            String[] split = csvReader.readNext();
            HSC hsc = new HSC();
            hsc.setAddress(split[3]);
            hsc.setPrice((int) Double.parseDouble(split[1]));
            double[] coordinates = new ApiGeocoder().ApiGeoCodeJustAbout(hsc.getAddress());
            if(coordinates != null) {
                hsc.setLon(coordinates[0]);
                hsc.setLat(coordinates[1]);
                hscRepo.save(hsc);
            }
        }
    }
}
