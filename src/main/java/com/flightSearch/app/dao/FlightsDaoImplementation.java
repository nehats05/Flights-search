package com.flightSearch.app.dao;

import com.flightSearch.app.FlightsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class FlightsDaoImplementation implements FlightsDao {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public FlightsBean[] getFlight(String depTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime localTime = LocalTime.parse(depTime, dateTimeFormatter);
        LocalTime localPlus = localTime.plusHours(5);
        LocalTime localMinus = localTime.minusHours(5);
        System.out.println("Duration " + localMinus + "," + localPlus);
        System.out.println(localTime);
        FlightsBean[] fli= flightRepository.getFlight(localMinus,localPlus);
        return fli;
    }
}
