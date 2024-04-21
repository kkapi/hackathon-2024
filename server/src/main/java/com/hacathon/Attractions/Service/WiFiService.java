package com.hacathon.Attractions.Service;

import com.hacathon.Attractions.Domain.WiFi;
import com.hacathon.Attractions.HttpsRequests.WiFiRequests;
import com.hacathon.Attractions.JSON.WiFiApiGet;
import com.hacathon.Attractions.Repos.WiFiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Содержит логику для класса Wi_Fi, служит для связи с соответствубщей БД из других мест программы
 */
@Service
public class WiFiService {
    @Autowired
    private WiFiRepo wiFiRepo;

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

    public List<WiFi> findNear(double[] coordinates, double radius) {
        List<WiFi> wiFis = wiFiRepo.findNeedPoint(coordinates[0], coordinates[1], radius);
        return wiFis;
    }

    public boolean haveWiFi(double[] coordinates) {
        if(wiFiRepo.findNeedPoint(coordinates[0], coordinates[1], 150).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
