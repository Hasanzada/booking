package service;

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

import static org.junit.jupiter.api.Assertions.*;

class ServiceAbstractTest {

    Service<Flight> flightService;
    Service<Booking> bookingService;
    Service<User> userService;
    Flight flight;
    Booking booking;
    User user;
    Passenger passenger;
    List<Passenger> passengers;
    File file;

    @BeforeEach
    void setUp() {
        passengers = new ArrayList<>();
        file = new File("test2.bin");
        flightService = new ServiceAbstract<>(file.getPath());
        bookingService = new ServiceAbstract<>(file.getPath());
        userService = new ServiceAbstract<>(file.getPath());

        user = new User(1, "abcde","12345");
        passenger = new Passenger(1, "Zara", "Larsson");
        passengers.add(passenger);
        flight = new Flight(1, "Kiev", "Donesk", "20:42 21-03-2020", 50);
        booking = new Booking(passengers, 1,2);
        booking.setId(1);
    }

    @Test
    void get01() {
        file.delete();
        flightService.create(flight);
        assertEquals(flight, flightService.get(1).get());
    }

    @Test
    void get02() {
        file.delete();
        Flight flight2 = new Flight(2, "Kiev", "Donesk", "20:42 22-03-2020", 50);
        Flight flight3 = new Flight(3, "Moscow", "Istanbul", "15:00 22-03-2020", 50);
        flightService.create(flight2);
        flightService.create(flight3);
        assertEquals(flight3, flightService.get(3).get());
    }

    @Test
    void get03() {
        file.delete();
        Flight flight2 = new Flight(2, "Kiev", "Donesk", "20:42 22-03-2020", 50);
        flightService.create(flight2);
        assertEquals(flight2, flightService.get(2).get());
    }

    @Test
    void get04() {
        file.delete();
        bookingService.create(booking);
        assertEquals(booking, bookingService.get(1).get());
    }

    @Test
    void get05() {
        file.delete();
        Booking booking2 = new Booking(passengers, 10,2);
        booking2.setId(2);
        bookingService.create(booking);
        bookingService.create(booking2);
        assertEquals(booking2, bookingService.get(2).get());
        assertEquals(booking,bookingService.get(1).get());
    }

    @Test
    void get06() {
        file.delete();
        userService.create(user);
        assertEquals(user,userService.get(1).get());
    }

    @Test
    void getAll01() {
        file.delete();
        Flight flight2 = new Flight(2, "Kiev", "Donesk", "20:42 22-03-2020", 50);
        Collection<Flight> flightCollection = new ArrayList<>();
        flightCollection.add(flight);
        flightCollection.add(flight2);
        flightService.create(flight);
        flightService.create(flight2);
        assertEquals(flightCollection, flightService.getAll());
    }

    @Test
    void getAll02() {
        file.delete();
        Flight flight3 = new Flight(3, "Moscow", "Istanbul", "15:00 22-03-2020", 50);
        Collection<Flight> flightCollection = new ArrayList<>();
        flightCollection.add(flight);
        flightCollection.add(flight3);
        flightService.create(flight);
        flightService.create(flight3);
        assertEquals(flightCollection, flightService.getAll());
    }

    @Test
    void getAll03() {
        file.delete();
        Flight flight3 = new Flight(3, "Moscow", "Istanbul", "15:00 22-03-2020", 50);
        Collection<Flight> flightCollection = new ArrayList<>();
        flightCollection.add(flight3);
        flightService.create(flight3);
        assertEquals(flightCollection, flightService.getAll());
    }

    @Test
    void getAll04() {
        file.delete();
        Collection<Flight> flightCollection = new ArrayList<>();
        flightCollection.add(flight);
        flightService.create(flight);
        assertEquals(flightCollection, flightService.getAll());
    }

    @Test
    void getAll05() {
        file.delete();
        Booking booking2 = new Booking(passengers, 10,2);
        booking2.setId(2);
        Collection<Booking> bookings = new ArrayList<>();
        bookings.add(booking);
        bookings.add(booking2);
        bookingService.create(booking);
        bookingService.create(booking2);
        assertEquals(bookings, bookingService.getAll());
    }

    @Test
    void getAll06() {
        file.delete();
        Booking booking2 = new Booking(passengers, 10,2);
        booking2.setId(2);
        Collection<Booking> bookings = new ArrayList<>();
        bookings.add(booking2);
        bookingService.create(booking2);
        assertEquals(bookings, bookingService.getAll());
    }

    @Test
    void getAll07() {
        file.delete();
        Booking booking2 = new Booking(passengers, 10,2);
        booking2.setId(2);
        Collection<Booking> bookings = new ArrayList<>();
        bookings.add(booking2);
        bookingService.create(booking2);
        bookingService.create(booking2);
        assertEquals(bookings, bookingService.getAll());
    }

    @Test
    void getAll08() {
        file.delete();
        Collection<User> users = new ArrayList<>();
        users.add(user);
        userService.create(user);
        assertEquals(users, userService.getAll());
    }

    @Test
    void getAll09() {
        file.delete();
        User user2 = new User(2, "aaaaa","11111");
        Collection<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        userService.create(user);
        userService.create(user2);
        assertEquals(users, userService.getAll());
    }

