package controller;

import entity.User;
import service.Service;
import service.ServiceAbstract;
import service.ServiceMemory;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserController {

    private static UserController single_instance = null;

    public static UserController getInstance()
    {
        if (single_instance == null)
            single_instance = new UserController();
        return single_instance;
    }

    private Map<Long,User>users = new HashMap<>();

    private Service<User> service = new ServiceAbstract("users.bin");
    private Service<User> service_user = new ServiceMemory<>(users);

    public User getUser(int user_id){
        return service_user.get(user_id).get();
    }

    public Collection<User> users(){
        File file = new File("users.bin");
        if(file.exists()) {
            service.getAll().stream().forEach(x->service_user.create(x));
        }
        return service_user.getAll();
    }

    public boolean checkUserByLogin(String login){
        return checkUserByUsername(login);
    }

    public void addUser(User user){
        service_user.create(user);
    }

    public void saveInFile(){
        for(User user : users()){
            service.create(user);
        }
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
