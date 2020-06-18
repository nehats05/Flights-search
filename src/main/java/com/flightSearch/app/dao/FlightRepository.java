package com.flightSearch.app.dao;

import com.flightSearch.app.FlightsBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<FlightsBean,Long> {

    @Query(value = "select * from flightsdata where flightdep = :flightDeparture",nativeQuery = true)
    FlightsBean getFlight(@Param(value = "flightDeparture") String flightDeparture);
}
