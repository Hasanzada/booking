package controller;

import entity.User;
import service.Service;
import service.ServiceAbstract;

import java.util.Collection;

public class UserController {


    private Service<User> service = new ServiceAbstract<>("users.bin");

    public User getUser(int user_id){
        return service.get(user_id).get();
    }

    public Collection<User> users(){
        return service.getAll();
    }

    public boolean checkUserByLogin(String login){
        return checkUserByUsername(login);
    }

    public void addUser(User user){
        service.create(user);
    }

    public User getUserByNameAndPassword(String username, String password){
        return getUserByUsernameAndPasssword(username, password);
    }

    public boolean checkUser(String username, String password){
        return checkUserByUsernameAndPasssword(username,password);
    }

    public boolean checkUserByUsername(String name){
        return users().stream().anyMatch(p -> p.getLogin().equals(name));
    }


    public User getUserByUsernameAndPasssword(String username, String password){
        return users().stream().
                filter(p -> (p.getLogin().equals(username) && p.getPassword().equals(password.trim()))).
                findFirst().get();
    }

    public boolean checkUserByUsernameAndPasssword(String username, String password){
        return users().stream().
                anyMatch(p -> (p.getLogin().equalsIgnoreCase(username) && p.getPassword().equals(password.trim())));
    }

}
