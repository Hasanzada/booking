package controller;

import entity.Flight;
import service.FlightService;
import java.util.Collection;

public class FlightController {

    private FlightService flightService = new FlightService();

    public void genearate() {
        flightService.generateFile();
    }

    public Collection<Flight> getAllFlight() {
        return flightService.getFlights();
    }

    public Collection<Flight> flightsByCityAndDate(String city, String date) {
        return flightService.flightsByCityAndDate(city.toUpperCase(), date);
    }

    public Flight getFlight(int id) {
        return flightService.getFlight(id);
    }

    public String getFlightById(int id) {
        return flightService.getFlightById(id);
    }
}
