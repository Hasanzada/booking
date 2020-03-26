package controller;

import entity.Flight;
import service.Service;

import service.ServiceMemory;
import utils.Utils;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class FlightController {

    private static FlightController single_instance = null;

    public static FlightController getInstance() {
        if (single_instance == null)
            single_instance = new FlightController();
        return single_instance;
    }

    private File file = new File("flights.bin");
    private Map<Long, Flight> flights = new HashMap<>();
    Service<Flight> service = new ServiceMemory(file.getName(),flights);


    public void generateFile() {
        if (!file.exists()) {
            for (int i = 1; i <= 30; i++) {
                service.create(Utils.getFlights(i));
            }
            saveInFile();
        }
        for (Flight flight : service.read().values()) {
            service.create(flight);
        }
    }

    public void updateFlightafterBooking(long id, int ticket_count) {
        Flight flight = service.get(id).get();
        flight.setSeats(flight.getSeats() - ticket_count);
        service.update(flight, id);
        saveInFile();
    }

    public void updateFlightafterCancel(long id, int ticket_count) {
        Flight flight = service.get(id).get();
        flight.setSeats(flight.getSeats() + ticket_count);
        service.update(flight, id);
        saveInFile();
    }

    public void saveInFile() {
        service.write(flights);
    }


    public void genearate() {
        generateFile();
    }

    public String getById(int id) {
        return getFlightById(id);
    }

    public String getFlightById(long id) {
        return service.get(id).map(Flight::toString).orElse("There is no Flight with that id");
    }

    public Collection<Flight> getAllFlight() {
        return service.getAll();

    }

    public Collection<Flight> flightsByCityAndDate(String city, String date) {
        return service.getAllBy(p -> (p.getDestination().equalsIgnoreCase(city) && p.getDate().equals(date)));
    }

    public Flight getFlight(int id) {
        return service.get(id).get();
    }
}
