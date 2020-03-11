package entity;

import java.io.Serializable;
import java.util.Date;

public class Flight implements Serializable {

    private int id;
    private String country;
    private String destination;
    private Date date;
    private int seats;

    public Flight(int id, String country, String destination, Date date, int seats) {
        this.id = id;
        this.country = country;
        this.destination = destination;
        this.date = date;
        this.seats = seats;
    }

    public Flight() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return String.format("id: %d fly from %S to the %s on day: %s and" +
                " for now there are only %d seats",id,country,destination,date,seats);
    }
}
