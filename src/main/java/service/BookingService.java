package service;

import dao.DAO;
import dao.DAOBookingFile;
import dao.DAOFlightFile;
import entity.Flight;
import utils.GenerateFlightFile;
import utils.Utils;

import java.util.Collection;
import java.util.Map;

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

}
