package com.elderwood.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.elderwood.restapi.model.location;

@Repository
public interface LocationRepository extends JpaRepository<location, Long> {
    
    // Using native SQL
    @Query(value = "SELECT * FROM locations", nativeQuery = true)
    List<location> getAllLocations();
}