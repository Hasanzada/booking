package utils;

import entity.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class GenerateFlightFile {

    public static Map<Integer, Flight> getFlights(){
        Map<Integer, Flight> flights = new HashMap<>();
        for (int i = 1; i <= 25; i++) {
            Flight flight = new Flight();
            flight.setCountry(Utils.getRandomCountry());
            flight.setDate(new Date());
            flight.setDestination(Utils.getRandomCountry());
            flight.setId(i);
            flight.setSeats(Utils.generateRandomNumber());
            flights.put(flight.getId(), flight);
        }
        return flights;
    }
}
