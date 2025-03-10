package com.elderwood.restapi.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.elderwood.restapi.model.tables;

@Repository
public interface TableRepository extends JpaRepository<tables, Long> {
    
    
    // Using native SQL
    @Query(value = "SELECT * FROM tables", nativeQuery = true)
    List<tables> getTables();

    //
    @Query(value="select t from tables t JOIN FETCH t.location l where l.loc_name = ?1")
    Set<tables> findByLocName(String locationName);

    //
    @Query(value = "select t from tables t JOIN FETCH t.location l JOIN FETCH l.dow where t.id = ?1")
    tables findByIdWithLocAndSched(int tableID);

}

