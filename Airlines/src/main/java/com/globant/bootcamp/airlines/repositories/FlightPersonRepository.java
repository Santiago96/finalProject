package com.globant.bootcamp.airlines.repositories;

import com.globant.bootcamp.airlines.domain.FlightPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightPersonRepository extends JpaRepository<FlightPerson,Long> {
    @Query(value = "SELECT * FROM FLIGHT_PERSON f WHERE f.FLIGHT_ID = ?1",
            nativeQuery = true)
    List<FlightPerson> findByFlight_id(Long flight_id);
}
