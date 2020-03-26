package dao;

import entity.Booking;
import entity.Flight;
import entity.Passenger;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DAOAbstractFileBinTest {

    DAO<Flight>daoFlight;
    DAO<Booking>daoBooking;
    DAO<User>daoUser;
    Flight flight;
    Booking booking;
    User user;
    Passenger passenger;
    List<Passenger> passengers = new ArrayList<>();
    Map<Long, Flight> flightMap = new HashMap<>();
    Map<Long, User> userMap = new HashMap<>();
    Map<Long, Booking> bookingMap = new HashMap<>();


    @BeforeEach
    public void init(){
        daoFlight = new DAOMemory<>(flightMap);
        daoBooking = new DAOMemory<>(bookingMap);
        daoUser = new DAOMemory<>(userMap);

        passenger = new Passenger(1,"John","Snow");
        passengers.add(passenger);
        flight = new Flight(1,"Baku","Ankara","10-10-2020", "20:00", 75);
        booking = new Booking(passengers,2,3);
        booking.setId(1);
        user = new User(1,"admin","admin123");

    }


    @Test
    void getAll() {
        Collection<Flight> flights = new ArrayList<>();
        flights.add(flight);
        flights.add(new Flight(2,"IZMIR","PEKIN","10-10-2020", "20:00", 65));

        daoFlight.create(flight);
        daoFlight.create(new Flight(2,"IZMIR","PEKIN","10-10-2020", "20:00", 65));

        assertEquals(true, flights.containsAll(daoFlight.getAll()));

    }

    @Test
    void getAllBy() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(2,"IZMIR","PEKIN","10-10-2020", "20:00", 65));
        flights.add(new Flight(3,"TEBRIZ","PEKIN","10-10-2020", "20:00", 75));

        daoFlight.create(new Flight(2,"IZMIR","PEKIN","10-10-2020", "20:00", 65));
        daoFlight.create(new Flight(3,"TEBRIZ","PEKIN","10-10-2020", "20:00", 75));

        assertEquals(flights, daoFlight.getAllBy(p -> p.getDestination().equals("PEKIN")));
    }



    @Test
    void get() {
        daoFlight.create(flight);
        assertEquals(flight, daoFlight.get(1).get());

        daoBooking.create(booking);
        assertEquals(booking, daoBooking.get(1).get());

        daoUser.create(user);
        assertEquals(user,daoUser.get(1).get());

    }

    @Test
    void create() {
        daoFlight.create(flight);
        Collection<Flight> flights =  daoFlight.getAll();
        assertEquals(true, !flights.isEmpty());

        daoBooking.create(booking);
        Collection<Booking> bookings = daoBooking.getAll();
        assertEquals(true, !flights.isEmpty());

        daoUser.create(user);
        Collection<User> users = daoUser.getAll();
        assertEquals(true, !flights.isEmpty());
    }

    @Test
    void delete() {
        daoFlight.create(new Flight(2,"ISTANBUL","MOSKVA","10-10-2020", "20:00", 55));
        daoFlight.delete(2);
        assertEquals(Optional.empty(), daoFlight.get(2));

        daoBooking.create(new Booking(passengers,1,4));
        daoBooking.delete(2);
        assertEquals(Optional.empty(), daoBooking.get(2));

        daoUser.create(new User(2,"Abrahm","admin123"));
        daoUser.delete(2);
        assertEquals(Optional.empty(), daoUser.get(2));

    }
}