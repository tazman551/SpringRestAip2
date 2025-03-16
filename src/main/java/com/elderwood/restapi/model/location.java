package com.elderwood.restapi.model;

import java.util.HashSet;
import java.util.Iterator;

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
public class location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loc_name;
    private String address;
    @ManyToMany()
    @JoinTable(name = "schedule_day", joinColumns = { @JoinColumn(name = "location_id") }, inverseJoinColumns = {
            @JoinColumn(name = "dow_id") })
    private Set<daysofweek> dow;

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
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

    /*
     * returns a subset of Dows of the week based on the weekday (Monday, ... ,
     * Friday)
     */
    public Set<daysofweek> getDowFilteredByWeekday(String weekday) {
        Set<daysofweek> filteredDow = new HashSet<>();

        Iterator<daysofweek> it = this.dow.iterator();
        while (it.hasNext()) {
            daysofweek curr = it.next();
            if (curr.getDayString().equals(weekday))
                filteredDow.add(curr);
        }

        return filteredDow;
    }

}