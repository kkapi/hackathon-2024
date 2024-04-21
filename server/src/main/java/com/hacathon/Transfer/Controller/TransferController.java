package com.hacathon.Transfer.Controller;

import com.hacathon.Admission.Domain.Directions;
import com.hacathon.Transfer.Service.SubjectService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


/**
 * Данный класс содержит контроллеры необходимые для работы страницы по переводу стундента с направления на направление
 */
@RestController
public class TransferController {
    @Autowired
    private SubjectService service;

    @GetMapping(value = "/transfer")
    public List<Directions> getTransfer(@RequestParam String profession, @RequestParam String plan) throws CsvValidationException, IOException {
        return service.findDirections(profession, plan);
    }

    @GetMapping("/getPlans")
    public List<String> getPlans() throws CsvValidationException, IOException {
        return service.getPlans();
    }
}
