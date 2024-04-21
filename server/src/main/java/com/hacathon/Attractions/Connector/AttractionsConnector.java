package com.hacathon.Attractions.Connector;

import com.hacathon.Attractions.Domain.PlaceInStPetersburg;
import com.hacathon.Attractions.Service.PlaceInStPetersburgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Данный контроллер предоставляет информацию о достопримечательностях и красивых местах СПб
 */
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
    @GetMapping(value = "getAttractions", params = {"page", "longitude", "latitude"})
    public List<PlaceInStPetersburg> getPlace(@RequestParam(value = "longitude") double longitude, @RequestParam(value = "latitude") double latitude, @RequestParam(value = "page") int page) {
        return placeInStPetersburgService.findPlaceWithCoordinates(longitude, latitude, page);
    }

    @CrossOrigin
    @GetMapping(value = "getAttractions", params = {"longitude", "latitude"})
    public List<PlaceInStPetersburg> getPlace(@RequestParam(value = "longitude") double longitude, @RequestParam(value = "latitude") double latitude) {
        return placeInStPetersburgService.findPlaceWithCoordinates(longitude, latitude, 1);
    }

    @CrossOrigin
    @GetMapping(value = "getAttractions", params = {"page", "type", "longitude", "latitude"})
    public List<PlaceInStPetersburg> getPlace(@RequestParam(value = "longitude") double longitude, @RequestParam(value = "latitude") double latitude,
                                              @RequestParam(value = "page") int page, @RequestParam(value = "type") String type) {
        return placeInStPetersburgService.findPlaceWithCoordinatesWithType(longitude, latitude, page, type);
    }

    @CrossOrigin
    @GetMapping(value = "getAttractions", params = {"type", "longitude", "latitude"})
    public List<PlaceInStPetersburg> getPlace(@RequestParam(value = "longitude") double longitude, @RequestParam(value = "latitude") double latitude,
                                              @RequestParam(value = "type") String type) {
        return placeInStPetersburgService.findPlaceWithCoordinatesWithType(longitude, latitude, 1, type);
    }

    @CrossOrigin
    @GetMapping(value = "getAttractions", params = {"type"})
    public List<PlaceInStPetersburg> getPlace(@RequestParam(value = "type") String type) {
        return placeInStPetersburgService.findPlaceWithCoordinatesWithType(59.93896075425981, 30.315823307438492, 1, type);
    }

    @CrossOrigin
    @GetMapping(value = "getAttractions", params = {"type", "page"})
    public List<PlaceInStPetersburg> getPlace(@RequestParam(value = "type") String type, @RequestParam(value = "page") int page) {
        return placeInStPetersburgService.findPlaceWithCoordinatesWithType(59.93896075425981, 30.315823307438492, page, type);
    }

    @CrossOrigin
    @GetMapping(value = "/getAttractions", params = {"page", "hasWiFi", "longitude", "latitude"})
    public List<PlaceInStPetersburg> getPlaceWithWiFi(@RequestParam(value = "longitude") double longitude, @RequestParam(value = "latitude") double latitude,
                                                      @RequestParam(value = "page") int page, @RequestParam(value = "hasWiFi") int hasWiFi){
        return placeInStPetersburgService.findPlaceWithCoordinatesWithWiFi(longitude, latitude, page);
    }

    @CrossOrigin
    @GetMapping(value = "getAttractions", params = {"page", "type", "hasWiFi", "longitude", "latitude"})
    public List<PlaceInStPetersburg> getPlace(@RequestParam(value = "longitude") double longitude, @RequestParam(value = "latitude") double latitude,
                                              @RequestParam(value = "page") int page, @RequestParam(value = "type") String type, @RequestParam(value = "hasWiFi") int hasWiFi) {
        return placeInStPetersburgService.findPlaceWithCoordinatesWithTypeWithWiFi(longitude, latitude, page, type);
    }

    @CrossOrigin
    @GetMapping(value = "/getAttractions", params = {"page", "hasWiFi"})
    public List<PlaceInStPetersburg> getPlaceWithWiFi(@RequestParam(value = "page") int page, @RequestParam(value = "hasWiFi") int hasWiFi){
        return placeInStPetersburgService.findPlaceWithCoordinatesWithTypeWithWiFiType(59.93896075425981, 30.315823307438492, page, "Красивое Место");
    }

    @CrossOrigin
    @GetMapping(value = "getAttractions", params = {"page", "type", "hasWiFi"})
    public List<PlaceInStPetersburg> getPlace(@RequestParam(value = "page") int page, @RequestParam(value = "type") String type, @RequestParam(value = "hasWiFi") int hasWiFi) {
        return placeInStPetersburgService.findPlaceWithCoordinatesWithTypeWithWiFi(59.93896075425981, 30.315823307438492, page, type);
    }

    @CrossOrigin
    @GetMapping(value = "/getAttractions", params = {"hasWiFi"})
    public List<PlaceInStPetersburg> getPlaceWithWiFi(@RequestParam(value = "hasWiFi") int hasWiFi){
        return placeInStPetersburgService.findPlaceWithCoordinatesWithTypeWithWiFiType(59.93896075425981, 30.315823307438492, 1, "Красивое Место");
    }

    @CrossOrigin
    @GetMapping(value = "getAttractions", params = {"type", "hasWiFi"})
    public List<PlaceInStPetersburg> getPlace(@RequestParam(value = "type") String type, @RequestParam(value = "hasWiFi") long hasWiFi) {
        return placeInStPetersburgService.findPlaceWithCoordinatesWithTypeWithWiFi(59.93896075425981, 30.315823307438492, 1, type);
    }
}
