package com.hacathon.Connector;

import com.hacathon.Domain.BeautifulPlace;
import com.hacathon.Service.AttractionsService;
import com.hacathon.Service.BeautifulPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainConnector {
    @Autowired
    BeautifulPlaceService beautifulPlaceService;

    @Autowired
    AttractionsService attractionsService;

    @GetMapping("/test")
    public void test() {
        attractionsService.updateData();
        System.out.println(attractionsService.findAll());
    }
}
