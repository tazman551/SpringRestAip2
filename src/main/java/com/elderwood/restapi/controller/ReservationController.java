package com.elderwood.restapi.controller;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elderwood.restapi.DTO.ReservationDTO;
import com.elderwood.restapi.DTO.ReservationJsonDTO;
import com.elderwood.restapi.service.reservationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class ReservationController {
    
    Logger logger = Logger.getLogger(ReservationController.class.getName());
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
    public ResponseEntity<?> postReservation(@RequestBody String jsonData) {
        logger.info("Received reservation request: " + jsonData);
        ObjectMapper mapper = new ObjectMapper();
        ReservationJsonDTO data = null;
        try {
            data = mapper.readValue(jsonData, ReservationJsonDTO.class);
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        reservationService.createReservation(data);
        return ResponseEntity.status(200).body(jsonData);
    }
}
