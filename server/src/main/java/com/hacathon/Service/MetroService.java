package com.hacathon.Service;

import com.hacathon.Domain.Metro;
import com.hacathon.Domain.Toilet;
import com.hacathon.HttpsRequests.HtmlParsing;
import com.hacathon.Repos.MetroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.management.MemoryType;
import java.util.List;

@Service
public class MetroService {
    @Autowired
    MetroRepo metroRepo;

    private HtmlParsing htmlParsing = new HtmlParsing();

    public void updateData() throws IOException {
        List<Metro> getMetro = htmlParsing.getMetro();
        for(Metro metro : getMetro) {
            metroRepo.save(metro);
        }
    }
}
