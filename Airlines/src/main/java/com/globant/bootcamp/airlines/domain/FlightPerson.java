package com.globant.bootcamp.airlines.domain;

import javax.persistence.*;

@Entity
@Table(name = "FLIGHT_PERSON")
public class FlightPerson {

    @EmbeddedId
    private FlightPersonIdentity flightPersonIdentity;
    /*@ManyToOne
    @JoinColumn(name="flightId",referencedColumnName="id",insertable = false, updatable=false)
    private Flight flight;
    @ManyToOne
    @JoinColumn(name="personId",referencedColumnName="numDocument",insertable = false, updatable=false)
    private Person person;*/
    private String comment;

    public FlightPerson() {
    }

    /*public FlightPerson(FlightPersonIdentity flightPersonIdentity, Flight flight, Person person, String comment) {
        this.flightPersonIdentity = flightPersonIdentity;
        this.flight = flight;
        this.person = person;
        this.comment = comment;
    }*/
    public FlightPerson(FlightPersonIdentity flightPersonIdentity, String comment) {
        this.flightPersonIdentity = flightPersonIdentity;
        this.comment = comment;
    }


    public FlightPersonIdentity getFlightPersonIdentity() {
        return flightPersonIdentity;
    }

    public void setFlightPersonIdentity(FlightPersonIdentity flightPersonIdentity) {
        this.flightPersonIdentity = flightPersonIdentity;
    }
/*
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }*/

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
