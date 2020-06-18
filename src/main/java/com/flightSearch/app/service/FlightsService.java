package com.flightSearch.app.service;

import com.flightSearch.app.FlightsBean;

public interface FlightsService {
    FlightsBean getFlight(String depTime);
}
