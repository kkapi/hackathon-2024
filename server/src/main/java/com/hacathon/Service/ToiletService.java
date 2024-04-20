package com.hacathon.Service;

import com.hacathon.Domain.Toilet;
import com.hacathon.Domain.WiFi;
import com.hacathon.HttpsRequests.HtmlParsing;
import com.hacathon.JSON.WiFiApiGet;
import com.hacathon.Repos.ToiletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ToiletService {
    @Autowired
    ToiletRepo toiletRepo;

    private HtmlParsing htmlParsing = new HtmlParsing();

    public void updateData() throws IOException {
        List<Toilet> getToilet = htmlParsing.getToilet();
        for(Toilet toilet : getToilet) {
            toiletRepo.save(toilet);
        }
    }
}
