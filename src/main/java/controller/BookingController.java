package controller;

import entity.Flight;
import service.BookingService;

import java.util.Collection;

public class BookingController {

    BookingService bookingService = new BookingService();

    public Collection<Flight> getAllBooking(){
        return bookingService.getBookings();
    }

    public Flight getBook(int id){
        return bookingService.getBook(id);
    }

    public void addBooking(Flight flight){
        bookingService.createBook(flight);
    }

}
