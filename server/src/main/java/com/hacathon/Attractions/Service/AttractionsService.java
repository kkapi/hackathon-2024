package com.hacathon.Attractions.Service;

import com.hacathon.Attractions.Domain.Attractions;
import com.hacathon.Attractions.HttpsRequests.AttractionsRequests;
import com.hacathon.Attractions.JSON.AttractionsApiGet;
import com.hacathon.Attractions.Repos.AttractionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionsService {
    @Autowired
    private AttractionsRepo attractionsRepo;

    private AttractionsRequests attractionsRequests = new AttractionsRequests();

    public void updateData() {
        int page = 1;
        int count = 0;
        AttractionsApiGet getApi = null;
        do {
            getApi = attractionsRequests.attractionsHttp(page);
            for(Attractions attractions : getApi.getResults()) {
                attractionsRepo.save(attractions);
            }
            count = getApi.getCount();
            page++;
        } while (page <= (count/100)+1);
    }

    public List<Attractions> findAll() {
        return attractionsRepo.findAll();
    }
}
