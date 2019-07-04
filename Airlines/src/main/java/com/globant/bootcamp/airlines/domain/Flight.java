package com.globant.bootcamp.airlines.domain;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "FLIGHT")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origin;
    private String destiny;

    @ManyToOne
    @JoinColumn
    private Airline airline;
    private Timestamp departure;
    private String seats;

    public Flight(){}

    public Flight(String origin,String destiny,Timestamp departure, Airline airline,String seats){
        this.origin = origin;
        this.destiny = destiny;
        this.departure = departure;
        this.airline = airline;
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }
    public Timestamp getDeparture() {
        return departure;
    }

    public void setDeparture(Timestamp departure) {
        this.departure = departure;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
}
