package com.elderwood.restapi.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.elderwood.restapi.DTO.scheduleDTO;
import com.elderwood.restapi.DTO.ReservationDTO;
import com.elderwood.restapi.configuration.CorsConfig;
import com.elderwood.restapi.model.location;

import com.elderwood.restapi.model.tables;
import com.elderwood.restapi.repository.LocationRepository;
import com.elderwood.restapi.repository.ReservationsRepository;
import com.elderwood.restapi.repository.TableRepository;

@Service
public class tableService {

    @SuppressWarnings("unused")
    private final CorsConfig corsConfig;
    

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(tableService.class);
    
    private TableRepository tableRepository;
    private ReservationsRepository resRepository;
    private LocationRepository locationRepository;

    public tableService(TableRepository tableRepo, ReservationsRepository resRepo, LocationRepository locationRepository, CorsConfig corsConfig){
        this.tableRepository = tableRepo;
        this.resRepository = resRepo;
        this.locationRepository = locationRepository;
        this.corsConfig = corsConfig;
    }

    /*
     * returns all tables
     */
    public List<tables> getTables() {
        return tableRepository.getTables();
    }
    
    /*
     * returns a table by ID
     */
    public tables getTableByID(int tableID) throws NullPointerException{
        return tableRepository.findByIdWithLocation(tableID);
    }



    // all locations
    public Set<tables> getTableByLocationName(String locationName) throws ParseException {
      
        return tableRepository.findByLocName(locationName);
    }

   
    /**
     * Get a table and its location with reservations for a specific date
     * 
     * @param tableID the ID of the table
     * @param date    the date in "yyyy-MM-dd" format
     * @return scheduleDTO containing table, location, and reservations
     * @throws NullPointerException if the date is null or if the table/location is not found
     * @throws ParseException       if the date format is incorrect
     */
    public scheduleDTO getTableAndRes(int tableID, String date) throws NullPointerException, ParseException{
        /* Fromat the date from URL into a useable Date */
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date UtilDate = new Date(dateFormat.parse(date).getTime());

        /* Fromat date string from URL into a Weekday (Monday,..., Friday) */
        String weekday = LocalDate.parse(date)
             .getDayOfWeek()
             .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        if( weekday == null){
            throw new NullPointerException("Date can't be null");
        }
        /* return related table information from Table ID and the date 
         * 
         * Return table from ID
         * Return A tables location with its full schedule
         * Return List<Reservations> for a table and date specificed
        */
        tables t = tableRepository.findByIdWithLocation(tableID);
        location l = locationRepository.findByID(t.getLocation().getID());
        Set<ReservationDTO> reservations = resRepository.findAllByTableIdAndResDate(tableID, UtilDate).stream()
            .map(reservation -> new ReservationDTO(reservation))
            .collect(java.util.stream.Collectors.toSet());


        if(t == null || l == null){
            throw new NullPointerException("Table and loaction cant be null, sql statement not working");
        }

        /* creates a scheduleDto to: 
         * return a table with its locations scheduled hours and a set of reservations for a specificed date.
         */
        scheduleDTO schedule = createScheduleDTO(t, l, reservations, weekday);

        return schedule;
    }



    /* Create a Schedule DTO to return related reservation data*/
    private scheduleDTO createScheduleDTO(tables table, location location ,Set<ReservationDTO> res, String weekday){
        scheduleDTO sched = new scheduleDTO(table, location, res);
        // Filter the location's schedule by the specified weekday
        // This assumes that the location's schedule has a method to filter by weekday
        // If the location's schedule does not have a method to filter by weekday,
        location filteredLocation = sched.getLocation();
        sched.getLocation().setDow(filteredLocation.getDowFilteredByWeekday(weekday));
        // Create timeslots based on the filtered schedule
        // This assumes that the location has a method to create timeslots based on its schedule
        sched.createTimeslots();
        return sched;
    }
}
