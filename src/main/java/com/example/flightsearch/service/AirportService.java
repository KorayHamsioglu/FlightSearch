package com.example.flightsearch.service;


import com.example.flightsearch.model.Airport;
import com.example.flightsearch.model.Flight;
import com.example.flightsearch.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    //create

    public Airport addAirport(Airport airport){
        return airportRepository.save(airport);
    }

    //read
    public List<Airport> findAllAirports(){
        return airportRepository.findAll();
    }

    public Airport getAirportByID(String Id){

        return airportRepository.findById(Id).get();
    }

    public List<Airport> getAirportsByCity(String city){
        return airportRepository.findByCity(city);
    }

    //update
    public Airport updateAirport(Airport airportReq){
        Airport existingAirport=airportRepository.findById(airportReq.getId()).get();
        existingAirport.setCity(airportReq.getCity());

        return airportRepository.save(existingAirport);
    }

    //delete

    public String deleteAirport(String Id){
        airportRepository.deleteById(Id);
        return "Airport "+Id+" deleted.";
    }


}
