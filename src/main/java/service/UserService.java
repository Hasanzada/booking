package service;

import dao.DAO;
import dao.DAOAbstractFileBin;
import entity.User;

import java.util.Collection;


public class UserService {

    private final DAO<User> dao = new DAOAbstractFileBin<>("users.bin");

    public User get(int user_id) {
        return dao.get(user_id).get();
    }

    public Collection<User> getAllUsers() {
        return dao.getAll();
    }

    public void createUser(User user) {
        dao.create(user);
    }

    public Collection<User> users() {
        return dao.getAll();
    }

    public User getUserByUsernameAndPasssword(String username, String password) {
        return users().stream().
                filter(p -> (p.getLogin().equals(username) && p.getPassword().equals(password.trim()))).
                findFirst().get();
    }

    public boolean checkUserByUsernameAndPasssword(String username, String password) {
        return users().stream().
                anyMatch(p -> (p.getLogin().equals(username) && p.getPassword().equals(password.trim())));
    }

    public boolean checkUserByUsername(String name) {
        return users().stream().anyMatch(p -> p.getLogin().equals(name));
    }
}
