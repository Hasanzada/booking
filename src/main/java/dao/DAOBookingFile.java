package dao;

import entity.Flight;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DAOBookingFile {

    private HashMap<Integer, Flight> bookings = new HashMap<>();
    private Collection<Flight> myFlights = new ArrayList<>();

    /*@Override
    public Optional<A> get(int id) {
        return getAll()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public void create(A data) {

    }

    @Override
    public Collection<A> getAll() {

        try {
            File file = new File("booking.bin");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            myFlights= (Collection<Flight>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<>();
        }
        return myFlights;
    }

    @Override
    public Collection<A> getAllBy(Predicate<A> p) {
        return null;
    }

    @Override
    public void create(Flight flight) {
        Collection<Flight> flightCollection = getAll();
        flightCollection.add(flight);
        write(flightCollection);

    }

    private void write(Collection<Flight> flightCollection) {
        try{
            File file = new File("booking.bin");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(flightCollection);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }*/
}
