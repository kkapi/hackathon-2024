package com.hacathon.House.Timer;

import com.hacathon.House.Service.HSCService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UpdateDateHouse {
    @Autowired
    private HSCService service;

    @Scheduled(fixedDelay = 3600000)
    public void update() throws CsvValidationException, IOException {
        service.update();
    }
}
