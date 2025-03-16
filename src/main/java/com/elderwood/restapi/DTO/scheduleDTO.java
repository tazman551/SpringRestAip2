package com.elderwood.restapi.DTO;

import java.util.Set;

import com.elderwood.restapi.model.*;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class scheduleDTO {

    
    private Long id;
    private String name;
    private Set<tags> tags;
    private status status;
    location location;
    Set<reservations> res;
    
    public scheduleDTO(tables t, location l, Set<reservations> res) {
        this.id = t.getId();
        this.name = t.getName();
        this.tags = t.getTags();
        this.status = t.getStatus();
        this.location = l;
        this.res = res;
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

    public Set<tags> getTags() {
        return tags;
    }

    public void setTags(Set<tags> tags) {
        this.tags = tags;
    }

    public status getStatus() {
        return status;
    }

    public void setStatus(status status) {
        this.status = status;
    }

    public Set<reservations> getRes() {
        return res;
    }

    public void setRes(Set<reservations> res) {
        this.res = res;
    }

    public location getLocation() {
        return location;
    }

    public void setLocation(location location) {
        this.location = location;
    }

    
}
