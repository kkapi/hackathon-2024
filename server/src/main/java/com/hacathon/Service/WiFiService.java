package com.hacathon.Service;

import com.hacathon.Domain.WiFi;
import com.hacathon.HttpsRequests.WiFiRequests;
import com.hacathon.JSON.BeautifulPlaceGetApi;
import com.hacathon.JSON.Place;
import com.hacathon.JSON.WiFiApiGet;
import com.hacathon.Repos.WiFiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WiFiService {
    @Autowired
    WiFiRepo wiFiRepo;

    private WiFiRequests wiFiRequests = new WiFiRequests();

    public void updateData() {
        int page = 1;
        int count = 0;
        WiFiApiGet getApi = null;
        do {
            getApi = wiFiRequests.wiFiHttp(page);
            for(WiFi wiFi : getApi.getResults()) {
                wiFiRepo.save(wiFi);
            }
            count = getApi.getCount();
            page++;
        } while (page <= (count/100)+1);
    }

    public List<WiFi> findAll(){
        return wiFiRepo.findAll();
    }
}
