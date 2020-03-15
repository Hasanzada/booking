package entity;

import java.io.Serializable;

public class Passenger implements Serializable {
    final long id;
    final String name;
    final String surname;

    private static final long serialVersionUID = 3L;

    public Passenger(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return String.format("%d.%s %s", id, name, surname);
    }
}
