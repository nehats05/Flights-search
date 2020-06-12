package com.flightSearch.dao;

import com.flightSearch.FlightsBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository {

    @Query(value = "SELECT * FROM FLIGHTSDATA f WHERE f.flightDep = :flightDeparture",nativeQuery = true)
    FlightsBean findByDep(@Param(value = "flightDeparture") String flightDeparture);
}
