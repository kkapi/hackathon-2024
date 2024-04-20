package com.hacathon.Admission.Service;

import com.hacathon.Admission.Repos.DirectionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectionsService {
    @Autowired
    DirectionsRepo directionsRepo;
}
