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
            getApi = attractionsRequests.attractionsHttp("https://spb-classif.gate.petersburg.ru/api/v2/datasets/134/versions/latest/data/157/?per_page=100&page=" + page);
            for(Attractions attractions : getApi.getResults()) {
                attractions.setCategory("Достопримечательность");
                attractionsRepo.save(attractions);
            }
            count = getApi.getCount();
            page++;
        } while (page <= (count/100)+1);

        page = 1;
        count = 0;
        do {
            getApi = attractionsRequests.attractionsHttp("https://spb-classif.gate.petersburg.ru/api/v2/datasets/145/versions/latest/data/649/?per_page=100&page=" + page);
            for(Attractions attractions : getApi.getResults()) {
                attractions.setCategory("Театр");
                attractionsRepo.save(attractions);
            }
            count = getApi.getCount();
            page++;
        } while (page <= (count/100)+1);

        page = 1;
        count = 0;
        do {
            getApi = attractionsRequests.attractionsHttp("https://spb-classif.gate.petersburg.ru/api/v2/datasets/139/versions/latest/data/569/?per_page=100&page=" + page);
            for(Attractions attractions : getApi.getResults()) {
                if(attractions.getCoord() != null) {
                    attractions.setCategory("Музей");
                    attractionsRepo.save(attractions);
                }
            }
            count = getApi.getCount();
            page++;
        } while (page <= (count/100)+1);
    }

    public List<Attractions> findAll() {
        return attractionsRepo.findAll();
    }
}
