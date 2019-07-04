package com.globant.bootcamp.airlines.repositories;

import com.globant.bootcamp.airlines.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline,Long> {

    List<Airline> findAll();

    Airline findByName(String name);

    void deleteById(Long id);
}
