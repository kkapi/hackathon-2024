package com.hacathon.Attractions.Connector;

import com.hacathon.Attractions.Domain.PlaceInStPetersburg;
import com.hacathon.Attractions.Service.PlaceInStPetersburgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttractionsConnector {
    @Autowired
    private PlaceInStPetersburgService placeInStPetersburgService;

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

    @CrossOrigin
    @GetMapping(value = "getAttractions", params = {"page"}, headers = {"longitude", "latitude"})
    public List<PlaceInStPetersburg> getPlace(@RequestHeader(value = "longitude") double longitude, @RequestHeader(value = "latitude") double latitude, @RequestParam(value = "page") int page) {
        return placeInStPetersburgService.findPlaceWithCoordinates(longitude, latitude, page);
    }

    @CrossOrigin
    @GetMapping(value = "getAttractions", headers = {"longitude", "latitude"})
    public List<PlaceInStPetersburg> getPlace(@RequestHeader(value = "longitude") double longitude, @RequestHeader(value = "latitude") double latitude) {
        return placeInStPetersburgService.findPlaceWithCoordinates(longitude, latitude, 1);
    }

    @CrossOrigin
    @GetMapping(value = "getAttractions", params = {"page", "type"}, headers = {"longitude", "latitude"})
    public List<PlaceInStPetersburg> getPlace(@RequestHeader(value = "longitude") double longitude, @RequestHeader(value = "latitude") double latitude,
                                              @RequestParam(value = "page") int page, @RequestParam(value = "type") String type) {
        return placeInStPetersburgService.findPlaceWithCoordinatesWithType(longitude, latitude, page, type);
    }

    @CrossOrigin
    @GetMapping(value = "getAttractions", params = {"type"}, headers = {"longitude", "latitude"})
    public List<PlaceInStPetersburg> getPlace(@RequestHeader(value = "longitude") double longitude, @RequestHeader(value = "latitude") double latitude,
                                              @RequestParam(value = "type") String type) {
        return placeInStPetersburgService.findPlaceWithCoordinatesWithType(longitude, latitude, 1, type);
    }
}
