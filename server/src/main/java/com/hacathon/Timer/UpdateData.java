package com.hacathon.Timer;

import com.hacathon.Domain.BeautifulPlace;
import com.hacathon.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UpdateData {
    @Autowired
    WiFiService wiFiService;

    @Autowired
    ToiletService toiletService;

    @Autowired
    MetroService metroService;

    @Autowired
    AttractionsService attractionsService;

    @Autowired
    BeautifulPlaceService beautifulPlaceService;

    @Scheduled(fixedDelay = 3600000)
    public void update() throws IOException {
        wiFiService.updateData();
        toiletService.updateData();
        metroService.updateData();
        attractionsService.updateData();
        beautifulPlaceService.updateData();
    }
}
