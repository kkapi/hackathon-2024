package com.hacathon.House.Service;

import com.hacathon.Attractions.Domain.PlaceInStPetersburg;
import com.hacathon.Attractions.HttpsRequests.ApiGeocoder;
import com.hacathon.Attractions.Service.PlaceInStPetersburgService;
import com.hacathon.Attractions.Service.WiFiService;
import com.hacathon.House.HttpsRequest.SportRequest;
import com.hacathon.House.domain.InformationHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationService {
    @Autowired
    private HSCService hscService;

    @Autowired
    private WiFiService wiFiService;

    @Autowired
    private PlaceInStPetersburgService placeInStPetersburgService;

    private SportRequest sportRequest = new SportRequest();

    public InformationHouse getInformation(String address, int radius) {
        InformationHouse informationHouse = new InformationHouse();
        double[] coordinates = new ApiGeocoder().ApiGeoCodeJustAbout(address);
        if(coordinates == null || (coordinates[0] == 0 && coordinates[1] == 0))
            return null;
        informationHouse.setPrice(hscService.findPrice(coordinates));
        informationHouse.setHaveWiFi(wiFiService.haveWiFi(coordinates));
        informationHouse.setBeautifulPlace(placeInStPetersburgService.findPlaceWithCoordinatesAll(coordinates, radius));
        informationHouse.setSport(sportRequest.sportHttp(coordinates[0], coordinates[1], (int) ((double)radius/1000d)));
        return informationHouse;
    }
}
