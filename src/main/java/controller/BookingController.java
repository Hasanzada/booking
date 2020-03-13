package controller;

import entity.Booking;
import service.BookingService;

import java.util.Collection;

public class BookingController {

    BookingService bookingService = new BookingService();

    /*public Collection<Booking> getAllBooking(){
        return bookingService.getBookings();

    }*/

    public Collection<Booking> getAllBookingBy(long user_id){
        return bookingService.getBookings(user_id);
    }


    public Booking getBook(int id){
        return bookingService.getBooking(id);
    }

    public void addBooking(Booking booking){

        bookingService.create(booking);
    }

    public void deleteBooking(int id){
        bookingService.delete(id);
    }

}
