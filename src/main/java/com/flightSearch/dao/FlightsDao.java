package com.flightSearch.dao;

import com.flightSearch.FlightsBean;

public interface FlightsDao {
    FlightsBean getFlight(String depTime);
}
