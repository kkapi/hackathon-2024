package com.hacathon.Attractions.Service;

import com.hacathon.Attractions.Domain.Metro;
import com.hacathon.Attractions.HttpsRequests.HtmlParsing;
import com.hacathon.Attractions.Repos.MetroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MetroService {
    @Autowired
    private MetroRepo metroRepo;

    private HtmlParsing htmlParsing = new HtmlParsing();

    public void updateData() throws IOException {
        List<Metro> getMetro = htmlParsing.getMetro();
        for(Metro metro : getMetro) {
            metroRepo.save(metro);
        }
    }

    public Metro findNear(double[] coord) {
        return metroRepo.findNear(coord[0], coord[1]).get(0);
    }
}
