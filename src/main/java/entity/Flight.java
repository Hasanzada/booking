package entity;

import java.io.Serializable;


public class Flight implements Serializable, Identifiable {

    final int id;
    final String city;
    final String destination;
    final String date;
    final int seats;

    private static final long serialVersionUID = 1L;

    public Flight(int id, String city, String destination, String date, int seats) {
        this.id = id;
        this.city = city;
        this.destination = destination;
        this.date = date;
        this.seats = seats;
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
