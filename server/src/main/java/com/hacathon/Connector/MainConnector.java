package com.hacathon.Connector;

import com.hacathon.Domain.Metro;
import com.hacathon.HttpsRequests.HtmlParsing;
import com.hacathon.Service.AttractionsService;
import com.hacathon.Service.BeautifulPlaceService;
import com.hacathon.Service.WiFiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class MainConnector {
    @Autowired
    BeautifulPlaceService beautifulPlaceService;

    @Autowired
    AttractionsService attractionsService;

    @Autowired
    WiFiService wiFiService;

    @GetMapping("/test")
    public List<Metro> test() throws IOException {
        HtmlParsing htmlParsing = new HtmlParsing();
        return htmlParsing.getMetro();
    }
}
