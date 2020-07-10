package com.flightSearch.app.dao;

import com.flightSearch.app.FlightsBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public interface FlightRepository extends CrudRepository<FlightsBean,Long> {

    @Query(value = "select flightname,cast(flightdep as datetime) as flightdep from flightsdata where flightdep between :flightDeparturebefore and :flightDepartureafter",nativeQuery = true)
    FlightsBean[] getFlight(@Param(value = "flightDeparturebefore") LocalTime flightDeparturebefore,
                          @Param(value = "flightDepartureafter") LocalTime flightDepartureafter);
}
