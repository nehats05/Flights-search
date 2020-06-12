package com.flightSearch.dao;

import com.flightSearch.FlightsBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.Optional;

public class FlightsDaoImplementation implements FlightsDao {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public FlightsBean getFlight(String depTime) {
       return flightRepository.findByDep(depTime);
    }
}
