package com.example.flightsearch.service;


import com.example.flightsearch.model.Flight;
import com.example.flightsearch.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    //create
    public Flight addFlight(Flight flight){
        return flightRepository.save(flight);
    }

    //read
    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    public Flight getFlightByID(String Id){
        return flightRepository.findById(Id).get();
    }

    public List<Flight> getFlightWithParams(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime, LocalDateTime returnDateTime) {
        List<Flight> flights = flightRepository.getFlightWithParams(departureAirport, arrivalAirport, departureDateTime, returnDateTime);
        List<Flight> resultList = new ArrayList<>(flights);
        resultList.add(flightRepository.getReturnFlightWithParams(arrivalAirport,departureAirport,returnDateTime));
        return resultList;
    }

    public List<Flight> getOneWayFlightWithParams(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime,LocalDateTime returnDateTime) {
        return flightRepository.getOneWayFlightsWithParams(departureAirport,arrivalAirport,departureDateTime,returnDateTime);
    }


    //Update
    public Flight updateFlight(Flight flightReq){
        Flight existingFlight=flightRepository.findById(flightReq.getId()).get();
        existingFlight.setArrivalAirport(flightReq.getArrivalAirport());
        existingFlight.setDepartureAirport(flightReq.getDepartureAirport());
        existingFlight.setPrice(flightReq.getPrice());
        existingFlight.setDepartureDateTime(flightReq.getDepartureDateTime());
        existingFlight.setReturnDateTime(flightReq.getReturnDateTime());
        return flightRepository.save(existingFlight);
    }


    //Delete

    public String deleteFlight(String Id){
        flightRepository.deleteById(Id);
        return "Flight "+Id +" deleted.";
    }




}
