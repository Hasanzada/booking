package controller;

import entity.Booking;
import service.Service;
import service.ServiceAbstract;
import service.ServiceMemory;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookingController {

    private static BookingController single_instance = null;

    public static BookingController getInstance()
    {
        if (single_instance == null)
            single_instance = new BookingController();
        return single_instance;
    }
    private File file = new File("booking.bin");
    private Map<Long, Booking> bookings = new HashMap<>();
    private Service<Booking> service = new ServiceAbstract("booking.bin");
    private Service<Booking> service_memory = new ServiceMemory<>(bookings);

    public Collection<Booking> getAllBookingBy(long user_id){
        if(file.exists()){
            service.getAll().stream().forEach(x->service_memory.create(x));
            return service_memory.getAllBy(p -> p.getUser_id() == user_id);
        }else {
            return service_memory.getAllBy(p -> p.getUser_id() == user_id);
        }
    }

    public void saveInFile(){
        service_memory.getAll().stream()
                .forEach(x -> service.create(x));
    }


    public Booking getBook(long id){
        return service_memory.get(id).get();
    }

    public void addBooking(Booking booking){
        long id = service.getAll().size() + 1;
        booking.setId(id);
        service.create(booking);
    }

    public void deleteBooking(long id){
        service_memory.delete(id);
    }


    public boolean deleteBooking(long id, long user_id) {
        boolean b = getAllBookingBy(user_id).stream()
                .anyMatch(p -> p.getId() == id);
        deleteBooking(getAllBookingBy(user_id).stream()
                .filter(p->p.getId()==id)
                .findFirst().map(Booking::getId)
                .orElse(0L));
        return b;
    }
}
