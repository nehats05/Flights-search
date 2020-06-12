package com.flightSearch.controller;

import com.flightSearch.FlightsBean;
import com.flightSearch.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlightsController {

    @Autowired
    private FlightsService flightsService;

   /* private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
    private static Map<String,String> ProRepo = new HashMap<>();*/
    /*static {
        FlightsBean flight1 = new FlightsBean();
        flight1.setFlightName("Air Canada 8099");
        flight1.setFlightDeparture(LocalTime.of(07,30).format(dateTimeFormatter));
        ProRepo.put(flight1.getFlightName(),flight1.getFlightDeparture());
        System.out.println("data is : "+ flight1.getFlightName());
        System.out.println(flight1.getFlightDeparture());

        FlightsBean flight2 = new FlightsBean();
        flight2.setFlightName("United Airline 6115");
        flight2.setFlightDeparture(LocalTime.of(10,30).format(dateTimeFormatter));
        ProRepo.put(flight2.getFlightName(),flight2.getFlightDeparture());
        System.out.println("data is : "+ flight2.getFlightName());
        System.out.println(flight2.getFlightDeparture());

        FlightsBean flight3 = new FlightsBean();
        flight3.setFlightName("West Jet 6456");
        flight3.setFlightDeparture(LocalTime.of(12,30).format(dateTimeFormatter));
        ProRepo.put(flight3.getFlightName(),flight3.getFlightDeparture());
        System.out.println("data is : "+ flight3.getFlightName());
        System.out.println(flight3.getFlightDeparture());

        FlightsBean flight4 = new FlightsBean();
        flight4.setFlightName("Delta 3833");
        flight4.setFlightDeparture(LocalTime.of(15,00).format(dateTimeFormatter));
        ProRepo.put(flight4.getFlightName(),flight4.getFlightDeparture());
        System.out.println("data is : "+ flight4.getFlightName());
        System.out.println(flight4.getFlightDeparture());
    }*/

    @RequestMapping(method = RequestMethod.GET,value = "/getFlights/{duration}")
    public FlightsBean getFlights(@PathVariable String duration){
       return flightsService.getFlight(duration);
    }

    /*@RequestMapping(method = RequestMethod.GET,value = "/getFlights")
    public static String getFlights(){
        String res = ProRepo.keySet().toString();
        return res.concat(ProRepo.values().toString());
    }*/
}
