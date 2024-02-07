package com.example.flightsearch.repository;

import com.example.flightsearch.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends MongoRepository<Flight,String> {

    @Query("{departureAirport:  ?0, arrivalAirport:  ?1, departureDateTime:  ?2, returnDateTime:  ?3}")
    List<Flight> getFlightWithParams(String departureAirport, String arrivalAirport,LocalDateTime departureDateTime ,LocalDateTime returnDateTime);

    @Query("{departureAirport:  ?0, arrivalAirport:  ?1, departureDateTime:  ?2}")
    Flight getReturnFlightWithParams(String departure, String arrival, LocalDateTime departureDate);
    @Query("{departureAirport:  ?0, arrivalAirport:  ?1, departureDateTime:  ?2, returnDateTime:  null }")
    List<Flight> getOneWayFlightsWithParams(String departure, String arrival, LocalDateTime departureDate,LocalDateTime returnDateTime);

}
