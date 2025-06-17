package com.elderwood.restapi.DTO;

import java.util.Set;
import java.util.stream.Collectors;

import com.elderwood.restapi.model.location;

public class TimeslotDTO {
    private String time;
    private boolean disabled;


    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public boolean isDisabled() {
        return disabled;
    }
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
    public Set<TimeslotDTO> getTimeslotsForTable(location l, Set<ReservationDTO> reservations) {
        Set<TimeslotDTO> timeslotDTOs = l.getDow().stream()
    .map(loc_Sched_slot -> {
        boolean reserved = reservations.stream()
            .anyMatch(res -> res.getTimeString().equals(loc_Sched_slot.getTime()));
        TimeslotDTO timeDTO = new TimeslotDTO();
        timeDTO.setTime(loc_Sched_slot.getTime().toString());
        timeDTO.setDisabled(reserved);
        return timeDTO;
    })
    .collect(Collectors.toSet());
        return timeslotDTOs;
    }
}
