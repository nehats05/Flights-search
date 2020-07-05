package com.flightSearch.app.dao;

import com.flightSearch.app.FlightsBean;

public interface FlightsDao {
    FlightsBean[] getFlight(String depTime);
}
