package com.example.flightsearch;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Flight Search API",
                version= "1.0.0",
                contact = @Contact(
                        name = "Koray Hamşioğlu",
                        email = "hamsioglukoray@gmail.com"
                )
        )
)

public class FlightSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightSearchApplication.class, args);
    }



}
