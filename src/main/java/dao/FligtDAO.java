package dao;

import entity.Flight;
import utils.GenerateFlightFile;

import java.util.Collection;
import java.util.Map;

public class FligtDAO implements DAO<Flight> {

    private Map<Integer, Flight> storage = GenerateFlightFile.getFlights();

    public Flight get(int id) {
        return storage.get(id);
    }

    public Collection<Flight> getAll() {
        return storage.values();
    }

    public void create(Flight flight) {
        storage.put(flight.getId(), flight);
    }

    public void delete(int id) {
        storage.remove(id);
    }
}
