package com.globant.bootcamp.client.domain;



import java.io.Serializable;


public class FlightPersonIdentity implements Serializable {

    private Long flight_id;

    private String person_id;

    private String assignedSeat;

    public FlightPersonIdentity() {
    }

    public FlightPersonIdentity(Long flight_id, String person_id, String assignedSeat) {
        this.flight_id = flight_id;
        this.person_id = person_id;
        this.assignedSeat = assignedSeat;
    }

    public Long getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Long flight_id) {
        this.flight_id = flight_id;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getAssignedSeat() {
        return assignedSeat;
    }

    public void setAssignedSeat(String assignedSeat) {
        this.assignedSeat = assignedSeat;
    }
}
