package com.flightSearch.app.dao;

import com.flightSearch.app.FlightsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightsDaoImplementation implements FlightsDao {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public FlightsBean getFlight(String depTime) {
       return flightRepository.getFlight(depTime);
    }
}
