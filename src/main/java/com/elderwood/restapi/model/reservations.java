package com.elderwood.restapi.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class reservations {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "table_id",referencedColumnName = "id")
    private tables table;
    @ManyToOne
    private user user;
    private Timestamp created;
    @Column(name = "res_date",nullable = false)
    private Date resDate;
    private Time timeslot;
    private boolean reserved;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public tables getTable() {
        return table;
    }
    public void setTable(tables table) {
        this.table = table;
    }
    public user getUser() {
        return user;
    }
    public void setUser(user user) {
        this.user = user;
    }
    public Timestamp getCreated() {
        return created;
    }
    public void setCreated(Timestamp created) {
        this.created = created;
    }
    public Date getDate() {
        return resDate;
    }
    public void setDate(Date date) {
        resDate = date;
    }
    public Time getTimeslot() {
        return timeslot;
    }
    public void setTimeslot(Time timeslot) {
        this.timeslot = timeslot;
    }
    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
    
    

    
}
