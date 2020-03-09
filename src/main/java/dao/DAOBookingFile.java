package dao;

import entity.Flight;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DAOBookingFile implements DAO<Flight> {

    private HashMap<Integer, Flight> bookings = new HashMap<>();;

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
            File file = new File("bookings.bin");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            bookings = (HashMap<Integer, Flight>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            throw new RuntimeException("smth went wrong during booking creation");
        }
        return bookings.values();
    }

    @Override
    public void create(Flight flight) {
        bookings = new HashMap<>();
        bookings.put(bookings.size(), flight);
    }

    @Override
    public void delete(int id) {

    }
}
