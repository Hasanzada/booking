package utils;

import entity.Flight;

import java.util.*;

public class Utils {
    public static String getRandomCountry(){
        List<String> countries = CountryList.getAllCountries();
        Random r = new Random();
        return countries.get((int)(Math.random()*countries.size()));
    }

    public static int generateRandomNumber(){
        return (int)(Math.random()*100);
    }

    public static Collection<Flight> getFlights(){
        Collection<Flight> flights = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            Flight flight = new Flight(i, getRandomCountry(),getRandomCountry(),new Date(), generateRandomNumber());
            flights.add(flight);
        }
        return flights;
    }

}
