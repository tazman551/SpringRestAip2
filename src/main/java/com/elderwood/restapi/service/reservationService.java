package com.elderwood.restapi.service;

import java.io.DataInput;
import java.sql.Date;
import java.sql.Time;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elderwood.restapi.model.reservations;
import com.elderwood.restapi.model.tables;
import com.elderwood.restapi.repository.ReservationsRepository;
import com.elderwood.restapi.repository.TableRepository;
import com.elderwood.restapi.DTO.ReservationJsonDTO;

@Service
public class reservationService {
    
    private ReservationsRepository resRepository;
    private TableRepository tablesRepository;

    public reservationService(ReservationsRepository resRepository, TableRepository tablesRepository) {
        this.tablesRepository = tablesRepository;
        this.resRepository = resRepository;
    }

    @Transactional
    public void createReservation(ReservationJsonDTO data) {
        // Cast reservationData to the correct type, e.g., ReservationDTO
        // Replace 'ReservationDTO' with the actual class name if different
        Logger logger = Logger.getLogger(reservationService.class.getName());
        logger.info("Creating reservation with data: " + data);

        // 1. Fetch the referenced table entity
        tables table = tablesRepository.findById(data.getTable_id())
        .orElseThrow(() -> new RuntimeException("Table not found"));

        reservations reservation = (reservations) reservations.builder()
                .setTable(table)
                .setUser(null)
                .setResDate(Date.valueOf(data.getDate()))
                .setTimeslot(Time.valueOf(data.getTime()))
                .setReserved(true)
                .build();
        
        resRepository.save(reservation);
    }
}
