package entity;

import java.io.Serializable;
import java.util.List;

public class Booking implements Identifiable, Serializable {
    final int id;
    final List<Passenger> passengers;
    final int flight_id;
    //final int user_id;

    private static final long serialVersionUID = 2L;

    public Booking(int id, List<Passenger> passengers, int flight_id) {
        this.id = id;
        this.passengers = passengers;
        this.flight_id = flight_id;
    }

    @Override
    public long getId() {
        return id;
    }


    @Override
    public String toString() {
        return String.format("id: %d flight %d passenger %s",id,flight_id, passengers);
    }
}
