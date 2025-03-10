package com.elderwood.restapi.model;


import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private location location;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<tags> tags;
    @ManyToOne(optional=true,fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private status status;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public location getLocation() {
        return location;
    }
    public void setLocation(location location) {
        this.location = location;
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

}
