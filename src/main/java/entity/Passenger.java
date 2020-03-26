package entity;

import java.io.Serializable;
import java.util.Objects;

public class Passenger implements Serializable {
    final long id;
    final String name;
    final String surname;

    private static final long serialVersionUID = 33L;

    public Passenger(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return id == passenger.id &&
                Objects.equals(name, passenger.name) &&
                Objects.equals(surname, passenger.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    @Override
    public String toString() {
        return String.format("%d.%s %s", id, name, surname);
    }
}
