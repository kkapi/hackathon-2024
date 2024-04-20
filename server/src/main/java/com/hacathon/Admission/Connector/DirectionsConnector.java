package com.hacathon.Admission.Connector;

import com.hacathon.Admission.Domain.Directions;
import com.hacathon.Admission.Domain.Profession;
import com.hacathon.Admission.Service.DirectionsService;
import com.hacathon.Admission.Service.VacanciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DirectionsConnector {
    @Autowired
    private DirectionsService directionsService;

    @Autowired
    private VacanciesService vacanciesService;

    @CrossOrigin
    @GetMapping("/getProfessions")
    public List<Profession> getProfessions() {
        return vacanciesService.findAllProfession();
    }

    @CrossOrigin
    @GetMapping("/getPoint")
    public List<Directions> getDirections() {
        return directionsService.getAllDirections();
    }

    @CrossOrigin
    @GetMapping(value = "/getPoint", params = {"profession"})
    public List<Directions> getDirections(@RequestParam(value = "profession") String profession) {
        return directionsService.getWithProfession(profession);
    }
}
