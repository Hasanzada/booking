package controller;

import entity.User;
import service.Service;
import service.ServiceMemory;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserController {

    private static UserController single_instance = null;

    public static UserController getInstance() {
        if (single_instance == null)
            single_instance = new UserController();
        return single_instance;
    }

    private Map<Long, User> users = new HashMap<>();
    File file = new File("users.bin");
    private Service<User> service = new ServiceMemory(file.getName(),users);
    //private Service<User> service_user = new ServiceMemory();

    public User getUser(int user_id) {
        return service.get(user_id).get();
    }

    public Collection<User> users() {
        if (file.exists()) {
            //service.read().stream().forEach(x -> service.create(x));
            for(User user : service.read().values()){
                service.create(user);
            }
        }
        return service.getAll();
    }

    public boolean checkUserByLogin(String login) {
        return checkUserByUsername(login);
    }

    public void addUser(User user) {
        service.create(user);
    }

    public void saveInFile() {
        System.out.println(service.getAll());
        service.write(users);
    }

    public User getUserByNameAndPassword(String username, String password) {
        return getUserByUsernameAndPasssword(username, password);
    }

    public boolean checkUser(String username, String password) {
        return checkUserByUsernameAndPasssword(username, password);
    }

    public boolean checkUserByUsername(String name) {
        return users().stream().anyMatch(p -> p.getLogin().equals(name));
    }


    public User getUserByUsernameAndPasssword(String username, String password) {
        return users().stream().
                filter(p -> (p.getLogin().equals(username) && p.getPassword().equals(password.trim()))).
                findFirst().get();
    }

    public boolean checkUserByUsernameAndPasssword(String username, String password) {
        return users().stream().
                anyMatch(p -> (p.getLogin().equalsIgnoreCase(username) && p.getPassword().equals(password.trim())));
    }

}
