package com.elderwood.restapi.repository;


import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elderwood.restapi.model.reservations;

@Repository
public interface ReservationsRepository extends JpaRepository<reservations, Long>{

    @Query(value = "Select r.resDate, r.reserved, r.timeslot from reservations r join r.table t where t.id = ?1 and r.resDate = ?2")
    Set<Object> findByTableIdAndDate(long id, Date date);

    @Query(value = "Select r.resDate, r.reserved, r.timeslot from reservations r join r.table t where t.id = ?1 and r.resDate = ?2")
    Set<Object> findBytableIdAndResDate(String tableID, Date date);
    
    
}
