package dao;

import entity.Booking;
import entity.Flight;
import entity.Passenger;
import entity.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DAOAbstractFileBinTest {

    DAO<Flight>daoFlight;
    DAO<Booking>daoBooking;
    DAO<User>daoUser;
    Flight flight;
    Booking booking;
    User user;
    Passenger passenger;
    List<Passenger>passengers = new ArrayList<>();
    File file ;

    @BeforeEach
    public void init(){
        file = new File("test.bin");
        daoFlight = new DAOAbstractFileBin<>(file.getPath());
        daoBooking = new DAOAbstractFileBin<>(file.getPath());
        daoUser = new DAOAbstractFileBin<>(file.getPath());

        passenger = new Passenger(1,"John","Snow");
        passengers.add(passenger);
        flight = new Flight(1,"Baku","Ankara","20:42 10-10-2020",75);
        booking = new Booking(passengers,2,3);
        booking.setId(1);
        user = new User(1,"admin","admin123");

    }


    @Test
    void getAll() {
        Collection<Flight>flights = new ArrayList<>();
        flights.add(flight);
        flights.add(new Flight(2,"IZMIR","PEKIN","20:42 10-10-2020",65));

        daoFlight.create(flight);
        daoFlight.create(new Flight(2,"IZMIR","PEKIN","20:42 10-10-2020",65));

        assertEquals(flights, (List<Flight>)daoFlight.getAll());
        file.delete();
    }

    @Test
    void getAllBy() {
        file.delete();
        List<Flight>flights = new ArrayList<>();
        flights.add(new Flight(2,"IZMIR","PEKIN","20:42 10-10-2020",65));
        flights.add(new Flight(3,"TEBRIZ","PEKIN","20:42 10-10-2020",75));

        daoFlight.create(new Flight(2,"IZMIR","PEKIN","20:42 10-10-2020",65));
        daoFlight.create(new Flight(3,"TEBRIZ","PEKIN","20:42 10-10-2020",75));

        assertEquals(flights, daoFlight.getAllBy(p -> p.getDestination().equals("PEKIN")));

    }



    @Test
    void get() {
        file.delete();
        daoFlight.create(flight);
        assertEquals(flight, daoFlight.get(1).get());

        file.delete();
        daoBooking.create(booking);
        assertEquals(booking, daoBooking.get(1).get());

        file.delete();
        daoUser.create(user);
        assertEquals(user,daoUser.get(1).get());

    }

    @Test
    void create() {
        file.delete();
        daoFlight.create(flight);
        List<Flight> flights = (List<Flight>) daoFlight.getAll();
        assertEquals(flight.getId(), flights.get(0).getId());

        file.delete();
        daoBooking.create(booking);
        List<Booking>bookings = (List<Booking>) daoBooking.getAll();
        assertEquals(booking.getId(), bookings.get(0).getId());

        file.delete();
        daoUser.create(user);
        List<User>users = (List<User>) daoUser.getAll();
        assertEquals(user.getLogin(), users.get(0).getLogin());
    }

    @Test
    void delete() {
        file.delete();
        daoFlight.create(new Flight(2,"ISTANBUL","MOSKVA","20:32 11-10-2020",55));
        daoFlight.delete(2);
        assertEquals(Optional.empty(), daoFlight.get(2));

        file.delete();
        daoBooking.create(new Booking(passengers,1,4));
        daoBooking.delete(2);
        assertEquals(Optional.empty(), daoBooking.get(2));

        file.delete();
        daoUser.create(new User(2,"Abrahm","admin123"));
        daoUser.delete(2);
        assertEquals(Optional.empty(), daoUser.get(2));

    }
}