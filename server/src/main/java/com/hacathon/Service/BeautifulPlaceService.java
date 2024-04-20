package com.hacathon.Service;

import com.hacathon.Domain.BeautifulPlace;
import com.hacathon.HttpsRequests.AttractionsRequests;
import com.hacathon.JSON.BeautifulPlaceGetApi;
import com.hacathon.JSON.Place;
import com.hacathon.Repos.BeautifulPlaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeautifulPlaceService {
    @Autowired
    BeautifulPlaceRepo beautifulPlaceRepo;

    private AttractionsRequests attractionsRequests = new AttractionsRequests();

    public void updateData() {
        int page = 1;
        int count = 0;
        BeautifulPlaceGetApi getApi = null;
        do {
            getApi = attractionsRequests.beautifulPlaces(page);
            for(Place place : getApi.getData()) {
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
