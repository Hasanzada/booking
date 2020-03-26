package entity;

import dao.Identifiable;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Booking implements Serializable,Identifiable {
    private long id;
    final List<Passenger> passengers;
    final long flight_id;
    long user_id;

    private static final long serialVersionUID = 44L;

    public Booking(List<Passenger> passengers, long flight_id, long user_id) {
        this.passengers = passengers;
        this.flight_id = flight_id;
        this.user_id = user_id;
    }

    public Booking(long id, List<Passenger> passengers, long flight_id, long user_id) {
        this.id = id;
        this.passengers = passengers;
        this.flight_id = flight_id;
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return getId() == booking.getId() &&
                flight_id == booking.flight_id &&
                getUser_id() == booking.getUser_id() &&
                Objects.equals(passengers, booking.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), passengers, flight_id, getUser_id());
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
        return String.format("id:%d. flight id:%d. passengers %s", id, flight_id, passengers);
    }
}