    @Test
    void getAllBy01() {
        file.delete();
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(1,"Brasil","Manchester","15:30 20-10-2020",100));
        flights.add(new Flight(2,"Praga","Manchester","15:30 20-10-2020",75));

        flightService.create(new Flight(1,"Brasil","Manchester","15:30 20-10-2020",100));
        flightService.create(new Flight(2,"Praga","Manchester","15:30 20-10-2020",75));

        assertEquals(flights, flightService.getAllBy(p -> p.getDestination().equals("Manchester")));
    }

    @Test
    void getAllBy02() {
        file.delete();
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(1,"Brasil","Manchester","15:30 20-10-2020",100));

        flightService.create(new Flight(1,"Brasil","Manchester","15:30 20-10-2020",100));
        flightService.create(new Flight(2,"Praga","London","15:30 20-10-2020",75));

        assertEquals(flights, flightService.getAllBy(p -> p.getDestination().equals("Manchester")));
    }

    @Test
    void create01() {
        file.delete();
        Flight flight3 = new Flight(3, "Moscow", "Istanbul", "15:00 22-03-2020", 50);
        flightService.create(flight3);
        assertEquals(flight3.getId(),flightService.get(3).get().getId());
    }

    @Test
    void create02() {
        file.delete();
        Flight flight3 = new Flight(3, "Moscow", "Istanbul", "15:00 22-03-2020", 50);
        Flight flight1 = new Flight(1, "Madrid", "Canada", "15:00 22-03-2020", 50);
        flightService.create(flight3);
        flightService.create(flight1);
        assertEquals(flight1.getId(),flightService.get(1).get().getId());
    }

    @Test
    void create03() {
        file.delete();
        List<Flight> flights = new ArrayList<>();
        Flight flight3 = new Flight(3, "Moscow", "Istanbul", "15:00 22-03-2020", 50);
        Flight flight1 = new Flight(1, "Madrid", "Canada", "15:00 22-03-2020", 50);
        Flight flight2 = new Flight(1, "Madrid", "Canada", "15:00 22-03-2020", 50);
        flights.add(flight1);
        flights.add(flight3);
        flightService.create(flight1);
        flightService.create(flight2);
        flightService.create(flight3);
        assertEquals(flights, flightService.getAll());
    }

    @Test
    void create04() {
        file.delete();
        bookingService.create(booking);
        assertEquals(booking.getId(),bookingService.get(1).get().getId());
    }

    @Test
    void create05() {
        file.delete();
        Booking booking2 = new Booking(passengers, 10,2);
        booking2.setId(2);
        Booking booking3 = new Booking(passengers, 13,3);
        booking3.setId(3);

        bookingService.create(booking2);
        bookingService.create(booking3);
        assertEquals(booking2.getId(),bookingService.get(2).get().getId());
    }

    @Test
    void create06() {
        file.delete();
        List<Booking> bookings = new ArrayList<>();
        Booking booking2 = new Booking(passengers, 10,2);
        booking2.setId(2);
        Booking booking3 = new Booking(passengers, 13,3);
        booking3.setId(3);
        bookings.add(booking);
        bookings.add(booking2);
        bookings.add(booking3);

        bookingService.create(booking);
        bookingService.create(booking2);
        bookingService.create(booking3);
        assertEquals(bookings,bookingService.getAll());
    }

    @Test
    void delete01() {
        file.delete();
        Flight flight3 = new Flight(3, "Moscow", "Istanbul", "15:00 22-03-2020", 50);
        Flight flight1 = new Flight(1, "Madrid", "Canada", "15:00 22-03-2020", 50);
        flightService.create(flight3);
        flightService.delete(3);
        assertEquals(Optional.empty(),flightService.get(3));
    }

    @Test
    void delete02() {
        file.delete();
        List<Flight> flights = new ArrayList<>();
        Flight flight3 = new Flight(3, "Moscow", "Istanbul", "15:00 22-03-2020", 50);
        Flight flight1 = new Flight(1, "Madrid", "Istanbul", "15:00 22-03-2020", 50);
        flights.add(flight3);
        flightService.create(flight3);
        flightService.create(flight1);
        flightService.delete(1);
        assertEquals(flights, flightService.getAllBy(p -> p.getDestination().equals("Istanbul")));
    }

    @Test
    void delete03() {
        file.delete();
        Booking booking2 = new Booking(passengers, 10,2);
        booking2.setId(2);
        Booking booking3 = new Booking(passengers, 13,3);
        booking3.setId(3);
        bookingService.create(booking);
        bookingService.create(booking2);
        bookingService.create(booking3);
        bookingService.delete(3);
        assertEquals(Optional.empty(),bookingService.get(3));
    }

    @Test
    void delete04() {
        file.delete();
        List<Booking> bookings = new ArrayList<>();
        Booking booking2 = new Booking(passengers, 10,2);
        booking2.setId(2);
        Booking booking3 = new Booking(passengers, 13,3);
        booking3.setId(3);
        bookings.add(booking);
        bookings.add(booking3);
        bookingService.create(booking);
        bookingService.create(booking2);
        bookingService.create(booking3);
        bookingService.delete(2);
        assertEquals(bookings,bookingService.getAll());
    }
}