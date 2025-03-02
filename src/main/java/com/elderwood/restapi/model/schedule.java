package com.elderwood.restapi.model;

import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

//@Entity
public class schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private Set<tables> table;
    @ManyToMany
    private Set<daysofweek> dow;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Set<daysofweek> getDow() {
        return dow;
    }
    public void setDow(Set<daysofweek> dow) {
        this.dow = dow;
    }
    public Set<tables> getTable() {
        return table;
    }
    public void setTable(Set<tables> table) {
        this.table = table;
    }
   

    

}
