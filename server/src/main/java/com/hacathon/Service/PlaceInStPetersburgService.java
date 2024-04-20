package com.hacathon.Service;

import com.hacathon.Domain.Attractions;
import com.hacathon.Domain.BeautifulPlace;
import com.hacathon.Domain.PlaceInStPetersburg;
import com.hacathon.Repos.PlaceInStPetersburgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceInStPetersburgService {
    @Autowired
    PlaceInStPetersburgRepo placeRepo;

    @Autowired
    AttractionsService attractionsService;

    @Autowired
    MetroService metroService;

    @Autowired
    ToiletService toiletService;

    @Autowired
    WiFiService wiFiService;

    @Autowired
    BeautifulPlaceService beautifulPlaceService;

    public void updateData(){
        List<Attractions> attractions = attractionsService.findAll();
        for(Attractions attraction : attractions) {
            PlaceInStPetersburg place = new PlaceInStPetersburg();
            place.setAttractions(attraction);
            place.setType("Достопримечательность");
            place.setCategory("Достопримечательность");
            place.setLongitude(attraction.getCoord()[0]);
            place.setLatitude(attraction.getCoord()[1]);
            place.setMetro(metroService.findNear(attraction.getCoord()));
            place.setToilets(toiletService.findNear(attraction.getCoord()));
            place.setWiFi(wiFiService.findNear(attraction.getCoord(), 300));
            place.setId(attraction.getOid() + 1000);
            placeRepo.save(place);
        }
        List<BeautifulPlace> beautifulPlaces = beautifulPlaceService.findAll();
        for(BeautifulPlace beautifulPlace : beautifulPlaces) {
            PlaceInStPetersburg place = new PlaceInStPetersburg();
            place.setBeautifulPlace(beautifulPlace);
            place.setType("Красивое Место");
            place.setCategory(beautifulPlace.getCategories().get(0));
            place.setLongitude(beautifulPlace.getCoordinates()[0]);
            place.setLatitude(beautifulPlace.getCoordinates()[1]);
            place.setMetro(metroService.findNear(beautifulPlace.getCoordinates()));
            place.setToilets(toiletService.findNear(beautifulPlace.getCoordinates()));
            place.setWiFi(wiFiService.findNear(beautifulPlace.getCoordinates(), 300));
            place.setId(beautifulPlace.getId() + 10000);
            placeRepo.save(place);
        }
    }

    public List<PlaceInStPetersburg> findPlace(int page) {
        return placeRepo.findNear(59.93896075425981,30.315823307438492, PageRequest.of(page, 10));
    }
}
