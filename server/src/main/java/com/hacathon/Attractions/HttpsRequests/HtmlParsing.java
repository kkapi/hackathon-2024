package com.hacathon.Attractions.HttpsRequests;

import com.hacathon.Attractions.Domain.Metro;
import com.hacathon.Attractions.Domain.Toilet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlParsing {
    private ApiGeocoder apiGeocoder = new ApiGeocoder();

    public List<Toilet> getToilet() throws IOException {
        String blogUrl = "https://www.visit-petersburg.ru/toilets/";
        Document doc = Jsoup.connect(blogUrl).get();
        List<Toilet> toilets = new ArrayList<>();
        for(Element element : doc.select(".content__bulding .map__subtitle")) {
            Toilet toilet = new Toilet();
            double[] coordinates = apiGeocoder.ApiGeoCodeJustAbout(element.text().split("\\(")[0].split("участок")[0]);
            if(coordinates != null){
                toilet.setLon(coordinates[0]);
                toilet.setLat(coordinates[1]);
                toilet.setAddress(element.text().split("\\(")[0].split("участок")[0]);
                toilets.add(toilet);
            }
        }
        return toilets;
    }

    public List<Metro> getMetro() throws IOException {
        List<Metro> metros = new ArrayList<>();
        String blogUrl = "https://ru.wikipedia.org/wiki/Список_станций_Петербургского_метрополитена";
        Document doc = Jsoup.connect(blogUrl).get();
        Elements element = doc.select(".wikitable.sortable tbody tr");
        for(int i = 1; i < element.size(); i++) {
            Metro metro = new Metro();
            metro.setName(element.get(i).child(1).select("a").first().text());
            String coord = element.get(i).child(5).select("a").first().text();
            String coord1 = coord.split("ш")[0].replace(" ", "");
            String coord2 = coord.split("ш")[1].replace(" ", "").replace(".", "");
            double a = Double.parseDouble(coord1.split("°")[0])+Double.parseDouble(coord1.split("°")[1].split("′")[0])/60d+Double.parseDouble(coord1.split("°")[1].split("′")[1].split("″")[0])/3600d;
            double b = Double.parseDouble(coord2.split("°")[0])+Double.parseDouble(coord2.split("°")[1].split("′")[0])/60d+Double.parseDouble(coord2.split("°")[1].split("′")[1].split("″")[0])/3600d;
            metro.setLon(a);
            metro.setLat(b);
            metros.add(metro);
        }
        return metros;
    }
}
