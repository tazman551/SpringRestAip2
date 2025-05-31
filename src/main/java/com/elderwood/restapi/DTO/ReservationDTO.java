package com.elderwood.restapi.DTO;

import com.elderwood.restapi.model.reservations;
import com.elderwood.restapi.repository.TableRepository;

public class ReservationDTO {

    private TableRepository tableRepository;
    private String firstname;
    private String lastname;
    private String table_name;
    private String dateString;
    private String timeString;

    public ReservationDTO(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }
     

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public reservations toReservations() {
        reservations res = new reservations();
        res.setTable(tableRepository.findByName(table_name));
        res.setReserved(true);
        res.setDate(java.sql.Date.valueOf(dateString));
        res.setTimeslot(java.sql.Time.valueOf(timeString));
        return res;
    }

}
