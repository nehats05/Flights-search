package com.flightSearch.service;

import com.flightSearch.FlightsBean;
import com.flightSearch.dao.FlightsDao;
import java.time.LocalTime;

public class FlightServiceImpl implements FlightsService {

    private FlightsDao flightsDao;

    @Override
    public FlightsBean getFlight(String depTime) {
        return flightsDao.getFlight(depTime);
    }
}
