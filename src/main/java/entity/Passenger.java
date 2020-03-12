package entity;

import java.io.Serializable;

public class Passenger implements Serializable {
    final int id;
    final String name;
    final String surname;

    private static final long serialVersionUID = 3L;

    public Passenger(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
