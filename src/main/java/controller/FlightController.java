package controller;

import entity.Flight;
import service.Service;
import service.ServiceAbstract;
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
    Service<Flight> service = new ServiceAbstract(file.getName());
    Service<Flight> service_memory = new ServiceMemory<>(flights);

    public void generateFile() {
        if (!file.exists()) {
            for (int i = 1; i <= 30; i++) {
                service_memory.create(Utils.getFlights(i));
            }
            saveInFile();
        }
        for (Flight flight : service.getAll()) {
            service_memory.create(flight);
        }
    }

    public void updateFlight(long id, int ticket_count) {
        Flight flight = service_memory.get(id).get();
        flight.setSeats(flight.getSeats() - ticket_count);
        service_memory.update(flight, id);
        saveInFile();
    }

    public void saveInFile() {
        service_memory.getAll().stream()
                .forEach(x -> service.create(x));
    }


    public void genearate() {
        generateFile();
    }

    public String getById(int id) {
        return getFlightById(id);
    }

    public String getFlightById(long id) {
        return service_memory.get(id).map(Flight::toString).orElse("There is no Flight with that id");
    }

    public Collection<Flight> getAllFlight() {
        return service_memory.getAll();

    }

    public Collection<Flight> flightsByCityAndDate(String city, String date) {
        return service_memory.getAllBy(p -> (p.getDestination().equalsIgnoreCase(city) && p.getDate().equals(date)));
    }

    public Flight getFlight(int id) {
        return service_memory.get(id).get();
    }
}
