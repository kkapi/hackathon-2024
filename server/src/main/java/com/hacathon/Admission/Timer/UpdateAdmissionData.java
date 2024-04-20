package com.hacathon.Admission.Timer;

import com.hacathon.Admission.Service.DirectionsService;
import com.hacathon.Admission.Service.VacanciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UpdateAdmissionData {
    @Autowired
    private DirectionsService directionsService;

    @Autowired
    private VacanciesService vacanciesService;

    @Scheduled(fixedDelay = 3600000)
    public void update() throws IOException {
        directionsService.updateDate();
        vacanciesService.updateData();
    }
}
