package com.globant.bootcamp.airlines.controllers;


import com.globant.bootcamp.airlines.domain.Airline;
import com.globant.bootcamp.airlines.domain.Flight;
import com.globant.bootcamp.airlines.domain.FlightPerson;
import com.globant.bootcamp.airlines.exception.ResourceNotFoundException;
import com.globant.bootcamp.airlines.repositories.AirlineRepository;
import com.globant.bootcamp.airlines.repositories.FlightPersonRepository;
import com.globant.bootcamp.airlines.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/airlines/")
public class ControllerAirLine {

    @Autowired
    private AirlineRepository airlineRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightPersonRepository flightPersonRepository;

    @GetMapping
    public List<Airline> getAirlines(){
        return airlineRepository.findAll();
    }

    @GetMapping("{id}")
    public Airline getAirlineById(@PathVariable(value = "id") Long id){
        return airlineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AirLine", "id", id));
    }

    @GetMapping("flight/{date}")
    public List<Flight> getFlightByDate(@PathVariable(value = "date") @DateTimeFormat(pattern="yyyy-MM-dd") String departure) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return flightRepository.findByDeparture(sdf.parse(departure));

    }

    @GetMapping("{id}/flights")
    public List<Flight> getFlightsByAirline(@PathVariable(value = "id") Long id){
        return flightRepository.findByAirline_id(id);
    }
    @GetMapping("flights")
    public List<Flight> getFlights(){return flightRepository.findAll();}

    @GetMapping("{id}/flights/{idFlight}")
    public List<Flight> getFlightById(@PathVariable(value = "id") Long id, @PathVariable(value="idFlight") Long idFlight){
        return flightRepository.findByAirline_idAndId(idFlight,id);
    }

    @GetMapping("flights/{idFlight}/people")
    public List<FlightPerson> getPeopleInFlightByAirline(@PathVariable(value="idFlight") Long idFlight){
        return flightPersonRepository.findByFlight_id(idFlight);
    }

    @PostMapping("flights/add")
    public FlightPerson addClientFlight(@RequestBody FlightPerson flightPerson){
        return flightPersonRepository.save(flightPerson);
    }

    @PostMapping
    public ResponseEntity addAirline(@RequestBody Airline a){
        Airline airlineValidate = airlineRepository.findByName(a.getName());
        if(airlineValidate == null){
            airlineRepository.save(a);
            return ResponseEntity.status(HttpStatus.CREATED).body(a);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(a);

    }
    @PostMapping("{id}/flight")
    public ResponseEntity addFlightToAirline(@PathVariable(value = "id") Long id,@RequestBody Flight flight){
         Airline airline = airlineRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("AirLine", "id", id));
         if(airline == null)
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("AirLine", "id", id));
         else {
             flight.setAirline(airline);
             flightRepository.save(flight);
             return ResponseEntity.status(HttpStatus.CREATED).body(flight);
         }
    }

    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity deleteAirline(@PathVariable(value = "id") Long id){
        flightRepository.deleteByAirline_id(id);
        airlineRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

    @Transactional
    @PutMapping("{id}")
    public Airline updateAirline(@PathVariable(value = "id") Long id,
                                        @Valid @RequestBody Airline airlineDetails){
        Airline airlineToUpdate = airlineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AirLine", "id", id));
        airlineToUpdate.setName(airlineDetails.getName());

        Airline updatedAirline = airlineRepository.save(airlineToUpdate);
        return updatedAirline;

    }
}
