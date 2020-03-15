package entity;

import dao.Identifiable;

import java.io.Serializable;
import java.util.Objects;


public class Flight implements Serializable, Identifiable {

    final long id;
    final String city;
    final String destination;
    final String date;
    final int seats;

    private static final long serialVersionUID = 1L;

    public Flight(long id, String city, String destination, String date, int seats) {
        this.id = id;
        this.city = city;
        this.destination = destination;
        this.date = date;
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return getId() == flight.getId() &&
                seats == flight.seats &&
                Objects.equals(city, flight.city) &&
                Objects.equals(getDestination(), flight.getDestination()) &&
                Objects.equals(getDate(), flight.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), city, getDestination(), getDate(), seats);
    }

    public long getId() {
        return this.id;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("|id:%2d |%-10s |%-10s | %s " +
                "|seats: %2d|", id, city, destination, date, seats);
    }
}
