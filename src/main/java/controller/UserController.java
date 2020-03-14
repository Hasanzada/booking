package controller;

import entity.User;
import service.UserService;
import java.util.Collection;

public class UserController {

    private final UserService userService = new UserService();

    public User getUser(int user_id){
        return userService.get(user_id);
    }

    public Collection<User>getAll(){
        return userService.getAllUsers();
    }

    public User getUserByNameAndPassword(String username, String password){
        return userService.getUserByUsernameAndPasssword(username, password);
    }

    public boolean checkUser(String username, String password){
        return userService.checkUserByUsernameAndPasssword(username,password);
    }

    public boolean checkUserByLogin(String login){
        return userService.checkUserByUsername(login);
    }

    public void addUser(User user){
        userService.createUser(user);
    }
}
