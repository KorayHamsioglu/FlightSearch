package com.example.flightsearch.controller;


import com.example.flightsearch.model.Flight;
import com.example.flightsearch.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    //Setting Rest API endpoints

    @Autowired
    private FlightService flightService;

    //create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flight createFlight(@RequestBody Flight flight){
        return flightService.addFlight(flight);
    }
    //read
    @GetMapping
    public List<Flight> getFlights(){
        return flightService.findAllFlights();
    }

    @GetMapping("/{flightId}")
    public Flight getFlight(@PathVariable String flightId){
        return flightService.getFlightByID(flightId);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam("departure") String departure,
            @RequestParam("arrival") String arrival,
            @RequestParam("departureDate")  LocalDateTime departureDate,
            @RequestParam(value = "returnDate", required = false)  LocalDateTime returnDate
    ){

        if (departure == null || arrival == null || departureDate == null) {
            return ResponseEntity.badRequest().build();
        }

        if (returnDate == null) {

            List<Flight> oneWayFlights = flightService.getOneWayFlightWithParams(departure, arrival, departureDate,returnDate);
            return ResponseEntity.ok(oneWayFlights);
        } else {

            List<Flight> roundTripFlights = flightService.getFlightWithParams(departure, arrival, departureDate, returnDate);
            return ResponseEntity.ok(roundTripFlights);
        }
    }

    //update

    @PutMapping
    public Flight modifyFlight(@RequestBody Flight flight){
        return flightService.updateFlight(flight);
    }

    //Delete

    @DeleteMapping("/{flightId}")
    public String deleteFlight(@PathVariable String flightId){
        return flightService.deleteFlight(flightId);
    }


}
