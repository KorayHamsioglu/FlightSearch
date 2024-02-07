package com.example.flightsearch.repository;

import com.example.flightsearch.model.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AirportRepository extends MongoRepository<Airport,String> {


    List<Airport> findByCity(String city);
}
