package application;

import console.MenuLogIn;
import controller.UserController;
import entity.User;
import utils.Validator;

import java.util.Scanner;

public class LoginCommands {

    private static final Scanner sc = new Scanner(System.in);
    private static final UserController userController = new UserController();

    public static void logIn(){
        System.out.println("Username: ");
        String name = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();

        if(userController.checkUser(name,password)){
            System.out.println("Log in is successfully");
            long user_id = userController.getUserByNameAndPassword(name,password).getId();
            BookingPageCommands.commands(user_id);
        }else {
            System.out.println("your log in is wrong");

        }
    }

    public static void createAccount(){
        System.out.println("Username: ");
        String name = sc.nextLine();

        if(!Validator.getValidUser(name) ) {
            name = sc.nextLine();
        }
        if(userController.checkUserByLogin(name)){
            System.out.println("this username is available, please try new username");
            System.out.println("Username: ");
            name = sc.nextLine();
        }
        System.out.println("Password: ");
        String password = sc.nextLine();

        if(!Validator.getValidPassword(password)) {
            password = sc.nextLine();
        }
        System.out.println("again, Password: ");
        String password_again = sc.nextLine();
        if(password.equals(password_again)){
            long user_id = userController.getAll().size() + 1;
            User user = new User(user_id,name,password);
            userController.addUser(user);
        }else
            MenuLogIn.showLogInMenu();

    }
}
