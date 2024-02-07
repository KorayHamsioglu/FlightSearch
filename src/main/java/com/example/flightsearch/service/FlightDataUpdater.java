package com.example.flightsearch.service;

import com.example.flightsearch.model.Flight;
import com.example.flightsearch.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FlightDataUpdater {

    @Autowired
    private FlightRepository flightRepository;


    //Every Day at 12:00 AM
    @Scheduled(cron = "0 0 0 * * *")
    public void updateFlightData() {
        List<Flight> flights = fetchFlightDataFromAPI();
        saveFlightsToDatabase(flights);
        System.out.println("Flight data updated!");
    }

    //MockFlights
    private List<Flight> fetchFlightDataFromAPI() {

        List<Flight> flights = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Flight flight = new Flight();
            flight.setDepartureAirport("Departure " + i);
            flight.setArrivalAirport("Arrival " + i);
            flight.setDepartureDateTime(LocalDateTime.now());
            flight.setReturnDateTime(LocalDateTime.now().plusDays(random.nextInt(5)));
            flight.setPrice(i);
            flights.add(flight);
        }
        return flights;
    }

    private void saveFlightsToDatabase(List<Flight> flights) {
        flightRepository.saveAll(flights);
    }
}
