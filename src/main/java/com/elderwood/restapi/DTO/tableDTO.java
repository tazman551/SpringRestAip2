package com.elderwood.restapi.DTO;

import java.util.Set;

import com.elderwood.restapi.model.daysofweek;

public class tableDTO{

    private Long id;
    private String name;
    private String loc_name;
    private String address;

    

    public tableDTO(Long id, String name, String loc_name, String address) {
        this.id = id;
        this.name = name;
        this.loc_name = loc_name;
        this.address = address;
        Set<daysofweek> dow;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getLoc_name() {
        return loc_name;
    }



    public void setLoc_name(String loc_name) {
        this.loc_name = loc_name;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
    }
    
    

}