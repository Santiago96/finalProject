package com.globant.bootcamp.airlines.repositories;

import com.globant.bootcamp.airlines.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query(value = "SELECT * FROM FLIGHT WHERE :departure = cast(departure as DATE)", nativeQuery = true)
    List<Flight> findByDeparture(@Param("departure") Date departure);

    List<Flight> findByAirline_idAndId(Long airline_id,Long id);

    List<Flight> findByAirline_id(Long airline_id);

    void deleteByAirline_id(Long airline_id);

}
