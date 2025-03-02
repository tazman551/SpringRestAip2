package com.elderwood.restapi.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elderwood.restapi.DTO.scheduleDTO;
import com.elderwood.restapi.model.daysofweek;
import com.elderwood.restapi.model.reservations;
import com.elderwood.restapi.model.tables;
import com.elderwood.restapi.repository.ReservationsRepository;
import com.elderwood.restapi.repository.TableRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class tableService {
    

    private static final Logger logger = LoggerFactory.getLogger(tableService.class);
    
    private TableRepository tableRepository;
    private ReservationsRepository resRepository;

    public tableService(TableRepository tableRepo, ReservationsRepository resRepo){
        this.tableRepository = tableRepo;
        this.resRepository = resRepo;

    }

    public List<tables> getTables() {
        return tableRepository.getTables();
    }

    @SuppressWarnings("unused")
    public Set<Object> getResforTable(String tableID, String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sqlDate = new Date(dateFormat.parse(date).getTime());
        if(sqlDate == null){
            throw new NullPointerException("Date can't be null");
        }
        return resRepository.findBytableIdAndResDate(tableID, sqlDate);
    }

    public reservations postTableReservation(String entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postTableReservation'");
    }



    public Set<tables> getTableByLocationName(String locationName) throws ParseException {
      
        return tableRepository.findByLocName(locationName);
    }


    public tables getTableByID(int tableID, String date) throws NullPointerException{
        System.out.println(date);
        tables t = tableRepository.findById(tableID);

        Iterator<daysofweek> dow = t.getDow().iterator();
        while (dow.hasNext()) {
            daysofweek ele = dow.next();
            if(!ele.equals(date)) {
                dow.remove();
            }
        }

        System.out.println(t.getDow().toString());

        return t;
    }



   
}
