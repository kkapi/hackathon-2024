package com.hacathon.Admission.Timer;

import com.hacathon.Admission.Service.DirectionsService;
import com.hacathon.Admission.Service.VacanciesService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Класс содержит методы, запускаемые по таймеру и занимающиеся обновлением данных
 */
@Component
public class UpdateAdmissionData {
    @Autowired
    private DirectionsService directionsService;

    @Autowired
    private VacanciesService vacanciesService;

    @Scheduled(fixedDelay = 3600000)
    public void update() throws IOException, CsvValidationException {
        directionsService.updateDate();
        vacanciesService.updateData();
        directionsService.updateProfession();
    }
}
