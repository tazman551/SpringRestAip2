package com.elderwood.restapi.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import com.elderwood.restapi.util.Builder;
import com.elderwood.restapi.util.ReservationBuilder;

import io.micrometer.common.lang.NonNull;
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
    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    private user user;
    private Timestamp created;
    @Column(name = "res_date",nullable = false)
    private Date resDate;
    private Time timeslot;
    private boolean reserved;

    public reservations() {
        // Default constructor
    }
    
    public reservations(Builder builder) {
        if (builder instanceof ReservationBuilder) {
            ReservationBuilder reservationBuilder = (ReservationBuilder) builder;
            this.table = reservationBuilder.getTable();
            this.user = reservationBuilder.getUser();
            this.resDate = reservationBuilder.getResDate();
            this.timeslot = reservationBuilder.getTimeslot();
            this.reserved = reservationBuilder.isReserved();
            this.created = new Timestamp(System.currentTimeMillis());
        } else {
            throw new IllegalArgumentException("Invalid builder type");
        }
    }

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
    
    public static ReservationBuilder builder() {
        return new ReservationBuilder();
    }

    
}
