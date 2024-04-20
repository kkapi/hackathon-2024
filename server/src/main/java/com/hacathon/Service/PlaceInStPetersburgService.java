package com.hacathon.Service;

import com.hacathon.Repos.PlaceInStPetersburgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceInStPetersburgService {
    @Autowired
    PlaceInStPetersburgRepo placeRepo;

}
