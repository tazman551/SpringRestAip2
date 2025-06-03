package com.elderwood.restapi.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elderwood.restapi.service.reservationService;

@RestController
@RequestMapping("/api")
public class ReservationController {
    
    private final reservationService reservationService;
    
    public ReservationController(reservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public String getReservations() {
        // This method would typically return a list of reservations
        return "List of reservations";
    }

    @GetMapping("/reservations/{id}")
    public String getReservationById() {
        // This method would typically return a specific reservation by ID
        return "Reservation details for ID";
    }

       /*
     * Post Methods
     */

    /* post a reservation */
    @PostMapping("/reservation")
    public ResponseEntity<?> postReservation(@RequestBody Map<String, Object> entity) {
        //reservationService.postTableReservation(entity);
        return ResponseEntity.status(200).body(entity);

    }
}
