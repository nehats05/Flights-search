package com.flightSearch;

import javax.persistence.*;

@Entity
@Table(name = "FLIGHTSDATA")
public class FlightsBean {

    @Column(name = "flightName")
    private String flightName;
    @Id
    @Column(name = "flightDep")
    private String flightDeparture;

    public FlightsBean()
    {

    }

    public FlightsBean(String flightName, String flightDeparture) {
        this.flightName = flightName;
        this.flightDeparture = flightDeparture;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightDeparture() {
        return flightDeparture;
    }

    public void setFlightDeparture(String flightDeparture) {
        this.flightDeparture = flightDeparture;
    }

}
