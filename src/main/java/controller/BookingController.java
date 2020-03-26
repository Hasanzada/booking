package controller;

import entity.Booking;
import entity.User;
import service.Service;

import service.ServiceMemory;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookingController {

    private static BookingController single_instance = null;

    public static BookingController getInstance() {
        if (single_instance == null)
            single_instance = new BookingController();
        return single_instance;
    }

    private File file = new File("bookings.bin");
    private Map<Long, Booking> bookings = new HashMap<>();
    private Service<Booking> service = new ServiceMemory(file.getName(),bookings);


    public Collection<Booking> getAllBookingBy(long user_id) {
        return service.getAllBy(p -> p.getUser_id() == user_id);
    }

    public void saveInFile() {
        service.write(bookings);
    }


    public Booking getBook(long id) {
        return service.get(id).get();
    }

    public void addBooking(Booking booking) {
        service.create(booking);
    }

    public void deleteBooking(long id) {
        service.delete(id);
    }


    public boolean deleteBooking(long id, long user_id) {
        boolean b = getAllBookingBy(user_id).stream()
                .anyMatch(p -> p.getId() == id);
        deleteBooking(getAllBookingBy(user_id).stream()
                .filter(p -> p.getId() == id)
                .findFirst().map(Booking::getId)
                .orElse(0L));
        return b;
    }

    public void genearate() {
        if(file.exists()) {
            for (Booking booking : service.read().values()) {
                service.create(booking);
            }
        }else
            service.getAll();

    }
}
