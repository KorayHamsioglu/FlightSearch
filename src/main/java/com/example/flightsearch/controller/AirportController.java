package com.example.flightsearch.controller;


import com.example.flightsearch.model.Airport;
import com.example.flightsearch.model.Flight;
import com.example.flightsearch.service.AirportService;
import com.example.flightsearch.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    //create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Airport createAirport(@RequestBody Airport airport){
        return airportService.addAirport(airport);
    }
    //read
    @GetMapping
    public List<Airport> getAirports(){
        return airportService.findAllAirports();
    }

    @GetMapping("/{airportId}")
    public Airport getAirport(@PathVariable String airportId){
        return airportService.getAirportByID(airportId);
    }

    @GetMapping("/city/{city}")
    public List<Airport> getAirportsInCity(@PathVariable String city){
        return airportService.getAirportsByCity(city);
    }


    //update

    @PutMapping
    public Airport modifyFlight(@RequestBody Airport airport){
        return airportService.updateAirport(airport);
    }

    //Delete

    @DeleteMapping("/{airportId}")
    public String deleteFlight(@PathVariable String airportId){
        return airportService.deleteAirport(airportId);
    }

}
