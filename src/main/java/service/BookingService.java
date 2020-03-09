package service;

import dao.DAO;
import dao.DAOBookingFile;
import entity.Flight;

import java.util.Collection;
import java.util.List;

import utils.Utils;


public class BookingService {
    private final DAO<Flight> dao = new DAOBookingFile();

    public Collection<Flight> getBookings() {
        return dao.getAll();
    }

    public Flight getBook(int id) {
        return dao.get(id);
    }

    public void createBook(Flight flight) {
        dao.create(flight);
    }

    public void createBookingInList(Flight flight) {
        Utils.addFlight(flight);
    }

    public List<Flight> getAllFlightsList(){
        return Utils.getFlightList();
    }
}
