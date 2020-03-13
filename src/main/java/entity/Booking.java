package entity;

import java.io.Serializable;
import java.util.List;

public class Booking implements Identifiable, Serializable {
    private long id;
    final List<Passenger> passengers;
    final int flight_id;
    long user_id;

    private static final long serialVersionUID = 2L;

    public Booking(List<Passenger> passengers, int flight_id, long user_id) {
        this.passengers = passengers;
        this.flight_id = flight_id;
        this.user_id = user_id;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return String.format("id: %d flight %d passenger %s",id,flight_id, passengers);
    }
}
