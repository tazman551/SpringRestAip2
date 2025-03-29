package com.elderwood.restapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.elderwood.restapi.DTO.scheduleDTO;
import com.elderwood.restapi.model.tables;
import com.elderwood.restapi.service.tableService;

import java.text.ParseException;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
//@RequestMapping("/api")
public class TableController {


    @Autowired
    tableService tService;

    /* Returns all tables */
    @GetMapping("/api/tables")
    public List<tables> getAllTables() {
        return tService.getTables();
    }

    /* Reutrns a table  */
    @GetMapping("/api/table/{TableID}")
    public ResponseEntity<?> getTableByIdAndDate(@PathVariable int TableID, @RequestParam String date) {

        // ResponseEntity
        try {
            return ResponseEntity.status(HttpStatus.OK).body(tService.getTableByID(TableID, date.toLowerCase()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body(e);
        }
    }

    @GetMapping("/api/tables/{locationName}")
    public Set<tables> getMethodName(@PathVariable String locationName, @RequestParam String date) throws ParseException {
        return tService.getTableByLocationName(locationName);
    }

    /* Gets all  */
    @GetMapping("/api/TableReservations/{TableID}")
    public scheduleDTO getTableReservations(@PathVariable int TableID, @RequestParam String day) throws NullPointerException, ParseException {
        return tService.getTableAndRes(TableID, day);
    }
    

    /*
     * Post Methods
     */

    /* post a reservation */
    @PostMapping("/api/reservation")
    public ResponseEntity<?> postMethodName(@RequestBody String entity) {
        tService.postTableReservation(entity);
        return ResponseEntity.status(200).body(null);
        
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }
    
}