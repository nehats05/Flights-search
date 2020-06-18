package com.flightSearch.app.service;

import com.flightSearch.app.FlightsBean;
import com.flightSearch.app.dao.FlightsDao;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightServiceImpl implements FlightsService {

    @Autowired
    private FlightsDao flightsDao;

    @Override
    @Transactional(readOnly = true)
    public FlightsBean getFlight(String depTime) {
        return flightsDao.getFlight(depTime);
    }
}
