package utils;

import entity.Flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Utils {
    public static String getRandomCountry() {
        List<String> countries = CityList.getAllCountries();
        return countries.get((int) (Math.random() * countries.size()));
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * 100);
    }

    public static Flight getFlights(int id) {
        Flight flight = new Flight(id, getRandomCountry(), getRandomCountry(),
                LocalDateTime.now()
                        .plusHours((int) (Math.random() * 72 + 1))
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                String.format("%02d:%02d", (int) (Math.random() * 24), (int) (Math.random() * 4) * 15),
                generateRandomNumber());
        return flight;
    }
}
