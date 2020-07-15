package com.flightSearch.app.dao;

import com.flightSearch.app.FlightsBean;
import com.mysql.jdbc.util.TimezoneDump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.function.Consumer;

@Component
public class FlightsDaoImplementation implements FlightsDao {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public FlightsBean[] getFlight(String depTime) {
        int numberofhours = 5;
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

        //parse the entered departure time to LocalDateTime
        LocalTime localTime = LocalTime.parse(depTime, dateTimeFormatter);
        LocalDateTime localDateTime = date.atTime(localTime);
        System.out.println("localDateTime"+localDateTime);
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String localDateTime1 =localDateTime.format(dateTimeFormatter1);
        System.out.println("localDateTime formatted "+localDateTime1);

        //Plus 5 hrs from entered time
        LocalTime localPlus = localTime.plusHours(numberofhours);
        LocalDateTime localDateTimePlus = date.atTime(localPlus);

        //Minus 5 hrs from entered time
        LocalTime localMinus = localTime.minusHours(numberofhours);
        LocalDateTime localDateTimeMinus = date.atTime(localMinus);
        System.out.println(localDateTimePlus.format(dateTimeFormatter1));
        System.out.println(localDateTimeMinus.format(dateTimeFormatter1));

        //check whether Plus hrs cross the midnight
        if((localPlus.isAfter(LocalTime.MIDNIGHT) || (localPlus == LocalTime.MIDNIGHT)) && localTime.isAfter(LocalTime.NOON))
        {
            localPlus = localTime.withHour(23);
            System.out.println("localPlus"+localPlus);
            localDateTimePlus = localDateTimePlus.plusDays(1);
            System.out.println("localDateTimePlus "+localDateTimePlus);
        }

        //check whether minus hrs falls before prev day midnight
        if((localMinus.isAfter(LocalTime.MIDNIGHT) || (localMinus == LocalTime.MIDNIGHT)) && localTime.isBefore(LocalTime.NOON))
        {
            localMinus = localTime.withHour(01);
            System.out.println("localMinus"+localMinus);
            localDateTimeMinus=localDateTimeMinus.minusDays(1);
            System.out.println("localDateTimeMinus :" +localDateTimeMinus);
        }


        /*localMinus = durationperiod(localMinus,localTime);
        localPlus = durationperiod(localPlus,localTime);*/

        System.out.println("Duration " + localMinus + "," + localPlus);
        FlightsBean[] fli= flightRepository.getFlight(localMinus,localPlus);
        FlightsBean[] flightsBean = new FlightsBean[fli.length];
       /* for (int i = 0; i < fli.length ; i++) {
            for (FlightsBean flights:fli) {
                flightsBean[i].setFlightName(flights.getFlightName());
                flightsBean[i].setFlightDeparture(flights.getFlightDeparture());
                if(localDateTimeMinus!=null || localDateTimePlus!=null)
                    flightsBean[i].toString().concat("Result is displayed for today only. " +
                            "Next day flight time are not included"+localDateTimeMinus+","+localDateTimePlus);
                else
                    flightsBean[i].toString().concat("Within same date results are displayed");
            }
        }*/
        return fli;
    }


   /* public LocalTime durationperiod(LocalTime local,LocalTime actualtime)
    {
        if((local.isAfter(LocalTime.MIDNIGHT) || local == LocalTime.MIDNIGHT)) {
            local = actualtime.isBefore(LocalTime.NOON) ? local.withHour(01) : local.withHour(23);
            System.out.println(local);
            return local;
        }
        System.out.println(local);
        return local;
    }*/
}
