package com.hacathon.Attractions.Timer;

import com.hacathon.Attractions.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Класс содержит методы, запускаемые по таймеру и занимающиеся обновлением данных
 */
@Component
public class UpdateData {
    @Autowired
    private WiFiService wiFiService;

    @Autowired
    private ToiletService toiletService;

    @Autowired
    private MetroService metroService;

    @Autowired
    private AttractionsService attractionsService;

    @Autowired
    private BeautifulPlaceService beautifulPlaceService;

    @Autowired
    private PlaceInStPetersburgService stPetersburgService;

    @Scheduled(fixedDelay = 3600000)
    public void update() throws IOException {
        System.out.println("Начинается обновление данных");
        wiFiService.updateData();
        toiletService.updateData();
        metroService.updateData();
        attractionsService.updateData();
        beautifulPlaceService.updateData();
        stPetersburgService.updateData();
        System.out.println("Обновление данных завершено");
    }
}
