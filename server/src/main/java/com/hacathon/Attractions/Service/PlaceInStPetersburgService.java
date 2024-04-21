package com.hacathon.Attractions.Service;

import com.hacathon.Attractions.Domain.Attractions;
import com.hacathon.Attractions.Domain.BeautifulPlace;
import com.hacathon.Attractions.Domain.PlaceInStPetersburg;
import com.hacathon.Attractions.Domain.WiFi;
import com.hacathon.Attractions.Repos.PlaceInStPetersburgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

/**
 * Содержит логику для класса PlaceInStPetersburgService, служит для связи с соответствубщей БД из других мест программы
 */
@Service
public class PlaceInStPetersburgService {
    @Autowired
    private PlaceInStPetersburgRepo placeRepo;

    @Autowired
    private AttractionsService attractionsService;

    @Autowired
    private MetroService metroService;

    @Autowired
    private ToiletService toiletService;

    @Autowired
    private WiFiService wiFiService;

    @Autowired
    private BeautifulPlaceService beautifulPlaceService;

    public void updateData(){
        List<Attractions> attractions = attractionsService.findAll();
        for(Attractions attraction : attractions) {
            PlaceInStPetersburg place = new PlaceInStPetersburg();
            place.setAttractions(attraction);
            place.setType("Достопримечательность");
            place.setCategory(attraction.getCategory());
            place.setLongitude(attraction.getCoord()[0]);
            place.setLatitude(attraction.getCoord()[1]);
            place.setMetro(metroService.findNear(attraction.getCoord()));
            place.setToilets(toiletService.findNear(attraction.getCoord()));
            List<WiFi> wiFis = wiFiService.findNear(attraction.getCoord(), 300);
            place.setWiFi(wiFis);
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
        return placeRepo.findNearByType(59.93896075425981,30.315823307438492, "Красивое Место", PageRequest.of(page, 9));
    }

    public List<PlaceInStPetersburg> findPlaceWithCoordinates(double longitude, double latitude, int page) {
        return placeRepo.findNear(longitude,latitude, PageRequest.of(page, 9));
    }

    public List<PlaceInStPetersburg> findPlaceWithCoordinatesWithType(double longitude, double latitude, int page, String type) {
        return placeRepo.findNearByCategory(longitude,latitude, type, PageRequest.of(page, 9));
    }

    public List<PlaceInStPetersburg> findPlaceWithCoordinatesWithWiFi(double longitude, double latitude, int page) {
        List<PlaceInStPetersburg> place = placeRepo.findNear(longitude, latitude, PageRequest.of(page, 9));
        ListIterator<PlaceInStPetersburg> iterator = place.listIterator();
        for (ListIterator<PlaceInStPetersburg> it = iterator; it.hasNext(); ) {
            PlaceInStPetersburg p = it.next();
            if(p.getWiFi().size() == 0)
                it.remove();
        }
        return place;
    }

    public List<PlaceInStPetersburg> findPlaceWithCoordinatesWithTypeWithWiFi(double longitude, double latitude, int page, String type) {
        List<PlaceInStPetersburg> place = placeRepo.findNearByCategory(longitude,latitude, type, PageRequest.of(page, 9));
        ListIterator<PlaceInStPetersburg> iterator = place.listIterator();
        for (ListIterator<PlaceInStPetersburg> it = iterator; it.hasNext(); ) {
            PlaceInStPetersburg p = it.next();
            if(p.getWiFi().size() == 0)
                it.remove();
        }
        return place;
    }

    public List<PlaceInStPetersburg> findPlaceWithCoordinatesAll(double[] coordinates, int radius) {
        return placeRepo.findNearAll(coordinates[0], coordinates[1], radius);
    }

    public List<PlaceInStPetersburg> findPlaceWithCoordinatesWithTypeWithWiFiType(double longitude, double latitude, int page, String type) {
        List<PlaceInStPetersburg> place = placeRepo.findNearByType(longitude,latitude, type, PageRequest.of(page, 9));
        ListIterator<PlaceInStPetersburg> iterator = place.listIterator();
        for (ListIterator<PlaceInStPetersburg> it = iterator; it.hasNext(); ) {
            PlaceInStPetersburg p = it.next();
            if(p.getWiFi().size() == 0)
                it.remove();
        }
        return place;
    }
}
