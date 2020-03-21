package utils;

import entity.Flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Utils {
    public static String getRandomCountry() {
        List<String> countries = CityList.getAllCountries();
        Random r = new Random();
        return countries.get((int) (Math.random() * countries.size()));
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * 100);
    }

    public static Flight getFlights(int id) {
        Collection<Flight> flights = new ArrayList<>();
        Flight flight = new Flight(id, getRandomCountry(), getRandomCountry(),
                LocalDateTime.now()
                        .plusHours((int) (Math.random() * 72 + 1))
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                String.format("%02d:%02d",(int)(Math.random()*24),(int)(Math.random()*4)*15),
                generateRandomNumber());
        return flight;
    }
}
