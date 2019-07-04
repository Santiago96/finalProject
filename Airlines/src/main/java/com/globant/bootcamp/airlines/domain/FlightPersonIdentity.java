package com.globant.bootcamp.airlines.domain;


import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class FlightPersonIdentity implements Serializable {
    @NotNull
    private Long flight_id;
    @NotNull
    private String person_id;
    @NotNull
    private String assignedSeat;

    public FlightPersonIdentity() {
    }

    public FlightPersonIdentity(Long flight_id,String person_id, String assignedSeat) {
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
