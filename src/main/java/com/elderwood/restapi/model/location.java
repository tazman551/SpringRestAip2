package com.elderwood.restapi.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class location{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String loc_name;
    private String address;
    @ManyToMany()
    @JoinTable(
        name = "schedule_day", 
        joinColumns = { @JoinColumn(name = "location_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "dow_id") }
    )
    private Set<daysofweek> dow;

    public Long getID() {
        return ID;
    }
    public void setID(Long iD) {
        ID = iD;
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
    public Set<daysofweek> getDow() {
        return dow;
    }
    public void setDow(Set<daysofweek> dow) {
        this.dow = dow;
    }
    
   
}