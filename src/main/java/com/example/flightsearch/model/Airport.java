package com.example.flightsearch.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Airports")
public class Airport {
    @Id
    private String id;
    private String city;
}
