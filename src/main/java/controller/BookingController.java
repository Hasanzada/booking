package controller;

import entity.Booking;
import service.Service;
import service.ServiceAbstract;

import java.util.Collection;

public class BookingController {

    private Service<Booking> service = new ServiceAbstract<>("booking.bin");

    public Collection<Booking> getAllBookingBy(long user_id){
        return service.getAllBy(p -> p.getUser_id() == user_id);
    }


    public Booking getBook(long id){
        return service.get(id).get();
    }

    public void addBooking(Booking booking){
        long id = service.getAll().size() + 1;
        booking.setId(id);
        service.create(booking);
    }

    public void deleteBooking(int id){
        service.delete(id);
    }

}
