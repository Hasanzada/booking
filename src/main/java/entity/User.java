package entity;

import dao.Identifiable;

import java.io.Serializable;

public class User implements Serializable, Identifiable {
    final long id;
    private final String login;
    private final String password;

    private static final long serialVersionUID = 4L;

    public User(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    @Override
    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("id: %d login %S ", id, login);
    }
}
