package com.flightSearch.app.controller;

import com.flightSearch.app.FlightsBean;
import com.flightSearch.app.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlightsController {

    @Autowired
    private FlightsService flightsService;

    //based on the departure time fetch the flight details
    @RequestMapping(value = "/getFlights",method = RequestMethod.GET)
    public FlightsBean getFlights(@RequestParam("duration") String duration){
        FlightsBean fli = flightsService.getFlight(duration);
           if(fli!=null)
               return fli;
           else
               return null;
    }

}
