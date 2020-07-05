package com.flightSearch.app;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "flightsdata")
public class FlightsBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flightname")
    private String flightName;

    @Column(name = "flightdep")
    private LocalTime flightDeparture;

    public FlightsBean()
    { }

    public FlightsBean(String flightName, LocalTime flightDeparture) {
        this.flightName = flightName;
        this.flightDeparture = flightDeparture;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public LocalTime getFlightDeparture() {
        return flightDeparture;
    }

    public void setFlightDeparture(LocalTime flightDeparture) {
        this.flightDeparture = flightDeparture;
    }

    @Override
    public String toString() {
        return "FlightsDetails" +
                "flightName='" + flightName + '\'' +
                ", flightDeparture='" + flightDeparture + '\'';
    }
}
