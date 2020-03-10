package dao;

import entity.Flight;

import java.io.*;
import java.util.*;

public class DAOBookingFile implements DAO<Flight> {

    private HashMap<Integer, Flight> bookings = new HashMap<>();
    private Collection<Flight> myFlights = new ArrayList<>();

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

        try {
            File file = new File("booking.bin");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            myFlights= (Collection<Flight>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("smth went wrong during booking creation");
        }
        return myFlights;
    }

    @Override
    public void create(Flight flight) {

    }

    @Override
    public void delete(int id) {

    }
}
