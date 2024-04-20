package com.hacathon.Attractions.Service;

import com.hacathon.Attractions.Domain.Toilet;
import com.hacathon.Attractions.HttpsRequests.HtmlParsing;
import com.hacathon.Attractions.Repos.ToiletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ToiletService {
    @Autowired
    private ToiletRepo toiletRepo;

    private HtmlParsing htmlParsing = new HtmlParsing();

    public void updateData() throws IOException {
        List<Toilet> getToilet = htmlParsing.getToilet();
        for(Toilet toilet : getToilet) {
            toiletRepo.save(toilet);
        }
    }

    public Toilet findNear(double[] coord) {
        return toiletRepo.findNear(coord[0], coord[1]).get(0);
    }
}
