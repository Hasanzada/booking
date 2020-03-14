package service;


import dao.DAO;
import dao.DAOAbstractFileBin;
import entity.Booking;
import entity.Flight;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class BookingService {
    private final DAO<Booking> dao = new DAOAbstractFileBin("bookings.bin");

    public Collection<Booking> getBookings(long user_id) {
        return dao.getAllBy(p -> p.getUser_id() == user_id);
    }

    public Booking getBooking(int id) {
        return dao.get(id).get();
    }

    public void create(Booking booking) {
        long id = dao.getAll().size() + 1;
        booking.setId(id);
        dao.create(booking);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public List<Flight> getAllBy(Predicate p) {
        return (List<Flight>) dao.getAllBy(p);
    }
}
