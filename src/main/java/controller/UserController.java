package controller;

import entity.User;
import service.UserService;

import java.util.List;

public class UserController {

    private final UserService userService = new UserService();

    public User getUser(int user_id){
        return userService.get(user_id);
    }

    public User getUserByNameAndPassword(String username, String password){
        return userService.getUserByUsernameAndPasssword(username, password);
    }

    public boolean checkUser(String username, String password){
        return userService.checkUserByUsernameAndPasssword(username,password);
    }

    public void addUser(User user){
        userService.createUser(user);
    }
}
