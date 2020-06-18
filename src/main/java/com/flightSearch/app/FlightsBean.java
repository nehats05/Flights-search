package com.flightSearch.app;

import javax.persistence.*;

@Entity
@Table(name = "flightsdata")
public class FlightsBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flightname")
    private String flightName;

    @Column(name = "flightdep")
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
