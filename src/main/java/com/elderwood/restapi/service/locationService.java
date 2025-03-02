package com.elderwood.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elderwood.restapi.model.location;
import com.elderwood.restapi.repository.LocationRepository;

@Service
public class locationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<location> getAllLocations() {
     return locationRepository.findAll();
    }


    
}
