package com.hacathon.House.Controller;

import com.hacathon.House.Service.InformationService;
import com.hacathon.House.domain.InformationHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Класс с контроллерами для работы страницы по оценку жилья
 */
@RestController
public class HouseController {
    @Autowired
    InformationService informationService;

    @CrossOrigin
    @GetMapping(value = "/House", params = {"address", "radius"})
    public InformationHouse getInfo(@RequestParam String address, @RequestParam int radius) {
        return informationService.getInformation(address, radius);
    }

    @CrossOrigin
    @GetMapping(value = "/House", params = {"address"})
    public InformationHouse getInfo(@RequestParam String address) {
        return informationService.getInformation(address, 3000);
    }
}
