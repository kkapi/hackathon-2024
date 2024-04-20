package com.hacathon.Connector;

import com.hacathon.Domain.PlaceInStPetersburg;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttractionsConnector {

    public List<PlaceInStPetersburg> getPlace() {
        return null;
    }

    public List<PlaceInStPetersburg> getPlace(@RequestHeader double longitude, @RequestHeader double latitude, @RequestParam int page) {
        return null;
    }

    public List<PlaceInStPetersburg> getPlace(@RequestHeader double longitude, @RequestHeader double latitude, @RequestHeader String type, @RequestParam int page) {
        return null;
    }
}
