package com.elderwood.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elderwood.restapi.DTO.locationDTO;
import com.elderwood.restapi.model.location;
import com.elderwood.restapi.service.locationService;

@RestController
public class LocationController {

    private locationService locationService;
    LocationController(locationService locationService){
        this.locationService = locationService;
    }

    @GetMapping("/api/locations")
    public List<locationDTO> getAllLocations() {
        List<location> list = locationService.getAllLocations();
        List<locationDTO> locationDTOs = new ArrayList<locationDTO>();;
        list.forEach( loc ->
            locationDTOs.add(new locationDTO(loc.getLoc_name(), loc.getAddress()))
        );

        return locationDTOs;
    }
}
