package com.hacathon.Attractions.Service;

import com.hacathon.Attractions.Domain.BeautifulPlace;
import com.hacathon.Attractions.HttpsRequests.AttractionsRequests;
import com.hacathon.Attractions.JSON.BeautifulPlaceGetApi;
import com.hacathon.Attractions.JSON.Place;
import com.hacathon.Attractions.Repos.BeautifulPlaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeautifulPlaceService {
    @Autowired
    private BeautifulPlaceRepo beautifulPlaceRepo;

    private AttractionsRequests attractionsRequests = new AttractionsRequests();

    public void updateData() {
        int page = 1;
        int count = 0;
        BeautifulPlaceGetApi getApi = null;
        do {
            getApi = attractionsRequests.beautifulPlaces(page);
            for(Place place : getApi.getData()) {
                place.getPlace().setId(place.getPlace().getId() + 1);
                beautifulPlaceRepo.save(place.getPlace());
            }
            count = getApi.getCount();
            page++;
        } while (page <= (count/10)+1);
    }

    public List<BeautifulPlace> findAll() {
        return beautifulPlaceRepo.findAll();
    }
}
