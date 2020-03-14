package entity;

import java.io.Serializable;


public class Flight implements Serializable, Identifiable {

    final int id;
    final String country;
    final String destination;
    final String date;
    final int seats;

    private static final long serialVersionUID = 1L;

    public Flight(int id, String country, String destination, String date, int seats) {
        this.id = id;
        this.country = country;
        this.destination = destination;
        this.date = date;
        this.seats = seats;
    }

    public long getId() {
        return this.id;
    }

    public String getCity() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("|id:%2d |%-10s |%-10s | %s " +
                "|seats: %2d|",id,country,destination,date,seats);
    }


}
