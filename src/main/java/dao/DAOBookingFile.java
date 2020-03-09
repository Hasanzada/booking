package dao;

import entity.Flight;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.HashMap;

public class DAOBookingFile implements DAO<Flight> {
    @Override
    public Flight get(int id) {
        return getAll()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public Collection<Flight> getAll() {
        HashMap<Integer, Flight> flights = new HashMap<>();
        try {
            File file = new File("bookings.bin");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            flights = (HashMap<Integer, Flight>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            throw new RuntimeException("smth went wrong during flight creation");
        }
        return flights.values();
    }

    @Override
    public void create(Flight flight) {
    }

    @Override
    public void delete(int id) {

    }
}
