package com.hacathon.Transfer.Controller;

import com.hacathon.Admission.Domain.Directions;
import com.hacathon.Transfer.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransferController {
    @Autowired
    private SubjectService service;

    @GetMapping(value = "/transfer")
    public List<Directions> getTransfer(@RequestParam String profession, @RequestParam String plan) {
        return service.findDirections(profession, plan);
    }
}
