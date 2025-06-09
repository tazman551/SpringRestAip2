package com.elderwood.restapi.util;

import java.sql.Date;
import java.sql.Time;

import com.elderwood.restapi.model.reservations;
import com.elderwood.restapi.model.tables;
import com.elderwood.restapi.model.user;



public class ReservationBuilder implements Builder {

  
    private tables table;
    private user user;
    private Date resDate;
    private Time timeslot;
    private boolean reserved;


    public tables getTable() {
        return table;
    }

    public user getUser() {
        return user;
    }

    public Date getResDate() {
        return resDate;
    }

    public Time getTimeslot() {
        return timeslot;
    }

    public boolean isReserved() {
        return reserved;
    }

    public ReservationBuilder setTable(tables table) {
        this.table = table;
        return this;
    }

    public ReservationBuilder setUser(user user) {
        this.user = user;
        return this;
    }

    public ReservationBuilder setResDate(Date resDate) {
        this.resDate = resDate;
        return this;
    }

    public ReservationBuilder setTimeslot(Time timeslot) {
        this.timeslot = timeslot;
        return this;
    }

    public ReservationBuilder setReserved(boolean reserved) {
        this.reserved = reserved;
        return this;
    }

    @Override
    public reservations build() {
        return new reservations(this);
    }
    
}
