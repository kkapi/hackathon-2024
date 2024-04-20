package com.hacathon.Connector;

import com.hacathon.Domain.PlaceInStPetersburg;
import com.hacathon.Service.PlaceInStPetersburgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttractionsConnector {
    @Autowired
    PlaceInStPetersburgService placeInStPetersburgService;

    @CrossOrigin
    @GetMapping("/getAttractions")
    public List<PlaceInStPetersburg> getPlace() {
        return placeInStPetersburgService.findPlace(1);
    }

    @CrossOrigin
    @GetMapping(value = "getAttractions", params = {"page"})
    public List<PlaceInStPetersburg> getPlace(@RequestParam(value = "page") int page) {
        return placeInStPetersburgService.findPlace(page);
    }

    public List<PlaceInStPetersburg> getPlace(@RequestHeader double longitude, @RequestHeader double latitude, @RequestParam int page) {
        return null;
    }

    public List<PlaceInStPetersburg> getPlace(@RequestHeader double longitude, @RequestHeader double latitude, @RequestHeader String type, @RequestParam int page) {
        return null;
    }
}
