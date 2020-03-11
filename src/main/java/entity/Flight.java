package entity;

import java.io.Serializable;
import java.util.Date;

public class Flight implements Serializable, Identifiable {

    final int id;
    final String country;
    final String destination;
    final Date date;
    final int seats;

    private static final long serialVersionUID = 1L;

    public Flight(int id, String country, String destination, Date date, int seats) {
        this.id = id;
        this.country = country;
        this.destination = destination;
        this.date = date;
        this.seats = seats;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("id: %d fly from %S to the %s on day: %s and" +
                " for now there are only %d seats",id,country,destination,date,seats);
    }


}
