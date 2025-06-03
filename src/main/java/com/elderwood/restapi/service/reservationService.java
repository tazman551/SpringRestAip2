package com.elderwood.restapi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elderwood.restapi.model.reservations;
import com.elderwood.restapi.repository.ReservationsRepository;

@Service
public class reservationService {
    
    private ReservationsRepository resRepository;

    public reservationService(ReservationsRepository resRepository) {
        this.resRepository = resRepository;
    }

    @Transactional
    public void addReservation() {
        reservations reservation = new reservations();
        
        resRepository.save(reservation);
    }
}
